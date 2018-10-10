package com.ys.inventory.common.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gp
 * @version 2018/01/09
 */
public class DateUtil extends DateUtils {

    /**
     * 获取系统日期时间
     * @return
     */
    public static String getSystemDate(){
        return getSystemDate("yyyyMMdd");
    }

    /**
     * 获取系统日期时间
     * @param format 日期格式
     * @return 返回当前系统时间
     */
    public static String getSystemDate(String format){
        if(format == null || format.length() == 0){
            format = "yyyyMMdd";
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
