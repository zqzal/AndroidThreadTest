package com.xuxi.androidthreadtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 1.Message
 * Message是在线程之间传递的消息，它可以在内部携带少量的信息，用于在不同线程之间交换数据。
 * 除此之外还可以使用arg1和arg2字段来携带一些整型数据，使用obj字段携带一个Object对象
 * 2.Handler
 * Handler顾名思义也就是处理者的意思，它主要是用于发送和处理消息的。发送消息一般是使用
 * Handler的sendMessage()方法，而发出的消息经过一系列地辗转处理后，最终会传递到Handler
 * 的HandlerMessage()方法中。
 * 3.MessageQuene
 * MessageQueue是消息队列的意思，它主要用于存放所有通过Handler发送的消息。这部分消息会
 * 一直存在于消息队列中，等待被处理。每个线程中只会有一个MessageQuene对象。
 * 4.Looper
 * Looper是每个线程中的MessageQuene的管家，调用Looper的loop()方法后，就会进入到一个无限
 * 循环当中，然后当发现MessageQuene中存在一个消息，就会将它取出，并传递到Handler的handleMesage()
 * 方法中。每个线程中也只会有一个Looper对象。
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int UPDATE_TEXT = 1;

    private TextView text;

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:
                    text.setText("Nice to meet you");
                    break;
                    default:
                        break;
            }
        }

//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        Button changeText = findViewById(R.id.change_text);
        changeText.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.change_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                        text.setText("Nice To meet you");
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);//将Message对象发送出去
                    }
                }).start();
                break;
                default:
                    break;
        }
    }
}
