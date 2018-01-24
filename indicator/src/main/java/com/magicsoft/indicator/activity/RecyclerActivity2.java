package com.magicsoft.indicator.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.magicsoft.indicator.R;
import com.magicsoft.indicator.adapter.RecyclerAdapter2;
import com.magicsoft.indicator.model.Category;
import com.magicsoft.indicator.model.Team;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.util.ArrayList;
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


public class RecyclerActivity2 extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView rv;
    private ArrayList<Category> categoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler2);
        this.rv = (RecyclerView) findViewById(R.id.rv);

        initData();


        rv.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter2 adapter2 = new RecyclerAdapter2(this, categoryList);
        rv.setAdapter(adapter2);

        // Add the sticky headers decoration,给球队添加标题
        final StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(adapter2);
        rv.addItemDecoration(headersDecor);


    }

    private void initData() {


            categoryList = new ArrayList<>();
            List<Team> teamList1 = new ArrayList<>();
            teamList1.add(new Team("多特蒙德", "http://img1.imgtn.bdimg.com/it/u=1400488354,545185599&fm=21&gp=0.jpg"));
            teamList1.add(new Team("拜仁慕尼黑", "http://img5.imgtn.bdimg.com/it/u=1016826229,3053766616&fm=21&gp=0.jpg"));
            teamList1.add(new Team("沃尔夫斯堡", "http://img2.imgtn.bdimg.com/it/u=1102871345,1624426389&fm=15&gp=0.jpg"));
            teamList1.add(new Team("门兴", "http://c.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=5d24504035fae6cd18b9a3336eda6441/eaf81a4c510fd9f91d25e41e252dd42a2834a493.jpg"));
            Category c1 = new Category("德甲", teamList1);
            c1.setSeleted(true);

            List<Team> teamList2 = new ArrayList<>();
            teamList2.add(new Team("巴塞罗那", "http://www.sinaimg.cn/lf/sports/logo85/130.png"));
            teamList2.add(new Team("皇家马德里", "http://www.sinaimg.cn/lf/sports/logo85/157.png"));
            teamList2.add(new Team("马德里竞技", "http://www.sinaimg.cn/lf/sports/logo85/162.png"));
            Category c2 = new Category("西甲", teamList2);

            List<Team> teamList3 = new ArrayList<>();
            teamList3.add(new Team("尤文图斯", "http://www.sinaimg.cn/lf/sports/logo85/108.png"));
            teamList3.add(new Team("国际米兰", "http://www.sinaimg.cn/lf/sports/logo85/103.png"));
            teamList3.add(new Team("AC米兰", "http://www.sinaimg.cn/lf/sports/logo85/104.png"));
            teamList3.add(new Team("罗马", "http://www.sinaimg.cn/lf/sports/logo85/111.png"));
            Category c3 = new Category("意甲", teamList3);

            List<Team> teamList4 = new ArrayList<>();
            teamList4.add(new Team("曼联", "http://www.sinaimg.cn/lf/sports/logo85/52.png"));
            teamList4.add(new Team("曼城", "http://www.sinaimg.cn/lf/sports/logo85/216.png"));
//        teamList4.add(new Team("切尔西","http://www.sinaimg.cn/lf/sports/logo85/60.png"));
//        teamList4.add(new Team("阿森纳","http://www.sinaimg.cn/lf/sports/logo85/61.png"));
//        teamList4.add(new Team("莱斯特成","http://www.sinaimg.cn/lf/sports/logo85/92.png"));
            Category c4 = new Category("英超", teamList4);

            List<Team> teamList5 = new ArrayList<>();
            teamList5.add(new Team("北京国安", "http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127115830.png"));
//        teamList5.add(new Team("广州恒大","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127124548.png"));
//        teamList5.add(new Team("山东鲁能","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127115709.png"));
//        teamList5.add(new Team("江苏苏宁","http://www.sinaimg.cn/ty/2016/0108/U6521P6DT20160108153302.png"));
//        teamList5.add(new Team("上海上港","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127122231.png"));
            Category c5 = new Category("中超", teamList5);


            categoryList.add(c1);
            categoryList.add(c2);
            categoryList.add(c3);
            categoryList.add(c4);
            categoryList.add(c5);
//        for (int i=0;i<10;i++){
//            List<Team> teamList = new ArrayList<>();
//            teamList.add(new Team("北京国安","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127115830.png"));
//            teamList.add(new Team("广州恒大","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127124548.png"));
//            teamList.add(new Team("山东鲁能","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127115709.png"));
//            teamList.add(new Team("江苏苏宁","http://www.sinaimg.cn/ty/2016/0108/U6521P6DT20160108153302.png"));
//            teamList.add(new Team("上海上港","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127122231.png"));
//            Category c = new Category("中超",teamList);
//            categoryList.add(c);
//        }

    }


}
