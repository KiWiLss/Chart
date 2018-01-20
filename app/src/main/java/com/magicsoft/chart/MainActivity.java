package com.magicsoft.chart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.magicsoft.chart.dialog.CustomeDialog;

public class MainActivity extends AppCompatActivity {

    private Effectstype effect;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void customDialog(View view) {
        CustomeDialog customeDialog = new CustomeDialog(this);
        //customeDialog.setCancelable(false);设置外部是否可以点击
        customeDialog.show();
    }

    public void dialogShow(View v){
        final NiftyDialogBuilder dialogBuilder=NiftyDialogBuilder.getInstance(this);

        switch (v.getId()){
            case R.id.fadein:effect= Effectstype.Fadein;break;
            case R.id.slideright:effect=Effectstype.Slideright;break;
            case R.id.slideleft:effect=Effectstype.Slideleft;break;
            case R.id.slidetop:effect=Effectstype.Slidetop;break;
            case R.id.slideBottom:effect=Effectstype.SlideBottom;break;
            case R.id.newspager:effect=Effectstype.Newspager;break;
            case R.id.fall:effect=Effectstype.Fall;break;
            case R.id.sidefall:effect=Effectstype.Sidefill;break;
            case R.id.fliph:effect=Effectstype.Fliph;break;
            case R.id.flipv:effect=Effectstype.Flipv;break;
            case R.id.rotatebottom:effect=Effectstype.RotateBottom;break;
            case R.id.rotateleft:effect=Effectstype.RotateLeft;break;
            case R.id.slit:effect=Effectstype.Slit;break;
            case R.id.shake:effect=Effectstype.Shake;break;
        }
        dialogBuilder
                .withTitle("Modal Dialog")                                  //.withTitle(null)  no title
                .withTitleColor("#cbcbff")                                  //def
                .withDividerColor("#ffff00")                             //def
                .withMessage("This is a modal Dialog.")                     //.withMessage(null)  no Msg
                .withMessageColor("#ff0000")                              //def  | withMessageColor(int resid)
                //.withDialogColor("#FFE74C3C")                               //def  | withDialogColor(int resid)                               //def
                .withDialogColor("#00ffff")                               //def  | withDialogColor(int resid)                               //def
                //.withIcon(getResources().getDrawable(R.drawable.ic_launcher_background))
                .isCancelableOnTouchOutside(false)
                .withDuration(700)                                          //def
                .withEffect(effect)                                         //def Effectstype.Slidetop
                .withButton1Text("OK")
                //def gone
                .withButton2Text("Cancel")                                  //def gone
                .setCustomView(R.layout.custom_view,v.getContext())         //.setCustomView(View or ResId,context)
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "i'm btn1", Toast.LENGTH_SHORT).show();
                    }
                })
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.dismiss();
                        Toast.makeText(v.getContext(), "i'm btn2", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }



}
