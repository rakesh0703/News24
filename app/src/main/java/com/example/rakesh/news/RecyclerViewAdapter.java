package com.example.rakesh.news;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Rakesh on 12-07-2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    List<newsitem> news_item;
    Context context;
    Dialog mydialog;

    public RecyclerViewAdapter(List<newsitem> news_item, Context context) {
        this.news_item = news_item;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(context).inflate(R.layout.news_items,parent,false);
        final MyViewHolder vholder = new MyViewHolder(v);



        return vholder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv_head.setText(news_item.get(position).getHeader());
       // System.out.println("######################3"+news_item.get(position).getImageurl()+"\n");
            Picasso.with(context)
                .load(news_item.get(position).getImageurl())
                .placeholder(R.drawable.loading2)
                .into(holder.imggg);

        mydialog = new Dialog(context);
        mydialog.setContentView(R.layout.dialog_design);
        mydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView desc = (TextView) mydialog.findViewById(R.id.desc_dialog);
                TextView head = (TextView) mydialog.findViewById(R.id.head_dialog);
                ImageView imgg = (ImageView) mydialog.findViewById(R.id.img_dialog);
                TextView urll = (TextView) mydialog.findViewById(R.id.link_dialog);
                Button btn = (Button) mydialog.findViewById(R.id.btn_dialog);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mydialog.dismiss();
                    }
                });
                    head.setText(news_item.get(position).getHeader());
                    desc.setText(news_item.get(position).getDesc());
                    urll.setText(news_item.get(position).getUrl());
                 Picasso.with(context)
                     .load(news_item.get(holder.getAdapterPosition()).getImageurl())
                     .into(imgg);
                mydialog.show();
            }
        });

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return news_item.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_head;
        public TextView tv_desc;
        public ImageView imggg;
        public LinearLayout linearLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_head = (TextView) itemView.findViewById(R.id.head_item);
            tv_desc = (TextView) itemView.findViewById(R.id.desc_item);
            imggg = (ImageView) itemView.findViewById(R.id.img_item);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout);
        }
    }
}
