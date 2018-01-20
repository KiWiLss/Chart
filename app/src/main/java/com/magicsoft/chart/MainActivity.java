package com.magicsoft.chart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.magicsoft.chart.dialog.CustomeDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void customDialog(View view) {
        CustomeDialog customeDialog = new CustomeDialog(this);
        //customeDialog.setCancelable(false);设置外部是否可以点击
        customeDialog.show();
    }
}
