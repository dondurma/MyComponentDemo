package ast.tianer.com.mymodule.model;

import android.content.Context;

import com.smile.ch.common.base.bean.BaseResponseBean;
import com.smile.ch.common.http.RxObserver;
import com.smile.ch.common.http.RxRetrofitManager;
import com.smile.ch.common.http.cancle.ApiCancleManager;

import java.util.List;

import ast.tianer.com.mymodule.api.ArticleApi;
import ast.tianer.com.mymodule.bean.ArticleListBean;
import ast.tianer.com.mymodule.bean.BannerBean;
import ast.tianer.com.mymodule.contract.ArticleContract;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Author：CHENHAO
 * date：2018/5/3
 * desc：
 */

public class ArticleListModel implements ArticleContract.BannerModel {
    /**
     * 请求banner图片以及文章列表数据
     */
    @Override
    public void getBannerDatas(Context context, final int page, final ArticleContract.IBannerModelCallback callback, final ArticleContract.IArticleListModelCallback articleCallback) {
        RxRetrofitManager.getInstance()
                .setTag("articleBanner")
                .getApiService(ArticleApi.class)
                //请求轮播图片
                .getBannerImgs()
                //指定上游发送的线程
                .subscribeOn(Schedulers.io())
                //指定下游接收的线程
                .observeOn(AndroidSchedulers.mainThread())
                //下游接收的数据
                .doOnNext(new Consumer<BaseResponseBean<List<BannerBean>>>() {
                    @Override
                    public void accept(BaseResponseBean<List<BannerBean>> listBaseResponseBean) throws Exception {
                        if (listBaseResponseBean.getErrorCode() >= 0) {
                            if (callback != null) {
                                callback.onSuccess(listBaseResponseBean);
                            }
                        } else {
                            if (callback != null) {
                                callback.onFail(listBaseResponseBean.getErrorMsg());
                            }
                        }
                    }
                })
                //回到IO线程中去发起请求列表数据请求
                .observeOn(Schedulers.io())
                //FlatMap将一个发送事件的上游Observable变换为多个发送事件的Observables，
                // 然后将它们发射的事件合并后放进一个单独的Observable里
                .flatMap(new Function<BaseResponseBean<List<BannerBean>>, ObservableSource<BaseResponseBean<ArticleListBean>>>() {
                    @Override
                    public ObservableSource<BaseResponseBean<ArticleListBean>> apply(BaseResponseBean<List<BannerBean>> listBaseResponseBean) throws Exception {
                        //请求文章列表数据
                        return RxRetrofitManager.getInstance().getApiService(ArticleApi.class).getArticleList(page);
                    }
                })
                //回到主线程中去处理列表数据的结果
                .observeOn(AndroidSchedulers.mainThread())
                //下游水管接收数据
                .subscribe(new RxObserver<BaseResponseBean<ArticleListBean>>(context, true) {
                    @Override
                    public void onSuccess(BaseResponseBean<ArticleListBean> response) {
                        if (articleCallback != null) {
                            articleCallback.onSuccess(response.getData().getDatas());
                        }
                    }

                    @Override
                    public void onFailed(BaseResponseBean<ArticleListBean> response) {
                        if (articleCallback != null) {
                            articleCallback.onFail(response.getErrorMsg());
                        }
                    }
                });
    }

    @Override
    public void cancleHttpRequest() {
        ApiCancleManager.getInstance().cancel("articleBanner");
    }
}
