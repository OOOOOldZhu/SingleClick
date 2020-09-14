package com.zhw.singleclicklib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zhw.mylibrary.SingleClick;
import com.zhw.mylibrary.SingleClickInjecter;

public class Example1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);

        SingleClickInjecter.inject(Example1Activity.this);
    }

    @SingleClick(value = R.id.btn_sigleclick, delay = 1000)
    public void btnClick(View view) {
        Toast.makeText(this, "1秒内不允许第二次点击", Toast.LENGTH_SHORT).show();
    }

}