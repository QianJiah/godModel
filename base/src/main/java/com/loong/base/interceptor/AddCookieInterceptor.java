package com.loong.base.interceptor;

import android.content.Context;
import android.util.Log;

import com.loong.base.BaseApp;
import com.loong.base.util.Constants;
import com.loong.base.util.SharedPreferenceUtil;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * author: Hao
 * date: 2019/10/11 11:18
 * description:通过拦截器将Cookie添加到头部信息里
 */
public class AddCookieInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        HashSet<String> cookieSet = (HashSet<String>) SharedPreferenceUtil.read(Constants.REF_NAME, Constants.COOKIE_SET, (HashSet<String>) null);
        if (cookieSet != null) {
            Log.e("hao", "addCookie拦截器：" + cookieSet.size());
            for (String cookie : cookieSet) {
                builder.addHeader("Cookie", cookie);
            }
        }
        return chain.proceed(builder.build());
    }
}
