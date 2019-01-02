package com.ys.inventory.mapper;

import com.ys.inventory.dto.MaterialStockExcel;
import com.ys.inventory.entity.Material;
import com.ys.inventory.vo.MaterialSearchVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/9/27
 * @Description
 */
public interface MaterialMapper {
    /**
     * 新增原料信息
     * @param material
     * @return
     */
    int insert(Material material);

    /**
     * 修改原料信息
     * @param material
     */
    void updateMaterial(Material material);

    /**
     * 通过原料信息判断原料是否存在
     * @param mapperMap
     * @return
     */
    Material getMaterialByName(Map<String, String> mapperMap);

    /**
     * 获取原料信息
     * @param materialId
     * @return
     */
    Material get(String materialId);

    /**
     * 删除原料
     * @param mapperParam
     */
    void delete(Map<String, String> mapperParam);

    /**
     * 查询原料信息列表
     * @param material
     * @return
     */
    List<Material> find(MaterialSearchVO material);

    BigDecimal getMaterialNumberByMaterialId(String materialId);


    void insertBatch(ArrayList<Material> materialExcels);

    ArrayList<MaterialStockExcel> materialStockExport();
}