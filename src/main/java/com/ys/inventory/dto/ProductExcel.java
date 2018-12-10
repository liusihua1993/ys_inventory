package com.ys.inventory.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/12/10
 * @Description
 */
@Getter
@Setter
public class ProductExcel {

    @Excel(name = "产品名称", width = 25)
    private String productName;

    @Excel(name = "库存数量", width = 25,orderNum = "1")
    private Integer productNum;

    @Excel(name = "产品描述", width = 25,orderNum = "2")
    private String productDescription;
}
