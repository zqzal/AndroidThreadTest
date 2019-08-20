package com.xuxi.androidthreadtest;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;

public class DownloadTask extends AsyncTask <Void, Intent,Boolean>{

    private Dialog progressDialog;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //这个方法会在后台任务开始执行之前调用，用于进行一些界面上的初始化操作，比如显示一个进度条对话框等。
        progressDialog.show(); //显示一个进度条对话框
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
//        try{
//            while (true){
//                int downloadPercent = doDownlaod();
//
//            }
//        }catch (Exception e){
//            return null;
//        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Intent... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    private int doDownlaod(){
        return 1;
    }
}
