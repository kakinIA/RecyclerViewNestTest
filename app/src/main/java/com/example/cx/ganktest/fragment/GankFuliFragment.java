package com.example.cx.ganktest.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.cx.ganktest.BaseFragment;
import com.example.cx.ganktest.adapter.GankFuliAdapter;
import com.example.cx.ganktest.R;
import com.example.cx.ganktest.bean.FuliBean;
import com.example.cx.ganktest.bean.FuliBeanResult;
import com.example.cx.ganktest.network.HttpManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by cx on 2017/12/25.
 */

public class GankFuliFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    private static final int AMOUNT = 20;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.gridRv)
    RecyclerView gridRv;

    private GankFuliAdapter mAdapter;
    private List<FuliBean> fuliList;

    private int mPage = 1;

    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gank_fuli, container, false);
        ButterKnife.bind(this, view);
        if (fuliList == null) {
            fuliList = new ArrayList<>();
        }
        mAdapter = new GankFuliAdapter(fuliList);
        initLayoutManager();
        mAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return 2;
            }
        });
        gridRv.setLayoutManager(gridLayoutManager);
        gridRv.setAdapter(mAdapter);

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.CYAN);
        swipeRefreshLayout.setOnRefreshListener(this);

        loadData(AMOUNT, mPage);
        mAdapter.setOnLoadMoreListener(this, gridRv);
        return view;
    }

    @Override
    public void onRefresh() {
        mPage = 1;
        loadData(AMOUNT, mPage);
    }

    private void initLayoutManager(){
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        gridLayoutManager = new GridLayoutManager(getContext(), 4);
    }

    private void loadData(int amount, int page) {
        unsubscribe();
        disposable = HttpManager.getGankApi()
                .getFuli(amount, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<FuliBeanResult, List<FuliBean>>() {
                    @Override
                    public List<FuliBean> apply(@io.reactivex.annotations.NonNull FuliBeanResult fuliBeanResult) throws Exception {
                        return fuliBeanResult.fuliBeanList;
                    }
                })
                .subscribe(new Consumer<List<FuliBean>>() {
                    @Override
                    public void accept(@io.reactivex.annotations.NonNull List<FuliBean> fuliBeen) throws Exception {
                        swipeRefreshLayout.setRefreshing(false);
                        if (mPage == 1) {
                            fuliList.clear();
                        }
                        fuliList.addAll(fuliBeen);
                        mAdapter.notifyDataSetChanged();
                        hideProgress();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@io.reactivex.annotations.NonNull Throwable throwable) throws Exception {
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(getContext(), "加载数据失败", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onLoadMoreRequested() {

        gridRv.post(new Runnable() {
            @Override
            public void run() {
                loadData(AMOUNT, ++mPage);
            }
        });

    }

    private void hideProgress() {
        if (swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(false);

        mAdapter.loadMoreComplete();//加载完成
    }

}
