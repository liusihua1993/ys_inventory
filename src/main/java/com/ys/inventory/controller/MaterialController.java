package com.ys.inventory.controller;

import com.ys.inventory.common.core.Result;
import com.ys.inventory.entity.Material;
import com.ys.inventory.service.MaterialService;
import com.ys.inventory.vo.MaterialInsertVo;
import com.ys.inventory.vo.MaterialUpdateVo;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
* @author liusihua.
* @date 2018/09/03.
*/
@Api(value="Material ",tags={"Material"})
@RestController
@RequestMapping("/material")
public class MaterialController {
    
     Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MaterialService materialService;


    @ApiOperation(value = "添加原料")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Result.class)})
    @PostMapping
    public void add(@ApiParam(value = "待插入的原料信息", required = true) @RequestBody MaterialInsertVo vo) {
        materialService.insert(vo);
    }

    @ApiOperation(value = "更新原料")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Result.class)})
    @PutMapping(value = "/{materialId}/updateMaterial")
    public void update(@ApiParam(value = "原料id", required = true) @PathVariable String materialId,
                         @ApiParam(value = "待更新的公司", required = true) @RequestBody MaterialUpdateVo vo) {
        vo.setMaterialId(materialId);
        materialService.updateMaterial(vo);
    }

    @ApiOperation(value = "根据主键查询原料")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Material.class)})
    @GetMapping(value = "/{materialId}")
    public Material get(@ApiParam (value="主键id") @PathVariable String materialId) {
        return materialService.get(materialId);
    }

    @ApiOperation(value = "删除原料")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Result.class)})
    @DeleteMapping("/{materialId}/{updateTime}")
    public void delete(@ApiParam(value = "原料ID", required = true) @PathVariable String materialId,
                       @ApiParam(value = "更新时间", required = true) @PathVariable String updateTime) {
        materialService.delete(materialId,updateTime);
    }
//
//
//    @ApiOperation(value = "查询全部原料")
//    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Material.class)})
//    @GetMapping("/queryAll")
//    public Result queryAll(@ApiParam (value="请求第几页") @RequestParam(defaultValue = "0") Integer page,
//                           @ApiParam (value="每页个数") @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<Material> list;
//
//        list = materialService.selectAll();
//
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }


}
