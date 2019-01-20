package gy.myproject.config

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback


import okhttp3.Call
import okhttp3.Response

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.databinding.adapters.SeekBarBindingAdapter.setProgress
import gy.myproject.base.BaseModule
import gy.myproject.callback.JsonCallback
import gy.myproject.callback.LzyResponse
import gy.myproject.callback.NewStringCallBack
import gy.myproject.callback.NormalRequest

import java.io.File


/**
 * Created by Finder丶畅畅 on 2018/8/29 00:35
 * QQ群481606175
 */
class HttpUtils<T> {

    fun post(url: String, back_id: Int, control: BaseModule) {
        post(url, back_id, null, control)
    }

    fun posts(cla: Class<T>) {
        var s = cla
        var s1 = ""
        OkGo.post("").execute(object : JsonCallback<LzyResponse<T>>() {
            override fun onSuccess(t: LzyResponse<T>?, call: Call?, response: Response?) {

            }

            override fun onError(call: Call?, response: Response?, e: Exception?) {
                super.onError(call, response, e)
            }
        })
    }


    /**
     * @param url 网络访问路径
     * @param model 需要解析的model
     * @param back_id 请求码
     * @param list post过去的参数
     * */
    fun post(url: String, back_id: Int, map: HashMap<String, String>?, control: BaseModule) {
        var go = OkGo.get(url)
        if (map != null) {
            for (model in map) {
                go.params(model.key, model.value)
            }
        }
//        if (back_id > login) {
//            var token = Utils.getCache(sp.token)
//            if (!TextUtils.isEmpty(token)) {
//                go!!.params("Token", token)//令牌
//            }
//            val df = SimpleDateFormat("yyyyMMddHHmmss")//设置日期格式
//            var TimeStamp = df.format(Date())// new Date()为
//            var md5 = Utils.getCache(sp.pwd)// 获取当前系统时间
//            var md51 = string2MD5(Utils.getCache(sp.pwd))
//            go!!.params("AccountId", Utils.getCache(sp.user_id))//账号id 密码先md5加密
//                    .params("AccountSecret", Sha1.encode(string2MD5(Utils.getCache(sp.pwd)).toUpperCase() + "_" + TimeStamp).toUpperCase())
//                    .params("TimeStamp", TimeStamp)
//        }
        go.execute(object : NewStringCallBack() {
            override fun onSuccess(str: String, call: okhttp3.Call?, response: okhttp3.Response?) {
                if (!str.equals("")) {
                    var t = Gson().fromJson(str, LzyResponse::class.java)
//                    if (200 == t.code) {
                    try {
                        //t.Data as LinkedTreeMap<String, String>
                        var em = JsonParser().parse(str).asJsonObject.get("data").asJsonObject
                        control.callback(back_id, NormalRequest(t.code, t.msg, em))
                    } catch (e: Exception) {
                        try {
                            var em = JsonParser().parse(str).asJsonObject.get("data").asJsonArray
                            control.callback(back_id, NormalRequest(t.code, t.msg, em))
                        } catch (e: Exception) {
                            var em = JsonParser().parse(str).asJsonObject.get("data").asString
                            control.callback(back_id, NormalRequest(t.code, t.msg, em))
                        }
                    }
//                    } else {
//                        var em = JsonParser().parse(str).asJsonObject.get("data")
//                        control.callback(back_id, NormalRequest(t.code, t?.msg, em))
//                    }
                } else {
                    control.callback(back_id, NormalRequest<T>(2, "未知错误,服务器错误", null))
                }
            }

            override fun onError(call: Call?, response: Response?, e: Exception?) {
                control.callback(back_id, NormalRequest<T>(2, "未知错误：" + e.toString(), null))
            }

        })
    }

    fun get(url: String, back_id: Int, control: BaseModule) {
        get(url, back_id, null, control)
    }

