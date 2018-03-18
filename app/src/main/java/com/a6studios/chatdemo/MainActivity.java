package com.a6studios.chatdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button send;
    Button recv;
    EditText msg;
    RecyclerView rvMessages;
    Chat chatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = (Button)findViewById(R.id.s);
        recv = (Button)findViewById(R.id.r);
        msg = (EditText)findViewById(R.id.msg_et);
        rvMessages = (RecyclerView)findViewById(R.id.rvMessages);
        LinearLayoutManager m = new LinearLayoutManager(this);
        rvMessages.setLayoutManager(m);
        chatAdapter= new Chat(this);
        rvMessages.setAdapter(chatAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!msg.getText().toString().isEmpty()&!msgLength0(msg.getText().toString())) {
                    Message m = new Message();
                    m.setMsg(msg.getText().toString());
                    m.setSent(true);
                    msg.setText("");
                    chatAdapter.addItem(m);
                    rvMessages.smoothScrollToPosition(chatAdapter.getItemCount());
                }
            }
        });
        recv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!msg.getText().toString().isEmpty()&!msgLength0(msg.getText().toString())) {
                    Message m = new Message();
                    m.setMsg(msg.getText().toString());
                    m.setSent(false);
                    msg.setText("");
                    chatAdapter.addItem(m);
                    rvMessages.smoothScrollToPosition(chatAdapter.getItemCount());
                }
            }
        });
    }

    boolean msgLength0(String s)
    {
        String modifieds = s.replaceAll("^\\s+","");
        s = modifieds.replaceAll("\\s+$","");
        return s.length()==0;
    }

    /*public void buttonClick (View v)
    {

        switch(v.getId()){
            case R.id.s:
                m.setMsg(msg.getText().toString());
                m.setSent(true);
                msg.setText("");
                chatAdapter.addItem(m);
                break;
            case R.id.r:
                m.setMsg(msg.getText().toString());
                m.setSent(false);
                msg.setText("");
                chatAdapter.addItem(m);
                break;

        }

    }*/
}
