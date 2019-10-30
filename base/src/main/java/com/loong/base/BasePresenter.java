package com.loong.base;

import android.app.Activity;
import android.content.Context;

import com.loong.base.http.RetrofitClient;
import com.loong.base.iPresenter.IPresenter;
import com.loong.base.iView.IView;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author: Hao
 * date: 2019/10/9 9:02
 * description:basePresenter<V>
 */
public class BasePresenter<V extends IView> implements IPresenter<V> {

    //持有View的弱引用
    private WeakReference<V> viewReference;
    //管理订阅关系
    private CompositeDisposable disposable;
    private Context context;

    public BasePresenter() {

    }

    @Override
    public void attachView(V view) {
        viewReference = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        this.viewReference = null;
        //解绑订阅
        unsubscribe();
    }

    //添加订阅
    public void addSubscribe(Observable<?> observable, BaseObserver observer) {
        if (disposable == null) {
            disposable = new CompositeDisposable();
        }
        BaseObserver baseObserver = observable.subscribeOn(Schedulers.newThread())
                                                .observeOn(AndroidSchedulers.mainThread())
                                                .subscribeWith(observer);
        disposable.add(baseObserver);
    }

    private void unsubscribe() {
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override
    public boolean isAttachedView() {
        return viewReference.get() != null;
    }

    @Override
    public V getView() {
        return viewReference.get();
    }

    protected <T> T create(Class<T> clazz) {
        return RetrofitClient.getRetrofitClient().getRetrofit().create(clazz);
    }
}
