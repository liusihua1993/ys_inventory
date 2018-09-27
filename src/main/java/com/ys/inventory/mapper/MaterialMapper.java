package com.ys.inventory.mapper;

import com.ys.inventory.entity.Material;
import java.util.List;

public interface MaterialMapper {
    int insert(Material record);

    Material selectByPrimaryKey(String materialId);

    List<Material> selectAll();

    int updateByPrimaryKey(Material record);

    Material checkMaterialHasExistByName(String materialName);
}