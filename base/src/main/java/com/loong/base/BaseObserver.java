package com.loong.base;

import com.loong.base.iView.IView;
import com.loong.base.error.ErrorMsgBean;

import io.reactivex.observers.DisposableObserver;

/**
 * author: Hao
 * date: 2019/10/9 11:17
 * description: 观察者回调数据给上层
 */
public abstract class BaseObserver<T> extends DisposableObserver<BaseResponse<T>> {
    private IView baseView;
    public BaseObserver() {

    }

    public BaseObserver(IView baseView) {
        this.baseView = baseView;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (baseView != null) {
            baseView.showLoading();
        }
    }

    @Override
    public void onNext(BaseResponse<T> tBaseResponse) {
        if (baseView != null) {
            baseView.hideLoading();
        }
        int errorCode = tBaseResponse.getErrorCode();
        String errorMsg = tBaseResponse.getErrorMsg();
        boolean isError = tBaseResponse.isError();
        if (errorCode == 0 || errorCode == 200) {
            T data = tBaseResponse.getData();
            onSuccess(data);
        } else if (!isError) {
            T results = tBaseResponse.getResults();
            onSuccess(results);
        } else {
            onFailed(new ErrorMsgBean(errorCode, errorMsg));
        }
    }

    //observer的重写
    @Override
    public void onError(Throwable e) {
        onFailed(new ErrorMsgBean(e.hashCode(), e.getMessage()));
    }

    protected abstract void onSuccess(T data);

    protected abstract void onFailed(ErrorMsgBean errorMsgBean);

    @Override
    public void onComplete() {
        if (baseView != null) {
            baseView.hideLoading();
        }
    }
}
