package com.magicsoft.indicator.adapter.two_recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magicsoft.indicator.R;
import com.magicsoft.indicator.model.Category;
import com.magicsoft.indicator.model.Team;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

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


public class TeamsAndHeaderAdapter extends RecyclerView.
        Adapter<TeamsAndHeaderAdapter.ContentViewHolder>implements
        StickyRecyclerHeadersAdapter<TeamsAndHeaderAdapter.HeaderViewHolder>{


    private final LayoutInflater mInflater;
    List<Category>mData;
    Context mContext;

    private List<Team> teamList = new ArrayList<>();

    public TeamsAndHeaderAdapter(List<Category> data, Context context) {
        mData = data;
        mContext = context;
        mInflater = LayoutInflater.from(context);
        setCategoryList(data);
    }

    public void setCategoryList(List<Category> categoryList) {
        for(int i = 0;i<categoryList.size();i++){
            if(teamList!=null){
                teamList.addAll(categoryList.get(i).getTeamList());
            }
        }
        notifyDataSetChanged();
    }

    public List<Category> getCategoryList() {
        return mData;
    }
    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recycler1, parent, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        holder.tvText.setText(teamList.get(position).getName());


    }

    @Override
    public long getHeaderId(int position) {
        return getSortType(position);
    }


    //获取当前球队的类型
    public int getSortType(int position) {
        int sort = -1;
        int sum = 0;
        for (int i=0;i<mData.size();i++){
            if(position>=sum){
                sort++;
            }else {
                return sort;
            }
            sum += mData.get(i).getTeamList().size();
        }
        return sort;
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_header, parent, false);
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder holder, int position) {
        holder.tvCt.setText(mData.get(getSortType(position)).getSortName());
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    //头部ViewHolder
    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvCt;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            tvCt=itemView.findViewById(R.id.tv_header_recycler);
        }
    }

    //内容ViewHolder
    class ContentViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;
        public ContentViewHolder(View itemView) {
            super(itemView);
            tvText=itemView.findViewById(R.id.tv_item_recycler);
        }
    }


}
