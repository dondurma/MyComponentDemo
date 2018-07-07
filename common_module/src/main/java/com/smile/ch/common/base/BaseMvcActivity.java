package com.smile.ch.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author RuanWei
 * @date 2018/5/23 10:57
 */

public abstract class BaseMvcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initToolbar();
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();


    protected void initToolbar() {

    }
}
