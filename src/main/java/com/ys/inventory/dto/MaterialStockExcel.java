package com.ys.inventory.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author LSH
 * @version 1.1
 * @date 2019/1/2
 * @Description
 */
@Getter
@Setter
public class MaterialStockExcel {
    @Excel(name = "原料名称", width = 25)
    private String materialName;

    @Excel(name = "原料库存", width = 25,orderNum = "1")
    private BigDecimal materialNum;
}
