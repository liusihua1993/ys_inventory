package com.ys.inventory.controller;

import com.ys.inventory.common.core.Result;
import com.ys.inventory.entity.ProductTemp;
import com.ys.inventory.mapper.ProductTempMapper;
import com.ys.inventory.service.ProductTempService;
import com.ys.inventory.vo.ProductTempInsertVO;
import com.ys.inventory.vo.ProductTempUpdateVO;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author liusihua.
 * @date 2018/09/04.
 */
@Api(value = "ProductTemp ", tags = {"ProductTemp"})
@RestController
@RequestMapping("/productTemp")
public class ProductTempController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ProductTempService productTempService;
    @Autowired(required = false)
    private ProductTempMapper ProductTempMapper;


    @ApiOperation(value = "添加产品模板")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
    @PostMapping
    public void add(@ApiParam(value = "ProductTemp json对象") @RequestBody ProductTempInsertVO vo) {
        productTempService.insert(vo);

    }

    @ApiOperation(value = "更新产品模板")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
    @PutMapping(value = "/{productTempId}/updateProductTemp")
    public void update(@ApiParam(value = "productTempId") @PathVariable String productTempId,
            @ApiParam(value = "ProductTemp json对象") @RequestBody ProductTempUpdateVO vo) {
        vo.setProductTempId(productTempId);
        productTempService.updateProductTemp(vo);
    }

    @ApiOperation(value = "根据主键查询产品模板")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = ProductTemp.class)})
    @GetMapping("/{productTempId}")
    public ProductTemp get(@ApiParam(value = "主键id") @PathVariable String productTempId) {
        return productTempService.get(productTempId);
    }

//    @ApiOperation(value = "根据主键删除产品模板")
//    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
//    @GetMapping("/delete")
//    public Result delete(@ApiParam(value = "主键id") @RequestParam String id) {
//        productTempService.deleteByPrimaryKey(id);
//        return ResultGenerator.genSuccessResult();
//    }


//
//
//    @ApiOperation(value = "查询全部产品模板")
//    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = ProductTemp.class)})
//    @GetMapping("/queryAll")
//    public Result queryAll(@ApiParam(value = "请求第几页") @RequestParam(defaultValue = "0") Integer page,
//                           @ApiParam(value = "每页个数") @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<ProductTemp> list = productTempService.selectAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }


}
