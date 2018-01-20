package com.magicsoft.chart.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.view.Window;

import com.magicsoft.chart.MyApp;
import com.magicsoft.chart.R;
import com.magicsoft.chart.utils.DisplayUtils;

import butterknife.ButterKnife;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/19
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


/**
 * Created by 段露 on 2017/11/24 15:12.
 *
 * @author 段露
 * @version 1.0.0
 * @class BaseDialog
 * @describe 基类Dialog
 * 注：在BroadcastReceiver等地方显示对话框时需要加上下面这句话，并申请权限：
 * android.permission.SYSTEM_ALERT_WINDOW
 * alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
 */
public abstract class BaseDialog extends AppCompatDialog {

    protected final String TAG = this.getClass().getSimpleName();

    protected Context mContext;
    private View mRootView;
    private View.OnClickListener mCancelClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cancel();
        }
    };

    public BaseDialog(@NonNull Context context) {
        this(context, R.style.style_dialog_transparency);
    }

    public BaseDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.mContext = context;
        setContentView(getLayoutResId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        floatingWithFullscreen();
        setAnimationStyle();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mRootView = getLayoutInflater().inflate(layoutResID, null);
        super.setContentView(layoutResID);
        this.setContentView(mRootView);
        ButterKnife.bind(this);
        setCancelable(true);
        initView();
    }

    @Override
    public void show() {
        if (!isShowing()) super.show();
    }

    @Override
    public void setCancelable(boolean flag) {
        super.setCancelable(flag);
        mRootView.setOnClickListener(flag ? mCancelClickListener : null);
    }

    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * 点击
     *
     * @param view 被点击的View
     */
    protected abstract void onClick(View view);

    /**
     * 获取视图文件资源id
     *
     * @return 视图文件资源id
     */
    @LayoutRes
    protected abstract int getLayoutResId();

    /**
     * 设置<item name="android:windowIsFloating">true</item>时
     * dialog在屏幕中间，在这里将其设置为宽度MATCH_PARENT，高度为屏幕高度减去状态栏高度
     */
    protected void floatingWithFullscreen() {
        Window window = getWindow();
        if (null != window) {
            int height = MyApp.mHeightPixels - DisplayUtils.getStatusBarHeight(mContext);
            window.setLayout(MATCH_PARENT, height);
        }
    }

    /**
     * 设置Dialog进出动画
     */
    private void setAnimationStyle() {
        if (getAnimationStyle() <= 0) return;
        Window window = getWindow();
        if (null == window) return;
        window.setWindowAnimations(getAnimationStyle());
    }

    @StyleRes
    protected int getAnimationStyle() {
        return R.style.anim_bottom_slid;
    }

}

