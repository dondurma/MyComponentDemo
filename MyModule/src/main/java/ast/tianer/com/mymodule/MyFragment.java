package ast.tianer.com.mymodule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.smile.ch.common.base.ARouterManager;
import com.smile.ch.common.base.BaseFragment;
import com.smile.ch.common.base.BaseMvpFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import ast.tianer.com.mymodule.adapter.ArticleListAdapter;
import ast.tianer.com.mymodule.bean.ArticleListBean;
import ast.tianer.com.mymodule.bean.BannerBean;
import ast.tianer.com.mymodule.contract.ArticleContract;
import ast.tianer.com.mymodule.presenter.ArticlePresenterImpl;
import ast.tianer.com.mymodule.utils.GlideImageLoad;

/**
 * @author RuanWei
 * @date 2018/5/23 13:16
 */
@Route(path = ARouterManager.MeFragment)
public class MyFragment extends BaseMvpFragment<ArticleContract.BannerView, ArticlePresenterImpl>implements ArticleContract.BannerView, OnBannerListener, ArticleListAdapter.OnRvItemClickListener {
    private Banner banner;
    private RecyclerView recyclerView;
    private ArticleListAdapter listAdapter;
    private List<String> bannerImgLists;
    private List<ArticleListBean.DatasBean> mDatas;
    private List<BannerBean> bannerLists;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        banner = view.findViewById(R.id.index_banner);
        recyclerView = view.findViewById(R.id.article_rv);
        mDatas = new ArrayList<>();
        listAdapter = new ArticleListAdapter(getContext(), mDatas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);

        initBanner();
    }

    @Override
    public void onBannerSuccess(List<BannerBean> lists) {
        if (lists != null && lists.size() > 0) {
            bannerLists = new ArrayList<>();
            bannerLists.addAll(lists);
            bannerImgLists = new ArrayList<>();
            for (BannerBean bean : lists) {
                bannerImgLists.add(bean.getImagePath());
            }
            banner.setImages(bannerImgLists);
            banner.start();
        }
    }

    @Override
    public void onBannerFail(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onArticleListSuccess(List<ArticleListBean.DatasBean> lists) {
        if (lists != null && lists.size() > 0) {
            mDatas.addAll(lists);
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onArticleListFail(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public ArticlePresenterImpl createPresenter() {
        return new ArticlePresenterImpl();
    }

    @Override
    public ArticleContract.BannerView createView() {
        return this;
    }



    @Override
    protected void getData() {
        getPresenter().requestBannerImgs(getContext(), 1);

    }


    private void initBanner() {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置指示器位置
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoad());
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置是否自动轮播
        banner.isAutoPlay(true);
        //设置轮播间隔时间
        banner.setDelayTime(2000);
        /*//设置数据集合
        banner.setImages(lists);*/
        //设置banner点击事件
        banner.setOnBannerListener(this);
    }

    @Override
    protected void initAdapter() {

    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void OnBannerClick(int position) {

    }
}
