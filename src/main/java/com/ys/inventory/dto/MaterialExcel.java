package com.ys.inventory.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/12/10
 * @Description
 */
@Getter
@Setter
public class MaterialExcel {
    @Excel(name = "原料名称", width = 25)
    private String materialName;

    @Excel(name = "原料数量", width = 25,orderNum = "1")
    private BigDecimal materialNum;

    @Excel(name = "原料描述", width = 25,orderNum = "2")
    private String materialDescription;
}
