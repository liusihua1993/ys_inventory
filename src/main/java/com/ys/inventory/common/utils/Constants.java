package com.ys.inventory.common.utils;

public class Constants {

    /**
     * 接口用户存在redis中的token前缀key
     */
    public static final String CMP_LOGIN_KEY = "cmp_login_auth:";

    /**
     * 接口用户存在redis中的token响应时间
     */
    public static final String CMP_LOGIN_REDIS_KEY = "cmp_login_redis_storage_time.";
    /**
     * 字符串0 判断使用
     */
    public static final String ZERO = "0";

    /**
     * 字符串1 判断使用
     */
    public static final String ONE = "1";

    /**
     * 字符串2 判断使用
     */
    public static final String TWO = "2";
    /**
     * 字符串3 判断使用
     */
    public static final String THREE = "3";

    /**
     * 字符串6 判断使用
     */
    public static final String SIX = "6";

    /**
     * 正则_正整数
     */
    public static final String REGEX_POSITIVE_INTEGER = "^[1-9]\\d*$";

    /**
     * 拼接url地址使用 冒号:
     */
    public static final String COLON = ":";


    public static final String SYNCHRONIZATION_SYNC_COMPANY = "/synchronization/syncCompany";

    public static final String DATA = "data";
    public static final String SYNCHRONIZATION_SYNC_ORGAN = "/synchronization/syncOrgan";
    public static final String COMPANY_FLAG = "companyFlag";
}
