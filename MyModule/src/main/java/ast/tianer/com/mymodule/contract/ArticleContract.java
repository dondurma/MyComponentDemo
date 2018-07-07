package ast.tianer.com.mymodule.contract;

import android.content.Context;

import com.smile.ch.common.base.BaseView;
import com.smile.ch.common.base.bean.BaseResponseBean;

import java.util.List;

import ast.tianer.com.mymodule.bean.ArticleListBean;
import ast.tianer.com.mymodule.bean.BannerBean;

/**
 * Author：CHENHAO
 * date：2018/5/3
 * desc：契约类
 */

public class ArticleContract {
    public interface BannerView extends BaseView {
        void onBannerSuccess(List<BannerBean> lists);

        void onBannerFail(String msg);

        void onArticleListSuccess(List<ArticleListBean.DatasBean> lists);

        void onArticleListFail(String msg);
    }

    public interface BannerModel {
        /**
         * 请求数据，回调
         *
         * @param context
         * @param page
         * @param callback
         * @param callback2
         */
        void getBannerDatas(Context context, int page, IBannerModelCallback callback, IArticleListModelCallback callback2);

        /**
         * 取消请求
         */
        void cancleHttpRequest();
    }

    public interface IBannerModelCallback {
        void onSuccess(BaseResponseBean<List<BannerBean>> response);

        void onFail(String msg);
    }

    public interface IArticleListModelCallback {
        void onSuccess(List<ArticleListBean.DatasBean> lists);

        void onFail(String msg);
    }
}
