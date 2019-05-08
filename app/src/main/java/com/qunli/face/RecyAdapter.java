/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.qunli.face;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bcq.oklib.Constant;
import com.bcq.oklib.OKHelper;
import com.bcq.oklib.UI;
import com.bcq.oklib.base.BaseActivity;
import com.bcq.oklib.utils.BitmapUtil;
import com.bcq.oklib.utils.Logger;

import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> implements View.OnClickListener {

    private BaseActivity context;
    private List<Bitmap> datas;

    public RecyAdapter(BaseActivity context) {
        this.context = context;
    }

    public void setDatas(List<Bitmap> datas) {
        this.datas = datas;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_horizon, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (datas.size() <= 0) {
            return;
        }
        int newPos = position % datas.size();
        final Bitmap bitmap = datas.get(newPos);
        holder.img.setImageBitmap(bitmap);
        holder.itemView.setTag(position);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String path = OKHelper.getBasePath()+"temp_"+ System.currentTimeMillis()+".jpg";
                Logger.e("RecyAdapter","onClick:path = " +path);
                BitmapUtil.saveBitmap(path,bitmap);
//                BitmapUtil.saveDrawingCache( v,path,320);
                UI.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        context.setResult(Activity.RESULT_OK, new Intent().putExtra(Constant.KEY_BASE, path));
                        context.finish();
                    }
                },500);
            }
        });
    }

    @Override
    public int getItemCount() {
        // return Integer.MAX_VALUE;
        int count = 0;
        if (datas != null) {
            count = datas.size();
        }
        return count;
    }

    @Override
    public void onClick(View view) {

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}