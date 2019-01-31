package com.alphaomega.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <p>
 * 注解名：UnCheckTokenString
 * </p>
 * <p>
 * 描述：作用于controller，有此注解的方法不需要在调用前检查token权限，没有此注解的方法会在调用前检查token，失败则返回401
 * </p>
 * @author: <a href="mailto:MaJian@hanergy.com">马健</a>
 * @version: 1.0
 * @date: Augest 8, 2017
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnCheckTokenString {

}
