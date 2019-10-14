package com.mtcle.push.demo.configs;

import android.content.Context;

import com.mtcle.push.demo.BuildConfig;

/**
 * 作者：Lenovo on 2019/10/14 10:13
 * 描述：
 */
public class PushHelper {

    private PushOperateInterface miPush;

    private PushHelper() {
        miPush = new PushOperateInterfaceMiImpl();
    }

    private static PushHelper instance = new PushHelper();

    public static PushHelper getInstance() {
        return instance;
    }

    public void initPushConfig(Context context) {
        miPush.init(context);
        miPush.setDebug(context, BuildConfig.DEBUG, "push");
    }

    public void setUnionIds(Context context, String... ids) {
        miPush.setUnionId(context, ids);
    }

    public void pausePush(Context context) {
        miPush.pausePush(context);
    }

    public void resumePush(Context context) {
        miPush.resumePush(context);
    }

    public void stopPush(Context context) {
        miPush.stopPush(context);
    }
}
