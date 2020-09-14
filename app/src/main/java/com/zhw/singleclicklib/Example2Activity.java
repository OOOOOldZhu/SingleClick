package com.zhw.singleclicklib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zhw.mylibrary.SingleClickListener;

public class Example2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        //delayTime如果不传，默认为1500ms
        findViewById(R.id.btn_sigleclick).setOnClickListener(new SingleClickListener(1000) {
            @Override
            public void onSingleClick(View v) {
                Toast.makeText(Example2Activity.this, "1秒内不允许第二次点击", Toast.LENGTH_SHORT).show();
            }
        });
    }
}