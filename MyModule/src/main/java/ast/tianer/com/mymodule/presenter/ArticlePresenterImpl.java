package ast.tianer.com.mymodule.presenter;

import android.content.Context;

import com.smile.ch.common.base.BasePresenter;
import com.smile.ch.common.base.bean.BaseResponseBean;

import java.util.List;

import ast.tianer.com.mymodule.bean.ArticleListBean;
import ast.tianer.com.mymodule.bean.BannerBean;
import ast.tianer.com.mymodule.contract.ArticleContract;
import ast.tianer.com.mymodule.model.ArticleListModel;

/**
 * Author：CHENHAO
 * date：2018/5/3
 * desc：
 */

public class ArticlePresenterImpl extends BasePresenter<ArticleContract.BannerView> {
    private ArticleListModel model;

    public ArticlePresenterImpl() {
        model = new ArticleListModel();
    }

    /**
     * 请求banner图片、文章列表数据
     */
    public void requestBannerImgs(Context context, int page) {
        model.getBannerDatas(context, page, new ArticleContract.IBannerModelCallback() {
            @Override
            public void onSuccess(BaseResponseBean<List<BannerBean>> response) {
                if (getView() != null) {
                    getView().onBannerSuccess(response.getData());
                }
            }

            @Override
            public void onFail(String msg) {
                if (getView() != null) {
                    getView().onBannerFail(msg);
                }
            }
        }, new ArticleContract.IArticleListModelCallback() {
            @Override
            public void onSuccess(List<ArticleListBean.DatasBean> lists) {
                if (getView() != null) {
                    getView().onArticleListSuccess(lists);
                }
            }

            @Override
            public void onFail(String msg) {
                if (getView() != null) {
                    getView().onArticleListFail(msg);
                }
            }
        });
    }

    /**
     * 取消请求
     */
    public void cancleHttpRequest() {
        model.cancleHttpRequest();
    }
}
