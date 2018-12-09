package com.ys.inventory.controller;

import com.ys.inventory.common.core.Result;
import com.ys.inventory.common.utils.Page;
import com.ys.inventory.entity.ProductTemp;
import com.ys.inventory.mapper.ProductTempMapper;
import com.ys.inventory.service.ProductTempService;
import com.ys.inventory.system.log.annotation.LogAction;
import com.ys.inventory.system.log.annotation.LogModule;
import com.ys.inventory.vo.ProductTempInsertVO;
import com.ys.inventory.vo.ProductTempSearchVO;
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
@LogModule(moduleName = "产品模板")
public class ProductTempController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ProductTempService productTempService;
    @Autowired(required = false)
    private ProductTempMapper ProductTempMapper;


    @ApiOperation(value = "添加产品模板")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
    @LogAction(value = "添加产品模板")
    @PostMapping
    public void add(@ApiParam(value = "ProductTemp json对象") @RequestBody ProductTempInsertVO vo) {
        productTempService.insert(vo);

    }

    @ApiOperation(value = "修改产品模板")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
    @LogAction(value = "修改产品模板")
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

    @ApiOperation(value = "根据主键删除产品模板")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
    @LogAction(value = "删除产品模板")
    @DeleteMapping("/{productTempId}/{updateTime}")
    public void delete(@ApiParam(value = "主键id") @PathVariable String productTempId,
                       @ApiParam(value = "修改时间") @PathVariable String updateTime) {
        productTempService.delete(productTempId,updateTime);
    }

    @ApiOperation(value = "查询全部产品模板")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = ProductTemp.class)})
    @GetMapping
    public Page<ProductTemp> find(@ApiParam(value = "查询json")ProductTempSearchVO vo) {
        return productTempService.find(vo);
    }
}
