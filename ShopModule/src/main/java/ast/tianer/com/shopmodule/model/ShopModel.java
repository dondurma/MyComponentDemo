package ast.tianer.com.shopmodule.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.smile.ch.common.Constants.BaseUrls;

/**
 * @author RuanWei
 * @date 2018/5/24 11:19
 */

public class ShopModel {
    public void getShopData(String cityName, String userId, StringCallback response) {
        OkGo.<String>get(BaseUrls.doReadProductIndexInfo)
                .tag(this)
                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)
                .cacheKey(BaseUrls.doReadIndexInfo)
                .cacheTime(3600 * 1000)
//                .params("cityName", "杭州")
//                .params("userId", "F2EE5DC7DE3911E7B19800163E0EB16B")
                .params("cityName", cityName)
                .params("userId", userId)
                .execute(response);
    }
}
