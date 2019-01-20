package gy.myproject.callback;

import android.app.Application;
import android.content.Intent;

import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.convert.StringConvert;

import gy.myproject.config.Utils;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Finder丶畅畅 on 2018/12/21 21:18
 * QQ群481606175
 */
public abstract class NewStringCallBack extends AbsCallback<String> {
    @Override
    public String convertSuccess(Response response) throws Exception {
        String s = StringConvert.create().convertSuccess(response);
        if(s.contains("2002")||s.contains("1001")){
            new Utils().putCache("token","");
        }
        response.close();
        return s;
    }
}