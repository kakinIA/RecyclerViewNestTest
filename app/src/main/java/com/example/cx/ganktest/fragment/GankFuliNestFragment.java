package com.example.cx.ganktest.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.cx.ganktest.BaseFragment;
import com.example.cx.ganktest.R;
import com.example.cx.ganktest.adapter.GankFuliAdapter;
import com.example.cx.ganktest.adapter.GankFuliNestAdapter;
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

public class GankFuliNestFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    private static final int AMOUNT = 20; //直接在这里设置大一点的数观察图片加载情况

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.gridRv)
    RecyclerView rv;

    private GankFuliNestAdapter mAdapter;
    private List<FuliBeanResult> fuliList;

    private int mPage = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gank_fuli, container, false);
        ButterKnife.bind(this, view);
        if (fuliList == null) {
            fuliList = new ArrayList<>();
            fuliList.add(new FuliBeanResult());
        }
        mAdapter = new GankFuliNestAdapter(fuliList);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(mAdapter);

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.CYAN);
        swipeRefreshLayout.setOnRefreshListener(this);

        loadData(AMOUNT, mPage);
        mAdapter.setOnLoadMoreListener(this, rv);
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
                            fuliList.add(new FuliBeanResult());
                        }
                        FuliBeanResult fuliBeanResult = fuliList.get(0);
                        if (fuliBeanResult.fuliBeanList == null) {
                            fuliBeanResult.fuliBeanList = new ArrayList<FuliBean>();
                        }
                        fuliBeanResult.fuliBeanList.addAll(fuliBeen);
                        fuliList.set(0, fuliBeanResult);
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

//        rv.post(new Runnable() {
//            @Override
//            public void run() {
//                Log.w("TAG", "加载更多..");
//                loadData(AMOUNT, ++mPage);
//            }
//        });

    }

    private void hideProgress() {
        if (swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(false);

        mAdapter.loadMoreComplete();//加载完成
    }

}
