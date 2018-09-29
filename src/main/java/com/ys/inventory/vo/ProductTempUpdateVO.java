package com.ys.inventory.vo;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 实体类对应的数据表为：  product_temp
 * @author mlink
 * @date 2018-09-04 10:47:47
 */
@ApiModel(value ="产品模板表")
@Getter
@Setter
@ToString
public class ProductTempUpdateVO extends ProductTempInsertVO{

}
