package com.sww.genericity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sww.annotation.AnnotationActivity;

public class GenericityActivity extends BaseActivity {

    // 类泛型
    MyArrayList<String> myArrayList = new MyArrayList<>();
    // 方法泛型
    MethodGenericity methodGenericity;
    // 泛型下限（有下限）

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myArrayList.add("hello");
        myArrayList.add("sww");
        // 方法泛型
//        startActivity(ReflectActivity.class);
        // 泛型上限（任意匹配和上同）
//        startActivity1(ReflectActivity.class);
        // 泛型上限（有上限）
//        startActivity2(AnnotationActivity.class);
        // 泛型下限；
        startActivity3(GenericityActivity.class);
    }

}
