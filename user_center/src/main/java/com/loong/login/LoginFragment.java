package com.loong.login;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.loong.base.BaseApp;
import com.loong.base.BaseFragment;
import com.loong.base.error.ErrorMsgBean;
import com.loong.base.util.Constants;
import com.loong.base.util.SharedPreferenceUtil;
import com.loong.base.util.ToastUtil;
import com.loong.login.constract.UserCenterContract;
import com.loong.login.presenter.UserCenterPresenter;
import com.loong.login.response.JiaYouUser;
import com.loong.login.response.LoginResult;
import com.loong.login.response.RegisterResult;

/**
 * author: Hao
 * date: 2019/11/9 11:38
 * description:
 */
public class LoginFragment extends BaseFragment<UserCenterPresenter> implements UserCenterContract.View, View.OnClickListener {

    private View mView;
    //账号
    private AutoCompleteTextView textView;

    //密码
    private EditText editText;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_login, container, false);
        //账号
        textView = mView.findViewById(R.id.piv_login_account);
        //密码
        editText = mView.findViewById(R.id.et_pwd);
        CheckBox checkBox = mView.findViewById(R.id.cb_pwd_switch);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        Button loginBtn = mView.findViewById(R.id.sv_login);
        loginBtn.setOnClickListener(this);
        return mView;
    }

    @Override
    public UserCenterPresenter initPresenter() {
        return new UserCenterPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void loginSuccess(JiaYouUser loginResult) {
        Log.e("hao", "登录成功");
        ToastUtil.show(BaseApp.getApplication(), "登录成功！");
        //保存登录状态到本地
        SharedPreferenceUtil.write(Constants.REF_NAME, Constants.IS_LOGIN, true);
        ARouter.getInstance().build("/home/main").navigation();
    }

    @Override
    public void loginFailed(ErrorMsgBean e) {
        Log.e("hao", "登录失败");
        ToastUtil.show(BaseApp.getApplication(), e.getMsg());
    }

    @Override
    public void registerSuccess(RegisterResult registerResult) {

    }

    @Override
    public void registerFailed(ErrorMsgBean errorMsgBean) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sv_login) {
            Log.e("hao","8*****8登录");
            mPresenter.doLogin(textView.getText().toString(), editText.getText().toString());
        }
    }
}
