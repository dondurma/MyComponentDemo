package ast.tianer.com.mymodule.api;

import com.smile.ch.common.base.bean.BaseResponseBean;

import java.util.List;

import ast.tianer.com.mymodule.bean.ArticleListBean;
import ast.tianer.com.mymodule.bean.BannerBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Author：CHENHAO
 * date：2018/5/4
 * desc：
 */

public interface ArticleApi {
    /**
     * 首页banner图
     */
    @GET("banner/json")
    Observable<BaseResponseBean<List<BannerBean>>> getBannerImgs();

    /**
     * 文章列表数据
     */
    @GET("article/list/{page}/json")
    Observable<BaseResponseBean<ArticleListBean>> getArticleList(@Path("page") int page);
}
