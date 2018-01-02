package com.example.cx.ganktest;

import android.support.v4.app.Fragment;

import io.reactivex.disposables.Disposable;

/**
 * Created by cx on 2017/12/25.
 */

public class BaseFragment extends Fragment {
    protected Disposable disposable;


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unsubscribe();
    }

    protected void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
