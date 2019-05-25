package com.sww.reflect.model;

import android.util.Log;

/**
 * 反射测试类
 */
public class TestBean {

    private static final String TAG = "ReflectActivity";

    private String name = "hello_sww";

    public TestBean() {
    }

    private TestBean(String name) {
        this.name = name;
    }

    /**
     * 测试反射获取构造函数
     */
    public String getName() {
        return name;
    }

    /**
     * 测试反射获取方法
     */
    public void testGetName(String name){
//    private void testGetName(){
        Log.e(TAG, "testGetName: "+name );
    }

}
