package com.ys.inventory.controller;


import com.ys.inventory.common.core.Result;
import com.ys.inventory.common.utils.Page;
import com.ys.inventory.entity.Product;
import com.ys.inventory.mapper.ProductMapper;
import com.ys.inventory.service.ProductService;
import com.ys.inventory.vo.ProductInsertVO;
import com.ys.inventory.vo.ProductSearchVO;
import com.ys.inventory.vo.ProductUpdateVO;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author liusihua.
 * @date 2018/09/11.
 */
@Api(value = "Product ", tags = {"Product"})
@RestController
@RequestMapping("/product")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ProductService productService;

    @Autowired(required = false)
    private ProductMapper ProductMapper;


    @ApiOperation(value = "添加Product实体")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
    @PostMapping
    public void add(@ApiParam(value = "Product json对象") @RequestBody ProductInsertVO vo) {
        productService.insert(vo);
    }


    @ApiOperation(value = "更新Product")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
    @PutMapping(value = "/{productId}/updateProduct")
    public void update(@ApiParam(value = "产品id", required = true) @PathVariable String productId,
                       @ApiParam(value = "待更新的产品", required = true) @RequestBody ProductUpdateVO vo) {
        vo.setProductId(productId);
        productService.updateProduct(vo);
    }

    @ApiOperation(value = "根据主键删除对象")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
    @DeleteMapping("/{productId}/{updateTime}")
    public void delete(@ApiParam(value = "产品ID", required = true) @PathVariable String productId,
                       @ApiParam(value = "更新时间", required = true) @PathVariable String updateTime) {
        productService.delete(productId, updateTime);
    }


    @ApiOperation(value = "根据主键查询对象")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Product.class)})
    @GetMapping("/{productId}")
    public Product detail(@ApiParam(value = "主键id") @PathVariable String productId) {
        return productService.get(productId);
    }


    @ApiOperation(value = "查询全部")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Product.class)})
    @GetMapping
    public Page<Product> find(@ApiParam("查询条件") ProductSearchVO product) {
        return productService.find(product);
    }


}
