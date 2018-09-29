package com.ys.inventory.common.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 页
 * @author wyh
 * @version 2017/12/7.
 */
@Setter
@Getter
public class Page<T> {
    /** 页码，从1开始  */
    private Integer page;
    /** 每页记录数  */
    private Integer limit;
    /** 总记录数  */
    private Integer total;
    /** 当前页记录  */
    private List<T> data;

    public Page(){}

    /**
     * 构造分页对象
     * @param list 如果传入参数不是com.github.pagehelper.Page对象，
     * 则构造只有一页，但不限记录数的分页对象
     */
    public Page(List<T> list){
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page<T> phPage = (com.github.pagehelper.Page<T>) list;
            this.page = phPage.getPageNum();
            this.limit = phPage.getPageSize();
            this.total = Integer.parseInt(phPage.getTotal()+"");
            this.data = phPage.getResult();
        } else {
            this.page = 1;
            this.limit = -1;
            this.total = list.size();
            this.data = list;
        }
    }
}
