package com.magicsoft.indicator.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.magicsoft.indicator.R;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/26
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class SoftActivity extends AppCompatActivity {
    private android.widget.ScrollView sv;
    private android.widget.EditText et;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft);
        this.et = (EditText) findViewById(R.id.et);
        this.sv = (ScrollView) findViewById(R.id.sv);

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SoftActivity.this, "**", Toast.LENGTH_SHORT).show();
                Log.e("MMM", "onClick: "+sv.getHeight());
                //sv.smoothScrollTo(0, sv.getHeight());
            }
        });

    }
}
