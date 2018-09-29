package com.ys.inventory.mapper;

import com.ys.inventory.entity.Material;

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

    Material selectByPrimaryKey(String materialId);

    /**
     * 修改原料信息
     * @param material
     */
    void updateMaterial(Material material);

    List<Material> selectAll();

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
}