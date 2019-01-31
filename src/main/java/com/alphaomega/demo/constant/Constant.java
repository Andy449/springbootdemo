package com.alphaomega.demo.constant;

public class Constant {

    /** 成功标识 */
    public static final String SUCCESS_FLG = "SUCCESS";
    
    /** 失败标识 */
    public static final String FAIL_FLG = "FAIL";
    
    public static int USER_TOKEN_VALID_TIME = 30 * 60 * 60;  //30天
    
    /** 密码在使用MD5加密时所使用的盐，加盐方式为salt+passowrd */
    public static final String PASSWORD_SALT = "SMART_SECURITY";
    
    /** 生成Token的加密字符串 */
    public static final String TOKEN_SECRET_KEY = "SJBOX_SECURITY";
}
