package com.ys.inventory.service;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.export.styler.ExcelExportStylerBorderImpl;
import com.ys.inventory.common.exception.BusinessException;
import com.ys.inventory.common.utils.ExcelUtil;
import com.ys.inventory.common.utils.Utils;
import com.ys.inventory.dto.ProductExcel;
import com.ys.inventory.entity.Product;
import com.ys.inventory.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/12/10
 * @Description
 */
public class ExcelService {

    @Autowired(required = false)
    private ProductMapper productMapper;

    public void productInitExport(HttpServletResponse response) {
        ArrayList<ProductExcel> list = new ArrayList<>();
        try {
            ExportParams exportParams = new ExportParams();
            exportParams.setSheetName("产品初始导入");
            exportParams.setStyle(ExcelExportStylerBorderImpl.class);
            ExcelUtil.exportExcel(list, exportParams, ProductExcel.class, "产品初始导入.xls", response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void productInitImport(MultipartFile file, String userId) throws Exception {
        if (file == null) {
            throw new BusinessException("上传文件内容为空");
        }
        List<ProductExcel> productExcelList = ExcelUtil.importExcel(file, 0, 1, ProductExcel.class);
        ArrayList<Product> products = new ArrayList<>();
        for (ProductExcel productExcel : productExcelList) {
            Product product = new Product();
            product.setProductId(Utils.getUUID());
            product.setProductName(productExcel.getProductName());
            product.setProductNum(productExcel.getProductNum());
            product.setProductDescription(productExcel.getProductDescription());
            product.setCreateUser(userId);
            products.add(product);
        }
        productMapper.insertBatch(products);
    }
}
