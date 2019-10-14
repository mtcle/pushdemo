package com.mtcle.push.demo.configs;

import android.content.Context;
import android.util.Log;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;

/**
 * 作者：Lenovo on 2019/10/14 10:17
 * 描述：小米推送实现
 */
public class PushOperateInterfaceMiImpl implements PushOperateInterface {


    @Override
    public void init(Context context) {
        MiPushClient.registerPush(context, PushConfig.MI_PUSH_APPID, PushConfig.MI_PUSH_APPKEY);
    }

    @Override
    public void setUnionId(Context context, String... ids) {
        //账号、别名、tag
        if (ids.length < 3) {
            throw new RuntimeException("请依次赋值账号、别名、tag");
        }
        MiPushClient.setUserAccount(context, ids[0], null);//账号
        MiPushClient.setAlias(context, ids[1], null);//别名
        MiPushClient.subscribe(context, ids[2], null);//topic
    }

    @Override
    public void resumePush(Context context) {
        MiPushClient.resumePush(context, "");
    }

    @Override
    public void pausePush(Context context) {
        MiPushClient.resumePush(context, "");
    }

    @Override
    public void stopPush(Context context) {
        MiPushClient.unregisterPush(context);
    }


    @Override
    public void setDebug(Context context, boolean debugable, final String tag) {
        LoggerInterface newLogger = new LoggerInterface() {

            @Override
            public void setTag(String tag) {
                // ignore
            }

            @Override
            public void log(String content, Throwable t) {
                Log.d(tag, content, t);
            }

            @Override
            public void log(String content) {
                Log.d(tag, content);
            }
        };
        Logger.setLogger(context, newLogger);
    }


}
