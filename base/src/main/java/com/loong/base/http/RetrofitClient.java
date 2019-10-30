package com.loong.base.http;

import android.os.Build;

import com.loong.base.BuildConfig;
import com.loong.base.interceptor.AddCookieInterceptor;
import com.loong.base.interceptor.ReceiveCookieInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: Hao
 * date: 2019/10/10 10:33
 * description: 建立基本请求retrofit
 */
public class RetrofitClient {

    private static volatile RetrofitClient retrofitClient;
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    private RetrofitClient() {

        String baseUrl = "https://www.wanandroid.com/";

        okHttpClient = new OkHttpClient.Builder()
                                        .connectTimeout(15, TimeUnit.SECONDS)
                                        .readTimeout(15, TimeUnit.SECONDS)
                                        .writeTimeout(15, TimeUnit.SECONDS)
                                        .addInterceptor(new ReceiveCookieInterceptor())
                                        .addInterceptor(new AddCookieInterceptor())
                                        .addInterceptor(getInterceptor())   //设置日志级别
                                        .build();

        retrofit = new Retrofit.Builder()
                                .baseUrl(baseUrl)
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .client(okHttpClient)
                                .build();
    }

    public static RetrofitClient getRetrofitClient() {
        if (retrofitClient == null) {
            synchronized (RetrofitClient.class) {
                if (retrofitClient == null) {
                    retrofitClient = new RetrofitClient();
                }
            }
        }
        return retrofitClient;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private HttpLoggingInterceptor getInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        //设置日志level
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
        return httpLoggingInterceptor;
    }
}
