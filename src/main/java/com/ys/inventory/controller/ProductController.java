//package com.ys.inventory.controller;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.ys.inventory.common.core.Result;
//import com.ys.inventory.entity.Product;
//import com.ys.inventory.mapper.ProductMapper;
//import com.ys.inventory.service.ProductService;
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
//
///**
//* @author liusihua.
//* @date 2018/09/11.
//*/
//@Api(value="Product ",tags={"Product"})
//@RestController
//@RequestMapping("Product")
//public class ProductController {
//
//     Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Resource
//    private ProductService productService;
//    @Autowired(required = false)
//    private ProductMapper ProductMapper;
//
//
//    @ApiOperation(value = "添加Product实体")
//    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Result.class)})
//    @PostMapping("/add")
//    public Result add(@ApiParam (value="Product json对象") @RequestBody Product product) {
//        productService.insert(product);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @ApiOperation(value = "更新Product")
//    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Result.class)})
//    @PostMapping("/update")
//    public Result update(@ApiParam (value="Product json对象") @RequestBody Product product) {
//        productService.updateByPrimaryKey(product);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @ApiOperation(value = "根据主键删除对象")
//    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Result.class)})
//    @GetMapping("/delete")
//    public Result delete(@ApiParam (value="主键id") @RequestParam String id) {
//        productService.deleteByPrimaryKey(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @ApiOperation(value = "根据主键查询对象")
//    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Product.class)})
//    @GetMapping("/detail")
//    public Result detail(@ApiParam (value="主键id") @RequestParam String id) {
//        Product product = ProductMapper.selectByPrimaryKey(id);
//        return ResultGenerator.genSuccessResult(product);
//    }
//
//
//    @ApiOperation(value = "查询全部")
//    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Product.class)})
//    @GetMapping("/queryAll")
//    public Result queryAll(@ApiParam (value="请求第几页") @RequestParam(defaultValue = "0") Integer page,
//                           @ApiParam (value="每页个数") @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<Product> list;
//
//        list = ProductMapper.selectAll();
//
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
//
//
//}
