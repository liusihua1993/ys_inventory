package com.ys.inventory.system.log.mapper;


import com.ys.inventory.system.log.entity.Log;
import com.ys.inventory.system.log.vo.LogInsertVO;
import com.ys.inventory.system.log.vo.LogSearchVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gp
 * @version 2018/06/20
 */
@Repository
public interface LogMapper {

    /**
     * 查询日志
     * @param vo
     * @return
     */
    List<Log> find(LogSearchVO vo);

    /**
     * 插入日志
     * @param vo
     */
    void insert(LogInsertVO vo);

    /**
     * 根据传入参数来删除多少个月日志
     * @param month
     */
    void delete(int month);

}
