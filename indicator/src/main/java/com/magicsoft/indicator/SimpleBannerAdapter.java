package com.magicsoft.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.leandom.banner.CyclePagerAdapter;


public class SimpleBannerAdapter extends CyclePagerAdapter {

    private static final int[] drawableIds = new int[]{R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5};
    //private static final int[] drawableIds = new int[]{R.drawable.image2, R.drawable.image3};
    private Context mContext;

    public SimpleBannerAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getRealCount() {
        return drawableIds.length;
    }

    @Override
    public View getViewAtRealPosition(final int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.banner_item, container, false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        imageView.setImageResource(drawableIds[position]);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "click at " + position, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}