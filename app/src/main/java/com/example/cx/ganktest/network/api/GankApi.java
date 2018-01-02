package com.example.cx.ganktest.network.api;

import com.example.cx.ganktest.bean.FuliBeanResult;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by cx on 2017/12/25.
 */

public interface GankApi {
    @GET("data/福利/{amount}/{page}")
    Observable<FuliBeanResult> getFuli(@Path("amount") int amount, @Path("page") int page);
    @GET("data/福利/{amount}/{page}")
    Call<ResponseBody> getFuli2(@Path("amount") int amount, @Path("page") int page);
}
