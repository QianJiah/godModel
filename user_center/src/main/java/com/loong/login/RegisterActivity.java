package com.loong.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loong.base.BaseApp;
import com.loong.base.activity.MVPBaseActivity;
import com.loong.base.error.ErrorMsgBean;
import com.loong.base.util.ToastUtil;
import com.loong.login.constract.UserCenterContract;
import com.loong.login.presenter.UserCenterPresenter;
import com.loong.login.response.JiaYouUser;
import com.loong.login.response.LoginResult;
import com.loong.login.response.RegisterResult;

/**
 * author: Hao
 * date: 2019/10/11 14:35
 * description:
 */
public class RegisterActivity extends MVPBaseActivity<UserCenterPresenter> implements UserCenterContract.View {

    private EditText etAccount, etPass, etRePass;
    private Button btnRegCommit;

    @Override
    protected UserCenterPresenter createPresenter() {
        return new UserCenterPresenter();
    }

    @Override
    protected void initData() {
        btnRegCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString();
                String pass = etPass.getText().toString();
                String rePass = etRePass.getText().toString();
                presenter.doRegister(account, pass, rePass);
            }
        });
    }

    @Override
    protected void initView() {
        etAccount = findViewById(R.id.reg_userName);
        etPass = findViewById(R.id.reg_pass);
        etRePass = findViewById(R.id.reg_rePass);
        btnRegCommit = findViewById(R.id.reg_commit);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    public void loginSuccess(JiaYouUser loginResult) {

    }

    @Override
    public void loginFailed(ErrorMsgBean e) {

    }

    @Override
    public void registerSuccess(RegisterResult registerResult) {
        ToastUtil.show(BaseApp.getApplication(), "注册成功,我们登录吧");
        Intent intent = new Intent(this, UserCenterActivity.class);
        startActivity(intent);
    }

    @Override
    public void registerFailed(ErrorMsgBean errorMsgBean) {
        ToastUtil.show(BaseApp.getApplication(), errorMsgBean.getMsg());
    }

}
