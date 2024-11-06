package com.app.movie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.app.movie.base.BaseActivity;
import com.app.movie.fragment.CategoryFragment;
import com.app.movie.fragment.HomeFragment;
import com.app.movie.fragment.MineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {
    private BottomNavigationView main_bottom_nv;
    private View content;
    private HomeFragment mHomeFragment;
    private CategoryFragment mCategoryFragment;
    private MineFragment mMineFragment;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        main_bottom_nv = findViewById(R.id.main_bottom_nv);
        content = findViewById(R.id.content);

    }

    @Override
    protected void initListener() {
        main_bottom_nv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //切换Fragment
                if (item.getItemId() == R.id.home) {
                    selectFragment(0);
                } else if (item.getItemId() == R.id.category) {
                    selectFragment(1);
                } else {
                    selectFragment(2);
                }
                return true;
            }
        });
    }

    @Override
    protected void initData() {

    }

    private void selectFragment(int position) {
        //获取fragmentManager管理器
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        if (position == 0) {
            if (mHomeFragment == null) {
                mHomeFragment = new HomeFragment();
                transaction.add(R.id.content, mHomeFragment);
            } else {
                transaction.show(mHomeFragment);
            }
        } else if (position == 1) {
            if (mCategoryFragment == null) {
                mCategoryFragment = new CategoryFragment();
                transaction.add(R.id.content, mCategoryFragment);
            } else {
                transaction.show(mCategoryFragment);

            }
        } else {
            if (mMineFragment == null) {
                mMineFragment = new MineFragment();
                transaction.add(R.id.content, mMineFragment);
            } else {
                transaction.show(mMineFragment);
            }
        }

        //注意：这句话一定不能少！！！！！！
        transaction.commit();

    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mCategoryFragment != null) {
            transaction.hide(mCategoryFragment);
        }
        if (mMineFragment != null) {
            transaction.hide(mMineFragment);
        }

    }
}