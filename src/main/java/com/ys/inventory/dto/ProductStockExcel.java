package com.ys.inventory.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author LSH
 * @version 1.1
 * @date 2019/1/2
 * @Description
 */
@Getter
@Setter
public class ProductStockExcel {
    @Excel(name = "产品名称", width = 25)
    private String productName;

    @Excel(name = "库存数量", width = 25,orderNum = "1")
    private Integer productNum;
}
