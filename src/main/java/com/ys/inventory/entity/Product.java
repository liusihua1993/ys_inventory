package com.ys.inventory.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * 实体类对应的数据表为：  product
 *
 * @author mlink
 * @date 2018-09-11 20:07:08
 */
@Getter
@Setter
@Alias("Product")
public class Product extends BaseEntity {
    /**
     * 主键
     */
    private String productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品描述
     */
    private String productDescription;

    /**
     * 产品数量
     */
    private Integer productNum;

    /**
     * vo
     */
    private String productTempName;

    private String userName;

}
