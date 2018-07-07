package ast.tianer.debug;

import com.alibaba.android.arouter.launcher.ARouter;
import com.smile.ch.common.base.BaseApplication;
import com.smile.ch.common.utils.Utils;

/**
 * @author RuanWei
 * @date 2018/5/23 13:09
 */

public class ShopApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //ARouter配置
        if (Utils.isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
    }
}
