package ast.tianer.com.shopmodule.presenter;

import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.smile.ch.common.base.BasePresenter;

import ast.tianer.com.shopmodule.model.ShopModel;
import ast.tianer.com.shopmodule.view.ShopView;

/**
 * @author RuanWei
 * @date 2018/5/24 11:19
 */

public class ShopPresenter extends BasePresenter<ShopView> {

    private ShopModel shopModel;

    public ShopPresenter() {
        this.shopModel = new ShopModel();
    }

    public void getShopData(String cityName,String userId){
        this.shopModel.getShopData(cityName, userId, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (getView()!=null) {
                    getView().onShopResult(response.body());
                }
            }

            @Override
            public void onCacheSuccess(Response<String> response) {
                super.onCacheSuccess(response);
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
            }
        });
    }
}
