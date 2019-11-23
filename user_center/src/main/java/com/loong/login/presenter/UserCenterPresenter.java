package com.loong.login.presenter;

import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.loong.base.BaseObserver;
import com.loong.base.BasePresenter;
import com.loong.base.error.ErrorMsgBean;
import com.loong.login.constract.UserCenterContract;
import com.loong.login.response.JiaYouUser;
import com.loong.login.response.LoginResult;
import com.loong.login.response.RegisterResult;
import com.loong.login.service.UserCenterService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * author: Hao
 * date: 2019/10/10 11:59
 * description:用户中心请求
 */
public class UserCenterPresenter extends BasePresenter<UserCenterContract.View> implements UserCenterContract.Presenter {

    /**
     * fail
     * {
     *     "status":1,
     *     "msg":"密码错误"
     * }
     * success
     * {
     *     "status":0,
     *     "data":{
     *         "username":"admin"
     *         "createTime":"time1"
     *         "updateTime":"time2"
     *     }
     * }
     * @param phone     账号
     * @param password  密码
     */
    @Override
    public void doLogin(String phone, String password) {
        Log.e("hao","ddddddLogin*********");
        Call<JiaYouUser> logina = create(UserCenterService.class).logina(phone, password);
        logina.enqueue(new Callback<JiaYouUser>() {
            @Override
            public void onResponse(Call<JiaYouUser> call, Response<JiaYouUser> response) {
                //这里是主线程
                JiaYouUser user = response.body();
                if (user != null) {
                    Log.e("hao", "response:" + user.getStatus() + "，当前线程：" + Thread.currentThread().getName());
                    if (isAttachedView()) {
                        if (user.getStatus() == 0) {
                            getView().loginSuccess(user);
                        } else {
                            getView().loginFailed(new ErrorMsgBean(user.getStatus(), user.getMsg()));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JiaYouUser> call, Throwable t) {
                Log.e("hao", "throwable:" + t.getMessage());
                if (isAttachedView()) {
                    getView().loginFailed(new ErrorMsgBean(t.hashCode(), t.getMessage()));
                }
            }
        });
        /*addSubscribe(create(UserCenterService.class).login(phone, password), new BaseObserver<JiaYouUser>(getView()) {
            @Override
            protected void onSuccess(JiaYouUser data) {
                Log.e("hao", "loginResult : " + data);
                if (isAttachedView()) {
                    getView().loginSuccess(data);
                }
            }

            @Override
            protected void onFailed(ErrorMsgBean e) {
//                Log.e("hao", "loginFailed:" + e.getMsg() + ", errorCode:" + e.getCode());
                if (isAttachedView()) {
                    getView().loginFailed(e);
                }
            }
        });*/
    }


    @Override
    public void doRegister(String phone, String password, String rePassword) {
        addSubscribe(create(UserCenterService.class).register(phone, password, rePassword), new BaseObserver<RegisterResult>(getView()) {
            @Override
            protected void onSuccess(RegisterResult data) {
                Log.e("hao", "=====注册成功回调=====");
                if (isAttachedView()) {
                    getView().registerSuccess(data);
                }
            }

            @Override
            protected void onFailed(ErrorMsgBean errorMsgBean) {
                Log.e("hao", "=====注册失败回调=====");
                if (isAttachedView()) {
                    getView().registerFailed(errorMsgBean);
                }
            }
        });
    }

}
