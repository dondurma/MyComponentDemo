package ast.tianer.com.mainmodule;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.smile.ch.common.base.ARouterManager;
import com.smile.ch.common.base.BaseMvcActivity;

public class MainActivity extends BaseMvcActivity implements View.OnClickListener {
    private Fragment mHomeFragment;
    private Fragment mShopFragment;
    private Fragment mMyFragment;

    private View mTabTextViewHome;
    private View mTabTextViewShop;
    private View mTabTextViewMy;

    private View mTabImageViewHome;
    private View mTabImageViewShop;
    private View mTabImageViewMy;

    private View mLayoutTabHome;
    private View mLayoutTabShop;
    private View mLayoutTabMy;

    private int mCurrentTabIndex = 0;
    private FragmentManager fragmentManager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mLayoutTabHome = findViewById(R.id.layout_tab_home);
        mLayoutTabShop = findViewById(R.id.layout_tab_shop);
        mLayoutTabMy = findViewById(R.id.layout_tab_me);

        mTabTextViewHome = findViewById(R.id.tv_tab_home);
        mTabTextViewShop = findViewById(R.id.tv_tab_shop);
        mTabTextViewMy = findViewById(R.id.tv_tab_me);

        mTabImageViewHome = findViewById(R.id.iv_tab_home);
        mTabImageViewShop = findViewById(R.id.iv_tab_shop);
        mTabImageViewMy = findViewById(R.id.iv_tab_me);

        mLayoutTabHome.setOnClickListener(this);
        mLayoutTabShop.setOnClickListener(this);
        mLayoutTabMy.setOnClickListener(this);
        initData();
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.layout_tab_home) {
            setTabSelection(0);
        } else if (i == R.id.layout_tab_shop) {
            setTabSelection(1);
        } else if (i == R.id.layout_tab_me) {
            setTabSelection(2);
        }

    }

    private void initData() {
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);
        mTabImageViewHome.setSelected(true);
        mTabTextViewHome.setSelected(true);
    }


    /**
     * 根据传入的index参数来设置选中的tab页。
     */
    private void setTabSelection(int index) {
        resetBtn();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                mTabImageViewHome.setSelected(true);
                mTabTextViewHome.setSelected(true);

                if (mHomeFragment == null) {
                    //  如果Fragment为空，则创建一个并添加到界面上
                    mHomeFragment = (Fragment) ARouter.getInstance().build(ARouterManager.HomeFragment).navigation();
                    transaction.add(R.id.id_content, mHomeFragment);
                } else {
                    // 如果Fragment不为空，则直接将它显示出来
                    transaction.show(mHomeFragment);
                }
                mCurrentTabIndex = 0;
                break;
            case 1:
                mTabImageViewShop.setSelected(true);
                mTabTextViewShop.setSelected(true);
                if (mShopFragment == null) {
                    mShopFragment = (Fragment) ARouter.getInstance().build(ARouterManager.ShopFragment).navigation();
                    transaction.add(R.id.id_content, mShopFragment);
                } else {
                    transaction.show(mShopFragment);
                }
                mCurrentTabIndex = 1;
                break;

            case 2:
                mTabImageViewMy.setSelected(true);
                mTabTextViewMy.setSelected(true);
                if (mMyFragment == null) {
                    mMyFragment = (Fragment) ARouter.getInstance().build(ARouterManager.MeFragment).navigation();

                    transaction.add(R.id.id_content, mMyFragment);
                } else {
                    transaction.show(mMyFragment);
                }
                mCurrentTabIndex = 2;
                break;
            default:
                break;
        }
        transaction.commit();
    }


    /**
     * 清除掉所有的选中状态。
     */
    private void resetBtn() {
        mTabImageViewHome.setSelected(false);
        mTabTextViewHome.setSelected(false);
        mTabTextViewShop.setSelected(false);
        mTabImageViewShop.setSelected(false);
        mTabImageViewMy.setSelected(false);
        mTabTextViewMy.setSelected(false);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mShopFragment != null) {
            transaction.hide(mShopFragment);
        }

        if (mMyFragment != null) {
            transaction.hide(mMyFragment);
        }

    }
}
