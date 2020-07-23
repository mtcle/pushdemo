package com.mtcle.mpush;

import android.app.Application;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;

import java.util.List;

/**
 * 作者：Lenovo on 2020/7/23 15:19
 * 描述：
 */
public class MPushHelper {
    private static MPushHelper instances = new MPushHelper();

    private MPushHelper() {
    }

    public static MPushHelper getInstance() {
        return instances;
    }

    private Application app;

    /**
     * 初始化SDK
     *
     * @param application
     */
    public void initMPush(Application application) {
        app = application;
    }

    /**
     * 绑定设备,开始工作
     */
    public void bindDevicesStartWork() {
        PushManager.startWork(app,
                PushConstants.LOGIN_TYPE_API_KEY,
                Utils.getMetaValue(app, "api_key"));
    }

    /**
     * 解绑，停止接收推送
     *
     * @param
     */
    public void unBindDevices() {
        // 解绑
        PushManager.stopWork(app);
    }

    /**
     * 添加tags
     *
     * @param tags
     */
    public void setTags(List<String> tags) {
        PushManager.setTags(app, tags);
    }

    public void showTags() {
        PushManager.listTags(app);
    }

    /**
     * 删除tags
     *
     * @param tags
     */
    public void delTags(List<String> tags) {
        PushManager.delTags(app, tags);
    }


    /**
     * 设置免打扰时间段
     * // startHour startMinute：开始 时间 ，24小时制，取值范围 0~23 0~59
     * // endHour endMinute：结束 时间 ，24小时制，取值范围 0~23 0~59
     */
    public void setNoDisturbMode(int startHour,int startMinute,int endHour,int endMinute){
        // Push: 设置免打扰时段
        PushManager.setNoDisturbMode(app,
                startHour, startMinute, endHour, endMinute);
    }
}
