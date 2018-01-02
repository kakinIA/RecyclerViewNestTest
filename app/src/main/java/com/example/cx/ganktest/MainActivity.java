package com.example.cx.ganktest;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.example.cx.ganktest.fragment.GankFuliFragment;
import com.example.cx.ganktest.fragment.GankFuliNestFragment;
import com.example.cx.ganktest.fragment.MyGankFuliFragment;
import com.example.cx.ganktest.fragment.MyGankFuliNestFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(android.R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.toolBar)
    Toolbar toolBar;

    private List<Fragment> mFragments;
    private List<String> mPageTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        initFragments();
        initPageTitles();
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mPageTitles.get(position);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initFragments(){
        mFragments = new ArrayList<>();
        mFragments.add(new GankFuliFragment());
        mFragments.add(new GankFuliNestFragment());
        mFragments.add(new MyGankFuliFragment());
        mFragments.add(new MyGankFuliNestFragment());
    }
    private void initPageTitles(){
        mPageTitles = new ArrayList<>();
        mPageTitles.add("福利");
        mPageTitles.add("福利（嵌套）");
        mPageTitles.add("福利VA");
        mPageTitles.add("福利VA（嵌套）");
    }
}
