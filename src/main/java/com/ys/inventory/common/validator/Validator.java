package com.ys.inventory.common.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author wyh
 * @version 2017/12/15.
 */
public class Validator {
    /**
     * 校验对象是否为空
     * @param object 待校验的对象
     * @param message 校验失败时的错误信息
     * @throws ValidatorException 校验失败抛出异常
     */
    public static void notNull(Object object, String message) throws ValidatorException {
        if (object == null) {
            throw new ValidatorException(message);
        }
    }

    /**
     * 校验值是否为true
     * @param bool 待校验的对象
     * @param message 校验失败时的错误信息
     */
    public static void isTrue(boolean bool, String message) {
        if (!bool) {
            throw new ValidatorException(message);
        }
    }

    /**
     * 校验两个对象是否相等
     * @param object 待校验的对象
     * @param object 待校验的另一个对象
     * @param message 校验失败时的错误信息
     */
    public static void equals(Object object,Object other, String message) {
        if (!Objects.equals(object,other)) {
            throw new ValidatorException(message);
        }
    }

    /**
     * 校验两个对象是否不相等
     * @param object 待校验的对象
     * @param object 待校验的另一个对象
     * @param message 校验失败时的错误信息
     */
    public static void notEquals(Object object,Object other, String message) {
        if (!Objects.equals(object,other)) {
            throw new ValidatorException(message);
        }
    }

    /**
     * 校验文本是否为非空字符串
     * @param text 待校验的文本
     * @param message 校验失败时的错误信息
     */
    public static void hasText(String text, String message){
        if(StringUtils.isBlank(text)){
            throw new ValidatorException(message);
        }
    }

    /**
     * 验证一个字符串是否是字母组成
     * @param str 待校验的字符串
     * @param message 校验失败时的错误信息
     */
    public static void isAlpha(String str, String message){
        if(!StringUtils.isAlpha(str)){
            throw new ValidatorException(message);
        }
    }

    /**
     * 验证一个字符串是否是数字组成
     * @param str 待校验的字符串
     * @param message 校验失败时的错误信息
     */
    public static void isNumber(String str, String message){
        if(!ValidateUtil.isNumber(str)){
            throw new ValidatorException(message);
        }
    }

    /**
     * 验证一个字符串是否是数字、字母组成
     * @param str 待校验的字符串
     * @param message 校验失败时的错误信息
     */
    public static void isAlphaNumeric(String str, String message){
        if(!StringUtils.isAlphanumeric(str)){
            throw new ValidatorException(message);
        }
    }

    /**
     * 验证一个字符串是否是数字、字母和中文组成
     * @param str 待校验的字符串
     * @param message 校验失败时的错误信息
     */
    public static void isAplhaNumericChinese(String str, String message){
        if(!ValidateUtil.isAplhaNumericChinese(str)){
            throw new ValidatorException(message);
        }
    }

    /**
     * 验证一个字符串是否是整形
     * @param str 待校验的字符串
     * @param message 校验失败时的错误信息
     */
    public static void isInteger(String str, String message){
        if(!ValidateUtil.isInteger(str)){
            throw new ValidatorException(message);
        }
    }

    /**
     * 验证一个字符串是否是Float类型
     * @param str 待校验的字符串
     * @param message 校验失败时的错误信息
     */
    public static void isFloat(String str, String message){
        if(!ValidateUtil.isFloat(str)){
            throw new ValidatorException(message);
        }
    }

    /**
     * 验证一个字符串是否是Double类型
     * @param str 待校验的字符串
     * @param message 校验失败时的错误信息
     */
    public static void isDouble(String str, String message){
        if(!ValidateUtil.isDouble(str)){
            throw new ValidatorException(message);
        }
    }

    /**
     * 校验身份证号码是否正确
     * @param id 待校验的字符串
     * @param message 校验失败时的错误信息
     */
    public static void isIDCard(String id, String message){
        if(!ValidateUtil.isIDCard(id)){
            throw new ValidatorException(message);
        }
    }

    /**
     * 校验手机号码是否正确
     * @param phone 待校验的字符串
     * @param message 校验失败时的错误信息
     */
    public static void isPhone(String phone, String message){
        if(!ValidateUtil.isPhone(phone)){
            throw new ValidatorException(message);
        }
    }

    /**
     * 校验email是否为正确电子邮箱格式
     * @param email 待校验的字符串
     * @param message 校验失败时的错误信息
     */
    public static void isEmail(String email, String message){
        if(!ValidateUtil.isEmail(email)){
            throw new ValidatorException(message);
        }
    }
}
