package com.loong.base.interceptor;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.loong.base.BaseApp;
import com.loong.base.util.Constants;
import com.loong.base.util.SharedPreferenceUtil;

import java.io.IOException;
import java.util.HashSet;

import javax.security.auth.login.LoginException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * author: Hao
 * date: 2019/10/11 10:42
 * description:为了将Cookie信息拦截保存到本地
 */
public class ReceiveCookieInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        if (!response.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();
            for (String header : response.headers("Set-Cookie")) {
                Log.e("hao" , "拦截到的cookie:" + header);
                cookies.add(header);
            }
            //保存cookie到sharePreference
            SharedPreferenceUtil.write(Constants.REF_NAME, Constants.COOKIE_SET, cookies);
        }
        return response;
    }
}
