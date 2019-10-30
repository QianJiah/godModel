package com.loong.base.iPresenter;

import com.loong.base.iView.IView;

/**
 * author: Hao
 * date: 2019/10/8 18:38
 * description:
 */
public interface IPresenter<V extends IView> {

    void attachView(V view);

    void detachView();

    boolean isAttachedView();

    V getView();
}
