package com.loong.login.constract;

import com.loong.base.error.ErrorMsgBean;
import com.loong.base.iView.IView;
import com.loong.login.response.JiaYouUser;
import com.loong.login.response.LoginResult;
import com.loong.login.response.RegisterResult;

/**
 * author: Hao
 * date: 2019/10/10 11:52
 * description:
 */
public interface UserCenterContract {

    interface View extends IView {

        void loginSuccess(JiaYouUser loginResult);

        void loginFailed(ErrorMsgBean e);

        void registerSuccess(RegisterResult registerResult);

        void registerFailed(ErrorMsgBean errorMsgBean);
    }

    interface Presenter {
        void doLogin(String phone, String password);

        void doRegister(String phone, String password, String rePassword);
    }
}
