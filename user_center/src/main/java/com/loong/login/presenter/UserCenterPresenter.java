package com.loong.login.presenter;

import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.loong.base.BaseObserver;
import com.loong.base.BasePresenter;
import com.loong.base.error.ErrorMsgBean;
import com.loong.login.constract.UserCenterContract;
import com.loong.login.response.LoginResult;
import com.loong.login.response.RegisterResult;
import com.loong.login.service.UserCenterService;

/**
 * author: Hao
 * date: 2019/10/10 11:59
 * description:
 */
public class UserCenterPresenter extends BasePresenter<UserCenterContract.View> implements UserCenterContract.Presenter {

    //发起请求并回调
    @Override
    public void doLogin(String phone, String password) {
        addSubscribe(create(UserCenterService.class).login(phone, password), new BaseObserver<LoginResult>(getView()) {
            @Override
            protected void onSuccess(LoginResult data) {
                Log.e("hao", "loginResult : " + data.toString());
                if (isAttachedView()) {
                    getView().loginSuccess(data);
                }
            }

            @Override
            protected void onFailed(ErrorMsgBean e) {
                Log.e("hao", "loginFailed:" + e.getMsg() + ", errorCode:" + e.getCode());
                if (isAttachedView()) {
                    getView().loginFailed(e);
                }
            }
        });
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
