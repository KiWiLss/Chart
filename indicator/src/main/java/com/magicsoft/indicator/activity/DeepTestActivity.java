package com.magicsoft.indicator.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.deep.imagelib.DeepImage;
import com.deep.imagelib.beans.ImageConfigure;
import com.magicsoft.indicator.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/24
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class DeepTestActivity  extends AppCompatActivity {

    public static final String TAG = "MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep);

        ImageConfigure configure = new ImageConfigure();
        configure.directoryname = "android";//目录名
        configure.filename = "beautiful.jpg";//文件名

        DeepImage deepImage = new DeepImage(this, R.drawable.image5,configure);
        File file = deepImage.asFile();
//
//
//
//        Log.e("MMM", "onCreate: "+(file==null));
//        if (file!=null){
//            Log.e("MMM", "onCreate: "+file.getName()+"||"+file.getAbsolutePath() );
//            //boolean android = file.renameTo(new File("android", "0125.jpg"));
//            //Log.e("MMM", "onCreate: "+android );
//        }

    }

    public void create(View view) {
        @SuppressLint("SdCardPath")
        File file = new File("/mnt/sdcard/work/mywork");
        if (file.exists()){
            Log.e(TAG, "create: exists");
        }else {
            file.mkdirs();
            Log.e(TAG, "create: "+file.getAbsolutePath()+"||"
            +file.getName()+"||"+file.getPath());
        }
    }

    public void createFlie(View view) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        String path = Environment.getExternalStorageDirectory().getPath();
        Log.e(TAG, "createFlie: "+externalStorageDirectory+"||"+path );
        File file = new File(path+"/anwork");
        if (!file.exists()){
            file.mkdirs();
            Log.e(TAG, "createFlie: " +file.exists());
        }else {
            Log.e(TAG, "createFlie: "+file.getPath() );
        }


    }

    public void createFlieFile(View view) {
        String path = Environment.getExternalStorageDirectory().getPath()+"/anwork";
        File file = new File(path, "test.txt");
        if (file.exists()){
            Log.e(TAG, "createFlieFile: "+file.getPath() );
        }else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyMkis(View view) {
        String path = Environment.getExternalStorageDirectory().getPath()+"/anwork";
        File file = new File(path, "test.txt");
        if (file.exists()){
            FileOutputStream fos;
            FileInputStream fis;
            try {
                fos = new FileOutputStream(file);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }


    }

    public void changName(View view) {
        String path = Environment.getExternalStorageDirectory().getPath()+"/anwork";
        File file = new File(path, "test.txt");
        if (file.exists()){
            file.renameTo(new File(path,"othername.txt"));
        }
    }
}
