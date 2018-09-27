package com.ys.inventory.service;

import com.ys.inventory.entity.Material;
import com.ys.inventory.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.UUID;

/**
 * @author liusihua.
 * @date 2018/09/03.
 * 注:  需要回归接口添加 注解 ：@Transactional(rollbackFor = Exception.class)
 */


@Service
@EnableTransactionManagement
public class MaterialService  {
    @Autowired(required = false)
    private MaterialMapper materialMapper;

    public void insert(Material material) {
        material.setMaterialId(UUID.randomUUID().toString().replaceAll("-", ""));
        material.setCreateTime(System.currentTimeMillis());
        material.setUpdateTime(System.currentTimeMillis());
        material.setDeleteFlag("0");
        materialMapper.insert(material);
    }

    public void updateByPrimaryKey(Material material) {
        material.setUpdateTime(System.currentTimeMillis());
        materialMapper.updateByPrimaryKey(material);
    }

    public Material checkMaterialHasExistByName(String materialName) {
        return materialMapper.checkMaterialHasExistByName(materialName);
    }

    public void deleteByPrimaryKey(String id) {
        Material material = new Material();
        material.setMaterialId(id);
        material.setDeleteFlag("1");
        material.setUpdateTime(System.currentTimeMillis());
        materialMapper.updateByPrimaryKey(material);
    }

    public Material selectByPrimaryKey(String id) {
        return materialMapper.selectByPrimaryKey(id);
    }

    public List<Material> selectAll() {
        return materialMapper.selectAll();
    }
}


