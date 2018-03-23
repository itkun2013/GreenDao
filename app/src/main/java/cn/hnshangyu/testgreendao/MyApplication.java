package cn.hnshangyu.testgreendao;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/10/9.
 */

public class MyApplication extends Application {
    /**
     * 上下文
     */
    private static MyApplication applicationContext;
    /**
     * 记录是否已经初始化
     */
    private boolean isInit = false;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
    }

    public static Context getInstance() {
        return applicationContext;
    }


}
