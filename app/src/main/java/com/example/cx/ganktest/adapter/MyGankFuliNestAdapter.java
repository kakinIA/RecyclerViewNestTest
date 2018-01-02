package com.example.cx.ganktest.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cx.ganktest.GlideApp;
import com.example.cx.ganktest.R;
import com.example.cx.ganktest.bean.FuliBean;

import java.util.List;

/**
 * Created by cx on 2017/12/25.
 */

public class MyGankFuliNestAdapter extends RecyclerView.Adapter<MyGankFuliNestAdapter.GankFuliViewHolder> {

    private Context mContext;
    private List<FuliBean> fuliBeanList;

    public MyGankFuliNestAdapter(Context context, List<FuliBean> fuliBeenList) {
        mContext = context;
        this.fuliBeanList = fuliBeenList;
    }

    @Override
    public GankFuliViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GankFuliViewHolder holder = new GankFuliViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_fuli_nest, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(GankFuliViewHolder holder, int position) {
        if (!fuliBeanList.isEmpty()) {
            if (holder.rv.getAdapter() == null) {
                holder.rv.setAdapter(new MyGankFuliAdapter(mContext, fuliBeanList));
                holder.rv.setLayoutManager(new GridLayoutManager(mContext, 2));
            } else {
                holder.rv.getAdapter().notifyDataSetChanged();
            }
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class GankFuliViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rv;
        public GankFuliViewHolder(View itemView) {
            super(itemView);
            rv = itemView.findViewById(R.id.rv);
        }
    }
}
