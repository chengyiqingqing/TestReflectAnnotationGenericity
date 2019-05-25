package com.sww;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.sww.reflect.R;
import com.sww.reflect.activity.ReflectActivity;

public class MainActivity extends AppCompatActivity {

    private Button button_reflect;
    private Button button_annotation;
    private Button button_genericity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        button_reflect = findViewById(R.id.button_reflect);
        button_annotation = findViewById(R.id.button_annotation);
        button_genericity = findViewById(R.id.button_genericity);
    }

    private void initListener() {
        button_reflect.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ReflectActivity.class));
        });
        button_annotation.setOnClickListener(v -> {

        });
        button_genericity.setOnClickListener(v -> {

        });
    }

}
