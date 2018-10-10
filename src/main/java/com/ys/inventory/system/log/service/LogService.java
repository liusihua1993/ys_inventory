package com.ys.inventory.system.log.service;


import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.github.pagehelper.PageHelper;
import com.ys.inventory.common.utils.DateUtil;
import com.ys.inventory.common.utils.Page;
import com.ys.inventory.system.log.entity.Log;
import com.ys.inventory.system.log.mapper.LogMapper;
import com.ys.inventory.system.log.vo.LogInsertVO;
import com.ys.inventory.system.log.vo.LogSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author gp
 * @version 2018/06/20
 */
@Service
public class LogService {

    @Autowired
    LogMapper mapper;

    /**
     * 查询日志
     * @param vo
     * @return
     */
    public Page<Log> find(LogSearchVO vo){
        PageHelper.startPage(vo);
        List<Log> list = mapper.find(vo);
        return new Page<>(list);
    }

    /**
     * 插入日志
     * @param vo
     */
    @Transactional(rollbackFor = Exception.class)
    public void insert(LogInsertVO vo){
        mapper.insert(vo);
    }

    /**
     * 删除log记录
     */
    public void delete(int month){
        mapper.delete(month);
    }

    /**
     * 导出文件
     * @param vo
     * 检索条件
     * @return 返回导出数据
     */
    public byte[] downloadFile(LogSearchVO vo) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b = null;
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0,Log.class);
            writer.write(mapper.find(vo), sheet1);
            writer.finish();
            b = out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    /**
     * 获取下载文件名
     * @return 返回文件名
     */
    public String generateFileName() {
        return "Log_" + DateUtil.getSystemDate() +".xlsx";
    }
}
