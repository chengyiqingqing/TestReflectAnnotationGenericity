package com.sww.genericity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    /**
     * Clazz<T>那个类的class都行【先方法声明<T>】;
     */
    public <T> void startActivity(Class<T> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * ？是通配符，代表任意类型。
     * String也可以传，这样就不好了。
     */
    public void startActivity1(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * 只能使用继承至AppCompatActivity的类；
     */
    public void startActivity2(Class<? extends AppCompatActivity> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * 只能使用GenericityActivity的父类；
     */
    public void startActivity3(Class<? super GenericityActivity> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

}
