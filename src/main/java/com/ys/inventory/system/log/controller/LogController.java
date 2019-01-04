package com.ys.inventory.system.log.controller;

import com.ys.inventory.common.core.Result;
import com.ys.inventory.common.utils.DownloadUtil;
import com.ys.inventory.system.log.service.LogService;
import com.ys.inventory.system.log.vo.LogSearchVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gp
 * @version 2018/06/20
 */
@Api( tags = "log", description = "业务日志")
@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    LogService service;

    @ApiOperation("查询日志")
    @GetMapping
    public Result find(@ApiParam("查询条件")LogSearchVO vo){
        return Result.ok(service.find(vo));
    }

    @ApiOperation(value = "下载")
    @GetMapping(value = "/download")
    public ResponseEntity<byte[]> download(@ApiParam("查询条件") LogSearchVO vo) throws Exception{
        return DownloadUtil.download(service.downloadFile(vo),service.generateFileName());
    }

    @ApiOperation(value = "删除无效日志")
    @GetMapping(value = "/deleteContentIsNull")
    public Result deleteContentIsNull() throws Exception{
        service.deleteContentIsNull();
        return Result.ok();
    }
}
