//package com.ys.inventory.controller;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.ys.inventory.common.core.Result;
//import com.ys.inventory.entity.ProductTemp;
//import com.ys.inventory.mapper.ProductTempMapper;
//import com.ys.inventory.service.ProductTempService;
//import io.swagger.annotations.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//
///**
// * @author liusihua.
// * @date 2018/09/04.
// */
//@Api(value = "ProductTemp ", tags = {"ProductTemp"})
//@RestController
//@RequestMapping("ProductTemp")
//public class ProductTempController {
//
//    Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Resource
//    private ProductTempService productTempService;
//    @Autowired(required = false)
//    private ProductTempMapper ProductTempMapper;
//
//
//    @ApiOperation(value = "添加产品模板")
//    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
//    @PostMapping("/add")
//    public Result add(@ApiParam(value = "ProductTemp json对象") @RequestBody ProductTemp productTemp) {
//        //查看产品模板是否存在
//        ProductTemp checkProductTempExist = productTempService.checkProductTempExistByProductTempName(productTemp.getProductTempName());
//        if (checkProductTempExist == null) {
//            productTempService.insert(productTemp);
//        } else {
//            return ResultGenerator.genFailResult("同名产品模板已存在,请进行修改.");
//        }
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @ApiOperation(value = "更新产品模板")
//    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
//    @PostMapping("/update")
//    public Result update(@ApiParam(value = "ProductTemp json对象") @RequestBody ProductTemp productTemp) {
//        productTempService.updateByPrimaryKey(productTemp);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @ApiOperation(value = "根据主键删除产品模板")
//    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
//    @GetMapping("/delete")
//    public Result delete(@ApiParam(value = "主键id") @RequestParam String id) {
//        productTempService.deleteByPrimaryKey(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @ApiOperation(value = "根据主键查询产品模板")
//    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = ProductTemp.class)})
//    @GetMapping("/detail")
//    public Result detail(@ApiParam(value = "主键id") @RequestParam String id) {
//        ProductTemp productTemp = productTempService.selectByPrimaryKey(id);
//        return ResultGenerator.genSuccessResult(productTemp);
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
//
//
//}
