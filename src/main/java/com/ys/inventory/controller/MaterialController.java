package com.ys.inventory.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.inventory.common.core.Result;
import com.ys.inventory.common.core.ResultGenerator;
import com.ys.inventory.entity.Material;
import com.ys.inventory.service.MaterialService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;



/**
* @author liusihua.
* @date 2018/09/03.
*/
@Api(value="Material ",tags={"Material"})
@RestController
@RequestMapping("Material")
public class MaterialController {
    
     Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private MaterialService materialService;


    @ApiOperation(value = "添加原料")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Result.class)})
    @PostMapping("/add")
    public Result add(@ApiParam (value="Material json对象") @RequestBody Material material) {
        Material materialHasExistByName = materialService.checkMaterialHasExistByName(material.getMaterialName());
        if(materialHasExistByName!=null){
            Integer num1 = materialHasExistByName.getMaterialNum();
            Integer num2 = material.getMaterialNum();
            materialHasExistByName.setMaterialNum(num1+num2);
            materialService.updateByPrimaryKey(materialHasExistByName);
        }else {
            materialService.insert(material);
        }
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "更新原料")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Result.class)})
    @PostMapping("/update")
    public Result update(@ApiParam (value="Material json对象") @RequestBody Material material) {
        materialService.updateByPrimaryKey(material);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据主键删除原料")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Result.class)})
    @GetMapping("/delete")
    public Result delete(@ApiParam (value="主键id") @RequestParam String id) {
        materialService.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据主键查询原料")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Material.class)})
    @GetMapping("/detail")
    public Result detail(@ApiParam (value="主键id") @RequestParam String id) {
        Material material = materialService.selectByPrimaryKey(id);
        return ResultGenerator.genSuccessResult(material);
    }


    @ApiOperation(value = "查询全部原料")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Material.class)})
    @GetMapping("/queryAll")
    public Result queryAll(@ApiParam (value="请求第几页") @RequestParam(defaultValue = "0") Integer page,
                           @ApiParam (value="每页个数") @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Material> list;

        list = materialService.selectAll();

        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


}
