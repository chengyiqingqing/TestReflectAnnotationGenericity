package com.sww.annotation.element;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target放在哪里：FIELD属性，METHOD方法，TYPE类
@Target(ElementType.FIELD)
// @Retention什么时候起作用：runtime运行时，class编译（打包）时，source编码阶段
@Retention(RetentionPolicy.RUNTIME)
public @interface BindViewById {// @interface代表注解

    //注解元素参数类型为int：@BindViewById(R.id.xxx);
    int value();


}
