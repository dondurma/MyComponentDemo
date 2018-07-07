package ast.tianer.com.componentdemo;

import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.smile.ch.common.base.BaseApplication;
import com.smile.ch.common.utils.Utils;

/**
 * @author RuanWei
 * @date 2018/5/23 10:32
 */

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //突破65535的限制
        MultiDex.install(this);
        //ARouter配置
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (Utils.isDebug()) {
            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(this);
    }
}
