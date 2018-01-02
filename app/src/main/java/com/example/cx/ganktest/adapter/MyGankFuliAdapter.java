package com.example.cx.ganktest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cx.ganktest.App;
import com.example.cx.ganktest.GlideApp;
import com.example.cx.ganktest.R;
import com.example.cx.ganktest.bean.FuliBean;

import java.util.List;

/**
 * Created by cx on 2017/12/25.
 */

public class MyGankFuliAdapter extends RecyclerView.Adapter<MyGankFuliAdapter.GankFuliViewHolder> {

    private Context mContext;
    private List<FuliBean> fuliBeanList;

    private int screenWidth;
    private int screenHeight;

    public MyGankFuliAdapter(Context context, List<FuliBean> fuliBeenList) {
        mContext = context;
        this.fuliBeanList = fuliBeenList;
        WindowManager windowManager = (WindowManager) App.getInstance().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        screenWidth =  windowManager.getDefaultDisplay().getWidth();
        screenHeight = windowManager.getDefaultDisplay().getHeight();
    }

    @Override
    public GankFuliViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GankFuliViewHolder holder = new GankFuliViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_fuli, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(GankFuliViewHolder holder, int position) {
        setLayoutParams(holder.fl);
        if (!fuliBeanList.isEmpty()) {
            GlideApp.with(mContext).load(fuliBeanList.get(position).url).into(holder.iv);
        }
    }

    @Override
    public int getItemCount() {
        return fuliBeanList.size();
    }

    class GankFuliViewHolder extends RecyclerView.ViewHolder {

        FrameLayout fl;
        ImageView iv;
        public GankFuliViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            fl = itemView.findViewById(R.id.root);
        }
    }

    private void setLayoutParams(View view) {
        if (view != null) {
            //86/148
            int w = (screenWidth - (int)(mContext.getResources().getDisplayMetrics().density * (10 * 2) + 0.5f))/2;
            int h = w * 9 / 16;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(w, h);
            view.setLayoutParams(params);
        }
    }
}
