package gy.myproject.control;

import android.content.Context;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

import gy.myproject.base.BaseModule;
import gy.myproject.config.HttpUtils;
import gy.myproject.config.MyUrl;

/**
 * Created by Finder丶畅畅 on 2019/1/19 17:35
 * QQ群481606175
 */
//登录
public class LoginModule extends BaseModule {

    public LoginModule(@Nullable Context context) {
        super(context);
    }
    public void user_login(String name, String code) {
        HashMap<String, String> map = new HashMap<>();
        map.put("user", name);
        map.put("pwd", "");
        new HttpUtils().post(MyUrl.login, 1001, map, this);
    }
}
