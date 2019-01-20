package gy.myproject.callback;

import com.google.gson.Gson;

import java.util.List;

import gy.myproject.callback.ListOfSomething;


/**
 * Created by Finder丶畅畅 on 2018/8/28 23:59
 * QQ群481606175
 */

public class NormalRequest<T> {
    int code = 0;//请求码0:请求成功。1：失败。2：报错
    T data = null;//是否解析成功
    String msg = "";//提示的消息
    //T obj= null;
    //boolean success = false;


    public NormalRequest(int code, String message, T obj) {
        this.code = code;
        //this.obj = obj;
        this.msg = message;
        this.data = obj;
//        this.success=success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public T getResult() {
        return data;
    }
    public T getResult(Class<T> mClass) {
        T userModel = new Gson().fromJson(data.toString(), mClass);
        return userModel;
    }
    public <T> List<T> getListResult(Class<T> mClass) {
        return new Gson().fromJson(data.toString(), new ListOfSomething<T>(mClass));
    }

    public void setResult(T result) {
        this.data = result;
    }

}
