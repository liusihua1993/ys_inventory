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
     * 使用产品模板id
     */
    private String productTempId;

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

    public Product(String productId, String productName, String productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
    }

    public Product(String productId, String productTempId, String productName, String productDescription, Integer productNum) {
        this.productId = productId;
        this.productTempId = productTempId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productNum = productNum;
    }
}
