package com.ys.inventory.mapper;

import com.ys.inventory.entity.Material;

import java.util.List;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/9/27
 * @Description
 */
public interface MaterialMapper {
    /**
     * 新增
     * @param material
     * @return
     */
    int insert(Material material);

    Material selectByPrimaryKey(String materialId);

    List<Material> selectAll();

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(Material record);

    Material getMaterialByName(String materialName);
}