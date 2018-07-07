package com.smile.ch.common.base;

/**
 * @author RuanWei
 * @date 2018/5/2 11:56
 */

public abstract class BasePresenter<V extends BaseView> {


    private V view;

    public V getView() {
        return view;
    }

    public void attachView(V loginView) {
        this.view = loginView;
    }

    public void detachView() {
        this.view = null;
    }


}
