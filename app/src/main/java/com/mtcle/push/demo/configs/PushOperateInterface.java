package com.mtcle.push.demo.configs;

import android.content.Context;

/**
 * 作者：Lenovo on 2019/10/14 10:15
 * 描述：离线推送统一接口
 */
public interface PushOperateInterface {
    void init(Context context);

    void setUnionId(Context context, String... ids);

    void pausePush(Context context);

    void resumePush(Context context);

    void stopPush(Context context);

    void setDebug(Context context, boolean debugable, String tag);
}
