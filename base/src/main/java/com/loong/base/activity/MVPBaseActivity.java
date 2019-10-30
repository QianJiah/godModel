package com.loong.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.loong.base.BaseActivity;
import com.loong.base.iPresenter.IPresenter;
import com.loong.base.iView.IView;
import com.loong.base.util.LoadingDialog;

/**
 * author: Hao
 * date: 2019/10/8 18:53
 * description:
 */
public abstract class MVPBaseActivity<P extends IPresenter> extends BaseActivity implements IView {

    protected P presenter;
    protected LoadingDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }

    protected abstract P createPresenter();

    @Override
    protected abstract int getContentViewId();

    @Override
    public void showLoading() {
        LoadingDialog.Builder builder = new LoadingDialog.Builder(this);
        dialog = builder.setOutSideCancel(false)
                .setCanceled(true)
                .setShowMsg(true)
                .setMsg("Loading...")
                .create();
        dialog.show();
    }

    @Override
    public void hideLoading() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
