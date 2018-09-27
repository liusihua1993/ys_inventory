package com.ys.inventory.common.utils;

import java.util.UUID;

/**
 *
 * @author lsh
 * @version 2018/07/12
 */
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
