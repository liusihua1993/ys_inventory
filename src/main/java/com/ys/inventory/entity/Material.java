package com.ys.inventory.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * 实体类对应的数据表为：  material
 *
 * @author mlink
 * @date 2018-09-03 16:20:00
 */
@Getter
@Setter
@Alias("Material")
public class Material extends BaseEntity{
    /**
     *主键
     */
    private String materialId;

    /**
     * 原料名称
     */
    private String materialName;

    /**
     * 原料数量
     */
    private Integer materialNum;

    /**
     * 原料描述
     */
    private String materialDescription;

}
