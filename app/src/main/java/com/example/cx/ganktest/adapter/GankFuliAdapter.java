package com.example.cx.ganktest.adapter;

import android.app.Application;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.cx.ganktest.App;
import com.example.cx.ganktest.GlideApp;
import com.example.cx.ganktest.R;
import com.example.cx.ganktest.bean.FuliBean;

import java.util.List;

/**
 * Created by cx on 2017/12/25.
 */

public class GankFuliAdapter extends BaseQuickAdapter<FuliBean, BaseViewHolder>{

    private int screenWidth;
    private int screenHeight;

    public GankFuliAdapter(@Nullable List<FuliBean> data) {
        super(R.layout.item_fuli, data);
        WindowManager windowManager = (WindowManager) App.getInstance().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        screenWidth =  windowManager.getDefaultDisplay().getWidth();
        screenHeight = windowManager.getDefaultDisplay().getHeight();
    }

    @Override
    protected void convert(BaseViewHolder helper, FuliBean item) {
        Log.i("TAG", item.url);
        setLayoutParams(helper.getView(R.id.root));
        GlideApp.with(mContext)
                .load(item.url)
                .into((ImageView) helper.getView(R.id.iv));
    }

    public void setAllData(List<FuliBean> data) {
        mData.clear();
        mData.addAll(data);
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
