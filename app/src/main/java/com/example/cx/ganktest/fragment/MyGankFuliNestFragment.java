package com.example.cx.ganktest.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cx.ganktest.BaseFragment;
import com.example.cx.ganktest.R;
import com.example.cx.ganktest.adapter.MyGankFuliAdapter;
import com.example.cx.ganktest.adapter.MyGankFuliNestAdapter;
import com.example.cx.ganktest.bean.FuliBean;
import com.example.cx.ganktest.bean.FuliBeanResult;
import com.example.cx.ganktest.network.HttpManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by cx on 2017/12/25.
 */

public class MyGankFuliNestFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final int AMOUNT = 120;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.gridRv)
    RecyclerView gridRv;

    private MyGankFuliNestAdapter mAdapter;
    private List<FuliBean> fuliList;
    private LinearLayoutManager linearLayoutManager;

    private int mPage = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gank_fuli, container, false);
        ButterKnife.bind(this, view);
        if (fuliList == null) {
            fuliList = new ArrayList<>();
        }
        mAdapter = new MyGankFuliNestAdapter(getContext(), fuliList);
        gridRv.setLayoutManager(linearLayoutManager = new LinearLayoutManager(getActivity()));
        gridRv.setAdapter(mAdapter);

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.CYAN);
        swipeRefreshLayout.setOnRefreshListener(this);
//        gridRv.addOnScrollListener(scrollListener);
        loadData(AMOUNT, mPage);

        return view;
    }

    @Override
    public void onRefresh() {
        mPage = 1;
        loadData(AMOUNT, mPage);
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

    private boolean loadMoreFlag = true;
    private RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (loadMoreFlag && linearLayoutManager.findLastVisibleItemPosition() >= fuliList.size() - 3) {
                loadMoreFlag = false;
                gridRv.post(new Runnable() {
                    @Override
                    public void run() {
                        loadData(AMOUNT, ++mPage);
                    }
                });
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        gridRv.removeOnScrollListener(scrollListener);
    }

    private void hideProgress() {
        if (swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(false);
        loadMoreFlag = true;
    }

}
