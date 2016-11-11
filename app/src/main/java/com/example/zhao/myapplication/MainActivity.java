package com.example.zhao.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhao.sliding.SlidingMenuActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text;
    private Button btn;
    private Button btnSliding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化控件
        initWidget();
    }

    private void initWidget() {
        text = (TextView) findViewById(R.id.text);
        btn = (Button) findViewById(R.id.btn);
        btnSliding = (Button) findViewById(R.id.btn_sliding);

        btn.setOnClickListener(this);
        btnSliding.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.btn:
                intent.setClass(this, ListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_sliding:
                intent.setClass(this, SlidingMenuActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
