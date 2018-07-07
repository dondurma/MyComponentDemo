# ComponentDemo
> Demo参考：[https://www.jianshu.com/p/010d946e8f67](https://www.jianshu.com/p/010d946e8f67) 
> [https://github.com/smileCH/ComponentProject](https://github.com/smileCH/ComponentProject)

## 说明
- 整个demo采用组件化开发思想
- 分为三个模块，有HomeModule、ShopModule、MyModule
- HomeModule使用Mvc设计模式+OkGo网络请求框架，也是最普通的写法
- ShopModule采用MVP设计模式+OkGo网络请求框架
- MyModule采用MVP设计模式和Retrofit+Okhttp+Rxjava2请求框架

## 配置步骤
1. 在项目的最外层创建一个config.gradle文件，用来处理整个项目中统一依赖的问题,里面具体配置如下：

```
ext {
    android = [
            //编译SDK版本号
            compileSdkVersion: 26,
            //最小支持SDK版本号
            minSdkVersion    : 16,
            //最高支持到的SDK版本号
            targetSdkVersion : 26,
            //当前版本号，用来app版本升级，每升级一次 versionCode加1，为正整数
            versionCode      : 1,
            //当前版本名，用来app版本升级，每升级一次，versionName根据需求变动，
            //通常格式为"x.x","x.x.x",主要用来展示给用户查看
            versionName      : "1.0"
            
    ]
    //将dependencies中依赖的第三方库的版本号统一管理
    libsVersion = [
            supportLibraryVersion = "26.1.0",
            constraint_layout = "1.1.0",
            retrofit = "2.3.0",
            retrofit_converter_gson = "2.3.0",
            retrofit_adapter_rxjava2 = "2.3.0",
            gson = "2.8.0",
            rxandroid = "2.0.2",
            rxjava = "2.1.8",
            glide = "3.7.0",
            eventbus = "3.0.0",
            multidex = "1.0.1",
            logging_interceptor = "3.5.0",
            SmartRefreshLayout = "1.0.5.1",
            arouter_compiler = "1.1.4",
            arouter_api = "1.3.1",
            banner_api = "v2.0.1",
            banner = "1.4.10",
            okgo = "3.0.4"
    ]
    //整个项目中需要用到的第三方库，其中含有版本号（数字的地方）替换成"$rootProject"，在libsVersion中统一管理
    dependencies = [
            appcompat_v7            : "com.android.support:appcompat-v7:$rootProject.supportLibraryVersion",
            design                  : "com.android.support:design:$rootProject.supportLibraryVersion",
            constraint_layout       : "com.android.support.constraint:constraint-layout:$rootProject.constraint_layout",
            retrofit                : "com.squareup.retrofit2:retrofit:$rootProject.retrofit",
            retrofit_converter_gson : "com.squareup.retrofit2:converter-gson:$rootProject.retrofit_converter_gson",
            retrofit_adapter_rxjava2: "com.squareup.retrofit2:adapter-rxjava2:$rootProject.retrofit_adapter_rxjava2",
            gson                    : "com.google.code.gson:gson:$rootProject.gson",
            rxandroid               : "io.reactivex.rxjava2:rxandroid:$rootProject.rxandroid",
            rxjava                  : "io.reactivex.rxjava2:rxjava:$rootProject.rxjava",
            glide                   : "com.github.bumptech.glide:glide:$rootProject.glide",
            eventbus                : "org.greenrobot:eventbus:$rootProject.eventbus",
            multidex                : "com.android.support:multidex:$rootProject.multidex",
            okhttp3_logging         : "com.squareup.okhttp3:logging-interceptor:$rootProject.logging_interceptor",
            SmartRefreshLayout      : "com.scwang.smartrefresh:SmartRefreshLayout:$rootProject.SmartRefreshLayout",
            arouter_compiler        : "com.alibaba:arouter-compiler:$rootProject.arouter_compiler",
            arouter_api             : "com.alibaba:arouter-api:$rootProject.arouter_api",
            banner_api              : "com.github.pinguo-zhouwei:MZBannerView:$rootProject.banner_api",
            banner                  : "com.youth.banner:banner:$rootProject.banner",
            okgo                    : "com.lzy.net:okgo:$rootProject.okgo"
    ]
}

```

2. 在项目的build.gradle配置文件中的buildscript里面添加依赖`apply from: "config.gradle"`,用来引用config.gradle文件
3. 导入公用模块common_module，common_module中的build.gradle以及相关公用代码已经配置好，后期可以根据自己项目需求添加或删减
4. 根据实际情况，添加业务module,该demo中的业务module有HomeModule、ShopModule、MyModule三个业务module以及MainModule，MainModule作为项目的入口，采用ARouter路由框架跳转到各个业务模块
5. 在app的module中进行一些基础配置，添加application类，以及在app的build.gradle中进行配置，具体参见代码
6. 配置ARouter路由框架，在app的MyApplication类的onCreate()方法中配置如下：
```
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

```







