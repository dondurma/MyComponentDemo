package com.smile.ch.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @author RuanWei
 * @date 2018/5/2 14:02
 * 抽象的Fragment
 */

public abstract class BaseMvpFragment<V extends BaseView,P extends BasePresenter> extends Fragment {

    private P presenter;
    private V view;

    public Context context;

    public abstract P createPresenter();

    public abstract V createView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (this.presenter == null) {
            this.presenter = createPresenter();

        }

        if (this.view == null) {
            this.view = createView();

        }

        if (this.presenter != null && this.view != null) {
            this.presenter.attachView(this.view);
        }
        initViews();

    }



    private void initViews() {
        initAdapter();
        getData();
    }
    protected abstract void getData();
    protected abstract void initAdapter();


    public View getViewByRes(int res) {
        return LayoutInflater.from(context).inflate(res, null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (this.presenter != null && this.view != null) {
            this.presenter.detachView();
        }
    }

    public P getPresenter(){
        return presenter;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

}
