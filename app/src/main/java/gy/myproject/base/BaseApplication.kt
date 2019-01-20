package gy.myproject.base;

import android.app.Activity
import android.app.Application
import android.app.Notification
import android.content.Context
import android.os.Bundle
import android.os.Handler
import com.arialyy.frame.core.AbsFrame
import com.tencent.bugly.crashreport.CrashReport
import java.util.*
import kotlin.collections.ArrayList


/**
 * Created by Finder丶畅畅 on 2017/11/4 22:18
 * QQ群481606175
 */

class BaseApplication : Application() {
    //为了实现每次使用该类时不创建新的对象而创建的静态对象
    private var instance: BaseApplication? = null

    object list {
        //用object修饰，相当于Java中的static，用object修饰一个变量，可以实现全局变量的效果
        var mList: ArrayList<Activity>? = ArrayList()
    }

    //实例化一次
    @Synchronized
    fun getInstance(): BaseApplication {
        if (null == instance) {
            instance = BaseApplication()
        }
        return instance as BaseApplication
    }


    //杀进程
    override fun onLowMemory() {
        super.onLowMemory()
        System.gc()
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        AbsFrame.init(this)
        mHandler = Handler()
//        CrashReport.initCrashReport(applicationContext, "4f210c2124", true);
        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数3:Push推送业务的secret
         */
//        UMShareAPI.get(this);//初始化sdk
//        UMConfigure.setLogEnabled(true);
//
//        UMConfigure.init(this, "562dce4e67e58e3f1900131b"
//                , "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
//        PlatformConfig.setWeixin(wx_appid, "ffd29e0ffcd2e1a1847cff1cce46c488");
//        //豆瓣RENREN平台目前只能在服务器端配置
//        PlatformConfig.setSinaWeibo("1796079188", "76848d781f75428961a0dd0aa36bd7f6", "http://sns.whalecloud.com/sina2/callback");
//        PlatformConfig.setQQZone("1107945236", "VKujYs2cKXSukwre");
//        JPushInterface.setDebugMode(true)    // 设置开启日志,发布时请关闭日志
//        JPushInterface.init(this)            // 初始化 JPush
//
//        val builder = BasicPushNotificationBuilder(this)
//        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL or Notification.FLAG_SHOW_LIGHTS  //设置为自动消失和呼吸灯闪烁
//        builder.notificationDefaults = (Notification.DEFAULT_SOUND
//                or Notification.DEFAULT_VIBRATE
//                or Notification.DEFAULT_LIGHTS)  // 设置为铃声、震动、呼吸灯闪烁都要
//        JPushInterface.setPushNotificationBuilder(1, builder)
    }

    companion object {
        var context: Context? = null
        var mHandler: Handler? = null
        var wx_appid = "wxd99ea3e19c226001"
        // add Activity
        fun addActivity(activity: Activity) {
            list.mList?.add(activity)

        }


        //关闭每一个list内的activity
        fun exit() {
            try {
                for (i in 0..list.mList!!.size - 1) {
                    list.mList!![i].finish()

                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
//                System.exit(0)
            }
        }
        fun removeActivity(activity: Activity){
            list.mList?.remove(activity)
        }
    }




}
