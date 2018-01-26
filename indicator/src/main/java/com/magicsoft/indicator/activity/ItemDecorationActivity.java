package com.magicsoft.indicator.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.zagum.switchicon.SwitchIconView;
import com.magicsoft.indicator.R;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/25
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class ItemDecorationActivity extends AppCompatActivity {
    private com.github.zagum.switchicon.SwitchIconView sivone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_decoration);
        this.sivone = (SwitchIconView) findViewById(R.id.siv_one);

        sivone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击切换
                sivone.switchState();
            }
        });





    }

    /**
     *
     * xml自定义属性
     *  app:si_animation_duration="500" ---> 动画时间
     app:si_disabled_alpha="0.6" ----->  //enable=false时的透明度
     app:si_disabled_color="#b7b7b7" ----> enable=false时的颜色
     app:si_enabled="false"
     app:si_no_dash="true"---> 是否显示一条斜线
     app:si_tint_color="@color/colorAccent"---> enable=true时的颜色

     java代码
     public void setIconEnabled(boolean enabled);

     public void setIconEnabled(boolean enabled, boolean animate);

     public boolean isIconEnabled();

     public void switchState();

     public void switchState(boolean animate);
     */
}
