package com.magicsoft.chart.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.magicsoft.chart.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/20
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class CustomeDialog extends BaseDialog {
    @BindView(R.id.tv_add_team_member_batch)
    TextView mTvAddTeamMemberBatch;
    @BindView(R.id.tv_add_team_member_one)
    TextView mTvAddTeamMemberOne;
    @BindView(R.id.tv_add_team_member_cancel)
    TextView mTvAddTeamMemberCancel;
    @BindView(R.id.ll_select_pic_sample)
    LinearLayout mLlSelectPicSample;

    public CustomeDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void initView() {

        //随意更改内容
        //setCancelable(true);设置是否可以点击外部


    }

    //    @Override设置进出动画
//    protected int getAnimationStyle() {
//        return R.style.anim_right_bottom_scale;
//    }

    @Override
    protected int getLayoutResId() {
        return R.layout.dialog_add_team_member;
    }

    //点击事件
    @OnClick({R.id.tv_add_team_member_batch,
            R.id.tv_add_team_member_one, R.id.tv_add_team_member_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_add_team_member_batch:
                dismiss();
                Toast.makeText(mContext, "batch", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_add_team_member_one:
                Toast.makeText(mContext, "one", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_add_team_member_cancel:
                Toast.makeText(mContext, "cancel", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
