package com.app.movie.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.app.movie.R;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //先加载布局文件
        setContentView(getLayoutResId());
        //初始化控件
        initViews();
        //点击事件
        initListener();
        //初始化数据
        initData();
    }


    protected abstract int getLayoutResId();

    protected abstract void initViews();

    protected abstract void initListener();

    protected abstract void initData();
}
