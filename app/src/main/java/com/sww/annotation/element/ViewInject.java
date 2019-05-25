package com.sww.annotation.element;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * 注解类
 */
public class ViewInject {

    public static void inject(Activity activity){
        // 1.获取所有的属性
        Field[] declaredFields = activity.getClass().getDeclaredFields();
        // 2.过滤关于ViewById属性
        for (Field field : declaredFields) {
            BindViewById bindViewById = field.getAnnotation(BindViewById.class);
            if (bindViewById!=null){
                // 3.findViewById 【通过id创建View】
                View view = activity.findViewById(bindViewById.value());
                // 4.反射注入【将3创建的view和给属性赋值】
                field.setAccessible(true);
                try {
                    field.set(activity,view);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }


    }

}
