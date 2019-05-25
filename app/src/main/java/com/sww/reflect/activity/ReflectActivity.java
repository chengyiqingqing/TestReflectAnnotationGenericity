package com.sww.reflect.activity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.sww.genericity.BaseActivity;
import com.sww.reflect.R;
import com.sww.reflect.model.TestBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectActivity extends BaseActivity {

    private static final String TAG = "ReflectActivity";

    private Button button_constructor;
    private Button button_method;
    private Button button_field;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect);
        initView();
        initListener();
//        testGetConstructor();
//        testGetMethod();
        testGetField();
    }

    private void initView() {
        button_constructor = findViewById(R.id.button_constructor);
        button_method = findViewById(R.id.button_method);
        button_field = findViewById(R.id.button_field);
    }

    private void initListener() {
        button_constructor.setOnClickListener(v -> {
            testGetConstructor();
        });
        button_method.setOnClickListener(v -> {
            testGetMethod();
        });
        button_field.setOnClickListener(v -> {
            testGetField();
        });
    }

    /**
     * 反射解决的问题：new不出一个对象（可能使用private或hide了），所以通过反射去创建对象
     */
    public void testGetConstructor() {
        try {
            /**（方式1）获取公共的构造函数：
             * 【步骤1】Class.newInstance() 返回该Class对应的类对象
             */
//            TestBean testBean = TestBean.class.newInstance();
            /**（方式2）获取所有的构造函数
             *  【步骤1】Class.getDeclaredConstructor(参数.class,) :Contructror
             *  【步骤2】Constructor.setAccessible()  不然private修饰的构造函数会报【不可获取的异常】
             *  【步骤3】Constructor.newInstance()  : 强转为目标对象
             */
            Constructor constructor = TestBean.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            TestBean testBean = (TestBean) constructor.newInstance("青山不改绿水长流");
            Log.e(TAG, "initListener: " + testBean.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射解决的问题：方法被private或者hide，外界调用不到。那么反射调用该方法
     */
    public void testGetMethod(){

        /**(方法1)测试获取特定的方法
         * 【步骤1】getDeclaredMethod("testGetName",String.class)
         * 【步骤2】method.invoke(testBean,"hello_method")
         * 【说明】method.invoke调用中，勿忘参数类型String.class，实际参数"hello_method"
         */
//        try {
//            TestBean testBean = new TestBean();
//            Method  method = TestBean.class.getDeclaredMethod("testGetName",String.class);
//            method.setAccessible(true);
//            method.invoke(testBean,"hello_method");
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(TAG, "testGetMethod: "+e.getMessage() );
//        }
        /**(事例2)反射调用AssetManager的方法，拿到资源
         * 【步骤1】拿到AssetManager实例
         */
        try{
            AssetManager assetManager = AssetManager.class.newInstance();
            Method method = AssetManager.class.getDeclaredMethod("addAssetPath",String.class);
            int number = (int) method.invoke(assetManager,"sdcard/dds/red.skin");
            Log.e(TAG, "testGetMethod: "+number );
        }catch (Exception e){

        }
    }

    /**
     * 获取属性（很少用）
     */
    public void testGetField(){
        try {
            TestBean testBean = new TestBean();
            Field field = TestBean.class.getDeclaredField("name");
            field.setAccessible(true);
            String name = (String) field.get(testBean);
            Log.e(TAG, "testGetField: "+name );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**【特殊说明】三种调用方式的共同点就是都能拿到class对象。
     *  问题来了：ActivityThread连Class对象都拿不到，怎么通过反射调用它的属性或方法呢
     */
    public void testClassNameLoad() {
        try {
            // 利用反射获取系统的类做些坏事情
            Class clazz = Class.forName("android.app.ActivityThread");
            Field sCurrentActivityThread = clazz.getDeclaredField("sCurrentActivityThread");
            sCurrentActivityThread.setAccessible(true);
            // get里面为什么不放ActivityThread实例呢？因为对于静态属性，不属于对象，属于类。传null就可以了
            Object activityThread = sCurrentActivityThread.get(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
