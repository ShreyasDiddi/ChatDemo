package com.a6studios.chatdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class sentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    TextView stv;
    public sentViewHolder(View itemView) {
        super(itemView);
        stv = (TextView)itemView.findViewById(R.id.sent_msg);
        stv.setOnClickListener(this);
    }

    void bind(Message m)
    {
        stv.setText(m.getMsg());
    }

    @Override
    public void onClick(View v) {

    }
}

class recvViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView rtv;
    public recvViewHolder(View itemView) {
        super(itemView);
        rtv = (TextView)itemView.findViewById(R.id.rec_msg);
        rtv.setOnClickListener(this);
    }

    void bind(Message m)
    {
        rtv.setText(m.getMsg());
    }

    @Override
    public void onClick(View v) {

    }
}

class Chat extends RecyclerView.Adapter
{
    ArrayList <Message>messageArrayList;
    Context mContext;
    final int SENT_MSG = 1;
    final int RECV_MSG = 2;

    public Chat(Context mContext) {
        this.mContext = mContext;
        messageArrayList = new ArrayList<>();
    }

    void addItem(Message m)
    {
        messageArrayList.add(m);
        notifyItemInserted(messageArrayList.size()-1);
    }

    private Context getContext(){
        return mContext;
    }

    @Override
    public int getItemViewType(int position) {
        Message m = messageArrayList.get(position);
        if (m.isSent())
            return SENT_MSG;
        else
            return RECV_MSG;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v;
        if(viewType == SENT_MSG)
        {
            v = inflater.inflate(R.layout.item_sent_msg,parent,false);
            return new sentViewHolder(v);
        }
        else
        {
            v = inflater.inflate(R.layout.item_rec_msg,parent,false);
            return new recvViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case SENT_MSG:
                sentViewHolder sentHolder = (sentViewHolder)holder;
                sentHolder.bind(messageArrayList.get(position));
                break;

            case RECV_MSG:
                recvViewHolder recvHolder = (recvViewHolder)holder;
                recvHolder.bind(messageArrayList.get(position));

        }
    }

    @Override
    public int getItemCount() {
        return messageArrayList.size();
    }


}