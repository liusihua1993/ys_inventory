package com.ys.inventory.service;

import com.ys.inventory.common.exception.BusinessException;
import com.ys.inventory.common.utils.Constants;
import com.ys.inventory.common.utils.SecurityUtil;
import com.ys.inventory.common.utils.UUIDUtil;
import com.ys.inventory.common.validator.Validator;
import com.ys.inventory.entity.Material;
import com.ys.inventory.mapper.MaterialMapper;
import com.ys.inventory.vo.MaterialInsertVo;
import com.ys.inventory.vo.MaterialUpdateVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liusihua.
 * @date 2018/09/03.
 * 注:  需要回归接口添加 注解 ：@Transactional(rollbackFor = Exception.class)
 */


@Service
@EnableTransactionManagement
public class MaterialService {
    @Autowired(required = false)
    private MaterialMapper materialMapper;

    public void insert(MaterialInsertVo vo) {
        // 插入验证
        ValidatorInsert(vo);
        Map<String, String> mapperMap = new HashMap<>(1);
        mapperMap.put("materialName", vo.getMaterialName());
        //查看是否有同名的
        Material material = materialMapper.getMaterialByName(mapperMap);
        if (material != null) {
            //抛异常不能新增
            throw new BusinessException("203","已存在相同原料,请尝试添加原料数量.");
        } else {
            materialMapper.insert(createInsertMaterial(vo));
        }
    }

    private Material createInsertMaterial(MaterialInsertVo vo) {
        Material material = new Material();
        material.setMaterialNum(Integer.valueOf(vo.getMaterialNum()));
        material.setMaterialName(vo.getMaterialName());
        material.setMaterialId(UUIDUtil.getUUID());
        material.setMaterialDescription(vo.getMaterialDescription());
        material.setCreateUser(SecurityUtil.getUserId());
        return material;
    }

    public void updateMaterial(MaterialUpdateVo vo) {
        Map<String, String> mapperMap = new HashMap<>(2);
        mapperMap.put("materialId", vo.getMaterialId());
        mapperMap.put("materialName", vo.getMaterialName());
        //查看是否有同名的
        Material material = materialMapper.getMaterialByName(mapperMap);
        if (material != null) {
            //抛异常不能修改
            throw new BusinessException("203","已存在相同原料,修改失败.");
        } else {
            materialMapper.updateMaterial(createUpdateMaterial(vo));
        }

    }

    private Material createUpdateMaterial(MaterialUpdateVo vo) {
        Material material = new Material();
        material.setMaterialId(vo.getMaterialId());
        material.setMaterialName(vo.getMaterialName());
        material.setMaterialDescription(vo.getMaterialDescription());
        material.setUpdateUser(SecurityUtil.getUserId());
        return material;
    }

    private void ValidatorInsert(MaterialInsertVo vo) {
        // 原料名称
        Validator.notNull(vo.getMaterialName(), "原料名称不能为空");
        checkLength(vo.getMaterialName(), 100, "公司名称长度不得超过 100 个字符");
        // 原料数量
        Validator.notNull(vo.getMaterialNum(), "个数不能为空");
        if (!vo.getMaterialNum().matches(Constants.REGEX_POSITIVE_INTEGER) || vo.getMaterialNum().length() > Integer.valueOf(Constants.SIX)) {
            throw new BusinessException("个数只能输入正整数,并且长度不得超过6位数");
        }
        // 原料描述
        Validator.notNull(vo.getMaterialDescription(), "原料描述不能为空");
        checkLength(vo.getMaterialDescription(), 255, "原料描述长度不得超过 255 个字符");
    }

    public void deleteByPrimaryKey(String id) {
//        Material material = new Material();
//        material.setMaterialId(id);
//        material.setDeleteFlag("1");
//        material.setUpdateTime(System.currentTimeMillis());
//        materialMapper.updateByPrimaryKey(material);
    }

    public Material selectByPrimaryKey(String id) {
        return materialMapper.selectByPrimaryKey(id);
    }

    public List<Material> selectAll() {
        return materialMapper.selectAll();
    }

    private void checkLength(String str, int length, String message) {
        if (StringUtils.isNotEmpty(str) && str.length() > length) {
            throw new BusinessException(message);
        }
    }
}


