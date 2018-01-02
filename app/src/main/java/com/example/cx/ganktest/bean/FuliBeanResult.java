package com.example.cx.ganktest.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cx on 2017/12/25.
 */

public class FuliBeanResult implements MultiItemEntity {
    public boolean error;
    public @SerializedName("results") List<FuliBean> fuliBeanList;

    @Override
    public int getItemType() {
        return 0;
    }
}
