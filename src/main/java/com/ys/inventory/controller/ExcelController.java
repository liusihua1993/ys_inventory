package com.ys.inventory.controller;

import com.ys.inventory.common.core.Result;
import com.ys.inventory.service.ExcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/12/10
 * @Description
 */
@Api(value = "Excel ", tags = {"Excel"})
@RestController
@RequestMapping("/excel")
public class ExcelController {


    @Resource
    private ExcelService excelService;

    @ApiOperation(value = "产品初始导出")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
    @GetMapping(value = "/productInitExport")
    public void productInitExport(HttpServletResponse response) {
        excelService.productInitExport(response);
    }


    @ApiOperation(value = "产品初始导入")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
    @PostMapping(value = "/productInitImport")
    public void productInitImport(@RequestParam(value = "file", required = false) MultipartFile file, String userId) throws Exception {
        excelService.productInitImport(file, userId);
    }


    @ApiOperation(value = "原料初始导出")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
    @GetMapping(value = "/materialInitExport")
    public void materialInitExport(HttpServletResponse response) {
        excelService.materialInitExport(response);
    }

    @ApiOperation(value = "原料初始导入")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
    @PostMapping(value = "/materialInitImport")
    public void materialInitImport(@RequestParam(value = "file", required = false) MultipartFile file, String userId) throws Exception {
        excelService.materialInitImport(file, userId);
    }
}
