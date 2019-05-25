package com.sww.annotation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.sww.annotation.element.BindViewById;
import com.sww.reflect.R;

public class AnnotationActivity extends AppCompatActivity {

    @BindViewById(R.id.button_test_annotation)
    private Button buttonAnnotation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
        initView();
    }

    private void initView() {
        buttonAnnotation = findViewById(R.id.button_test_annotation);
    }

}