    fun uploadFiles(url: String, uid: String, keyName: String, back_id: Int, token: String, files: List<File>, control: BaseModule) {
        var go = OkGo.post(url)
        go.isMultipart(true)       // 强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .params(keyName, File(files[0].toString()))
        //.addFileParams(keyName, files)
        // 可以添加文件上传
        //.params("file2", new File("filepath2"))
        // .params("param1", "paramValue1")   // 支持多文件同时添加上传
        if (!token.equals("")) {
            go.params("token", token)
            go.params("user_id", uid)
        }
        // 这里支持一个key传多个文件
        go.execute(object : NewStringCallBack() {
            override fun onSuccess(str: String, call: okhttp3.Call?, response: okhttp3.Response?) {
                if (!str.equals("")) {
                    var t = Gson().fromJson(str, LzyResponse::class.java)
                    if (true) {
                        try {
                            //t.Data as LinkedTreeMap<String, String>
                            var em = JsonParser().parse(str).asJsonObject.get("data").asJsonObject
                            control.callback(back_id, NormalRequest(t.code, t.msg, em))
                        } catch (e: Exception) {
                            try {
                                var em = JsonParser().parse(str).asJsonObject.get("data").asJsonArray
                                control.callback(back_id, NormalRequest(t.code, t.msg, em))
                            } catch (e: Exception) {
                                var em = JsonParser().parse(str).asJsonObject.get("data").asString
                                control.callback(back_id, NormalRequest(t.code, t.msg, em))
                            }
                        }
                    } else {
                        var em = JsonParser().parse(str).asJsonObject.get("data")
                        control.callback(back_id, NormalRequest(t.code, t?.msg, em))
                    }
                } else {
                    control.callback(back_id, NormalRequest<T>(404, "服务器出现错误了", null))
                }
            }

            override fun onError(call: Call?, response: Response?, e: Exception?) {
                control.callback(back_id, NormalRequest<T>(2, "未知错误：" + e.toString(), null))
            }
        })
    }

    /**
     * @param url 网络访问路径
     * @param model 需要解析的model
     * @param back_id 请求码
     * @param list post过去的参数
     * */
    fun get(url: String, back_id: Int, map: HashMap<String, String>?, control: BaseModule) {
        var go = OkGo.get(url)
        if (map != null) {
            for (model in map) {
                go.params(model.key, model.value)
            }
        }
//        if (back_id > login) {
//            var token = Utils.getCache(sp.token)
//            if (!TextUtils.isEmpty(token)) {
//                go!!.params("Token",token.toString())//令牌
//            }
//            val df = SimpleDateFormat("yyyyMMddHHmmss")//设置日期格式
//            var TimeStamp = df.format(Date())// new Date()为
//            var md5 = Utils.getCache(sp.pwd)// 获取当前系统时间
//            var md51 = string2MD5(Utils.getCache(sp.pwd))
//            go!!.params("AccountId", Utils.getCache(sp.user_id))//账号id 密码先md5加密
//                    .params("AccountSecret", Sha1.encode(string2MD5(Utils.getCache(sp.pwd)).toUpperCase() + "_" + TimeStamp).toUpperCase())
//                    .params("TimeStamp", TimeStamp)
//        }
        go.execute(object : NewStringCallBack() {
            override fun onSuccess(str: String, call: okhttp3.Call?, response: okhttp3.Response?) {
                var t = Gson().fromJson(str, LzyResponse::class.java)
                if (true) {
                    try {
                        //t.Data as LinkedTreeMap<String, String>
                        var em = JsonParser().parse(str).asJsonObject.get("data").asJsonObject
                        control.callback(back_id, NormalRequest(t.code, t.msg, em))
                    } catch (e: Exception) {
                        try {
                            var em = JsonParser().parse(str).asJsonObject.get("data").asJsonArray
                            control.callback(back_id, NormalRequest(t.code, t.msg, em))
                        } catch (e: Exception) {
                            var em = JsonParser().parse(str).asJsonObject.get("data").asString
                            control.callback(back_id, NormalRequest(t.code, t.msg, em))
                        }
                    }
                } else {
                    var em = JsonParser().parse(str).asJsonObject.get("data")
                    control.callback(back_id, NormalRequest(t.code, t?.msg, em))
                }

            }

            override fun onError(call: Call?, response: Response?, e: Exception?) {
                control.callback(back_id, NormalRequest<T>(2, "未知错误：" + e.toString(), null))
            }
        })
    }
}