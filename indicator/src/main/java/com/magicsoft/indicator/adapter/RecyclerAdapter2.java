package com.magicsoft.indicator.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magicsoft.indicator.R;
import com.magicsoft.indicator.model.Category;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

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


public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ViewHolder> implements StickyRecyclerHeadersAdapter<RecyclerAdapter2.ViewHolder> {

    private final LayoutInflater mInflater;
    Context mContext;
    List<Category>mData;

    public RecyclerAdapter2(Context context, List<Category> data) {
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public long getHeaderId(int position) {
        return 0;
    }

    @Override
    public ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {

        return null;
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;
        public ViewHolder(View itemView) {
            super(itemView);
            tvText=itemView.findViewById(R.id.tv_item_recycler);
        }
   }
}
