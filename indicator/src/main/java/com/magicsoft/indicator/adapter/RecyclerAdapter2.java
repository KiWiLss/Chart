package com.magicsoft.indicator.adapter;

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


public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ViewHolder>
        implements StickyRecyclerHeadersAdapter<RecyclerAdapter2.HeaderViewHolder> {

    private final LayoutInflater mInflater;
    Context mContext;
    List<Category>mData;
    List<Team>mTeamList=new ArrayList<>();
    public RecyclerAdapter2(Context context, List<Category> data) {
        mContext = context;
        mData = data;
        mInflater=LayoutInflater.from(context);
        //获取正式内容的集合
        getContentData();
    }

    private void getContentData() {
        for (int i = 0,j= mData.size(); i <j; i++) {

            List<Team> teamList = mData.get(i).getTeamList();
            mTeamList.addAll(teamList);
        }
        notifyDataSetChanged();
    }

    /**
     * 初始化正式内容
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recycler1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvText.setText(mTeamList.get(position).getName());

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

    /**
     * 初始化头部内容
     * @param parent
     * @return
     */
    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_header, parent, false);
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder holder, int position) {
        holder.tvText.setText(mData.get(getSortType(position)).getSortName());
    }

    @Override
    public int getItemCount() {
        return mTeamList.size();
    }


    /*9*
    顶部内容
     */
    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            tvText=itemView.findViewById(R.id.tv_header_recycler);
        }
    }

    /**
     * 正式内容
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;
        public ViewHolder(View itemView) {
            super(itemView);
            tvText=itemView.findViewById(R.id.tv_item_recycler);
        }
   }
}
