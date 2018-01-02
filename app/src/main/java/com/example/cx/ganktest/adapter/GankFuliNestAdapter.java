package com.example.cx.ganktest.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.cx.ganktest.App;
import com.example.cx.ganktest.R;
import com.example.cx.ganktest.bean.FuliBean;
import com.example.cx.ganktest.bean.FuliBeanResult;

import java.util.List;

/**
 * recyclerview嵌套的adpater
 * Created by cx on 2017/12/25.
 */

public class GankFuliNestAdapter extends BaseMultiItemQuickAdapter<FuliBeanResult, BaseViewHolder> {

    private int mScreenWidth;
    private int mScreenHeight;


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public GankFuliNestAdapter(List<FuliBeanResult> data) {
        super(data);
        addItemType(0, R.layout.item_fuli_nest);
        WindowManager windowManager = (WindowManager) App.getInstance().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        mScreenWidth = windowManager.getDefaultDisplay().getWidth();
        mScreenHeight = windowManager.getDefaultDisplay().getHeight();

    }

    @Override
    protected void convert(BaseViewHolder helper, FuliBeanResult item) {
        switch (item.getItemType()) {

        }
        RecyclerView rv = helper.getView(R.id.rv);
        setLayoutParams(rv);
        GankFuliAdapter gankFuliAdapter ;
        if (rv.getAdapter() != null) {
            Log.i("TAG", "复用实例");
            gankFuliAdapter = (GankFuliAdapter) rv.getAdapter();
            gankFuliAdapter.setAllData(item.fuliBeanList);
            gankFuliAdapter.notifyDataSetChanged();
        } else {
            Log.i("TAG", "创建实例");
            rv.setLayoutManager(new GridLayoutManager(mContext, 2));
            gankFuliAdapter = new GankFuliAdapter(item.fuliBeanList);
            rv.setAdapter(gankFuliAdapter);
        }
    }

    private void setLayoutParams(View view) {
        if (view != null) {
            int itemW = (mScreenWidth - (int)(mContext.getResources().getDisplayMetrics().density * (10 * 2) + 0.5f))/2;
            int itemH = itemW * 9 / 16;
            List<FuliBean> fuliBeanList = getData().get(0).fuliBeanList;
            if (fuliBeanList != null) {
                int h = (int)(itemH * fuliBeanList.size() / 2 + 0.5f) + (int)(mContext.getResources().getDisplayMetrics().density * (10 * 2));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, h);
                view.setLayoutParams(params);
            }
        }
    }
}
