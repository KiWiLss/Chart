package com.magicsoft.indicator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.leandom.banner.CycleViewPager;
import com.leandom.banner.ViewPagerIndicator;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;


/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/23
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class IndicatorActivity extends AppCompatActivity {
    private CycleViewPager banner;
    private ViewPagerIndicator viewpagerindicator;
    private SimpleBannerAdapter mPagerAdapter;
    private CircleIndicator mCici;

    int mIng[]={R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator);
        this.viewpagerindicator = (ViewPagerIndicator) findViewById(R.id.viewpager_indicator);
        this.banner = (CycleViewPager) findViewById(R.id.banner);

        mCici = (CircleIndicator) findViewById(R.id.cici);

        mPagerAdapter = new SimpleBannerAdapter(this);

        ArrayList<ImageView> mImgList = new ArrayList<>();
        for (int i = 0,j=mIng.length; i < j; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(mIng[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImgList.add(imageView);
        }
        HomeFgAdapter homeFgAdapter = new HomeFgAdapter(mImgList);

        banner.setAdapter(mPagerAdapter);
        viewpagerindicator.bindToViewPager(banner);
        int count = banner.getAdapter().getCount();
        Log.e("MMM", "onCreate: "+count );



        mCici.setViewPager(banner);

        banner.addOnRealPageSelectedListener(new CycleViewPager.OnRealPageSelectedListener() {
            @Override
            public void onPageSelected(int current, int realCount) {



            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        banner.startAutoScroll();
    }

    @Override
    protected void onPause() {
        super.onPause();
        banner.stopAutoScroll();
    }
}
