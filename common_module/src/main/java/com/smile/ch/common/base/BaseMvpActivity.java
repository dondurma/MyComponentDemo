package com.smile.ch.common.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author RuanWei
 * @date 2018/5/2 13:34
 * 抽象出绑定和解绑操作
 * 注意：为了能兼容多个activity 所以采用的是抽象+泛型设计
 */

public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter<V>> extends Activity {


    private P presenter;
    private V view;

    public abstract P createPresenter();

    public abstract V createView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.presenter == null) {
            this.presenter = createPresenter();

        }

        if (this.view == null) {
            this.view = createView();

        }

        if (this.presenter != null && this.view != null) {
            this.presenter.attachView(this.view);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (this.presenter != null && this.view != null) {
            this.presenter.detachView();
        }
    }

    public P getPresenter(){
        return presenter;
    }


}
