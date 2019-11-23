package com.loong.login.service;

import com.loong.base.BaseResponse;
import com.loong.login.response.JiaYouUser;
import com.loong.login.response.LoginResult;
import com.loong.login.response.RegisterResult;

import java.util.Calendar;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * author: Hao
 * date: 2019/10/10 10:54
 * description:
 */
public interface UserCenterService {

    @POST("user/register")
    @FormUrlEncoded
    Observable<BaseResponse<RegisterResult>> register(@Field("username") String username,
                                                      @Field("password") String password,
                                                      @Field("repassword") String rePassword);

    /*@POST("user/login")
    @FormUrlEncoded
    Observable<BaseResponse<LoginResult>> login(@Field("username") String username,
                                                @Field("password") String password);*/

    @POST("user/login.do")
    @FormUrlEncoded
    Observable<BaseResponse<JiaYouUser>> login(@Field("username") String username,
                                                @Field("password") String password);

    @POST("user/login.do")
    @FormUrlEncoded
    Call<JiaYouUser> logina(@Field("username") String username,
                           @Field("password") String password);

}
