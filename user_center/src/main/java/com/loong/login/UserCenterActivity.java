package com.loong.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.loong.base.BaseApp;
import com.loong.base.activity.MVPBaseActivity;
import com.loong.base.error.ErrorMsgBean;
import com.loong.base.util.Constants;
import com.loong.base.util.SharedPreferenceUtil;
import com.loong.base.util.ToastUtil;
import com.loong.login.constract.UserCenterContract;
import com.loong.login.presenter.UserCenterPresenter;
import com.loong.login.response.LoginResult;
import com.loong.login.response.RegisterResult;

@Route(path = "/account/login")
public class UserCenterActivity extends MVPBaseActivity<UserCenterPresenter> implements UserCenterContract.View, View.OnClickListener {

    private TextView titleTv;
    private ViewPager viewPager;
    private LoginPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // 3.
    @Override
    protected void initData() {
        titleTv.setText("");
        adapter = new LoginPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        adapter.setFragments(new LoginFragment());
    }

    // 2.
    @Override
    protected void initView() {
        titleTv = findViewById(R.id.title_name);
        viewPager = findViewById(R.id.view_pager);
    }

    // 4.
    @Override
    protected UserCenterPresenter createPresenter() {
        return new UserCenterPresenter();
    }

    // 1.
    @Override
    protected int getContentViewId() {
        return R.layout.login_page;
    }

    public void login(View view) {
        AccountUtils.userInfo = new UserInfo("10086", "Admin");
        updateLoginState();
    }

    private void updateLoginState() {
//        tvState.setText("这里是登录界面：" + (AccountUtils.userInfo == null ? "未登录" : AccountUtils.userInfo.getUserName()));
    }

    public void exit(View view) {
        AccountUtils.userInfo = null;
        updateLoginState();
    }

    public void loginShare(View view) {
//        ARouter.getInstance().build("/share/share").withString("share_content", "分享数据到微博").navigation();
    }

    @Override
    public void loginSuccess(LoginResult loginResult) {
        Log.e("hao", "登录成功");
        ToastUtil.show(BaseApp.getApplication(), "登录成功！");
        //保存登录状态到本地
        SharedPreferenceUtil.write(Constants.REF_NAME, Constants.IS_LOGIN, true);
        ARouter.getInstance().build("/home/main_activity").navigation();
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

    }
}
