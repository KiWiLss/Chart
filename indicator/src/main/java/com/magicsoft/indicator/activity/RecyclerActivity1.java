package com.magicsoft.indicator.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.gavin.com.library.StickyDecoration;
import com.gavin.com.library.listener.GroupListener;
import com.gavin.com.library.listener.PowerGroupListener;
import com.magicsoft.indicator.R;
import com.magicsoft.indicator.Utils;
import com.magicsoft.indicator.adapter.RecyclerAdapter1;
import com.magicsoft.indicator.model.City;

import java.util.List;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/24
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class RecyclerActivity1 extends AppCompatActivity {
    private android.support.v7.widget.Toolbar tb;
    private android.support.design.widget.AppBarLayout appbar;
    private android.support.v7.widget.RecyclerView rv;//安卓原生的方法
    private List<City> mCityData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler1);
        this.rv = (RecyclerView) findViewById(R.id.rv);
        this.appbar = (AppBarLayout) findViewById(R.id.appbar);
        this.tb = (Toolbar) findViewById(R.id.tb);

        setSupportActionBar(tb);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RecyclerActivity1.this, "navigation", Toast.LENGTH_SHORT).show();
            }
        });

        setAdapter();
    }

    private void setAdapter() {
        List<String> data = Utils.getData(20);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        //创建StickyDecoration，实现悬浮栏
        mCityData = Utils.getCityData();
        StickyDecoration decoration = StickyDecoration.Builder.init(groupListener)
                .build();
        rv.addItemDecoration(decoration);

        RecyclerAdapter1 adapter1 = new RecyclerAdapter1(mCityData, this);
        rv.setAdapter(adapter1);

    }
    //自定义样式回调
    PowerGroupListener pgl = new PowerGroupListener() {
        @Override
        public View getGroupView(int position) {
            return null;
        }

        @Override
        public String getGroupName(int position) {
            return null;
        }
    };
    //回调
    GroupListener groupListener = new GroupListener() {
        @Override
        public String getGroupName(int position) {
            //根据position获取对应的组名称
         if (mCityData.size()>position){
             return mCityData.get(position).getProvince();
         }
            return null;
        }
    };
}
