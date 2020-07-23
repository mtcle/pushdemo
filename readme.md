## android的推送模块，支持离线推送
### android离线推送一般都是使用那几个主流的推送平台，极光、个推等等，但是他们的android厂商通道都是要收费的，并且价格不菲，个人开发者基本是负担不起，
所以最近发现了百度的推送在2020.6月刚刚支持厂商推送通道，就集成体验了一把。还可以，但是集成过程实在是不敢恭维...感觉有点对不起bat称谓。我自己就封装一把，方便以后使用吧。

## 使用方式
### Step 1.  Add the dependency
    dependencies {	
        implementation 'com.mtcle.mpush:mpush:0.0.1'
	}   
### 初始化SDK
```
1、application中初始化
MPushHelper.getInstance().initMPush(this);
2、起始页面启动
MPushHelper.getInstance().bindDevicesStartWork();
3、实现接口PushMessageReceiver 处理推送数据
```
