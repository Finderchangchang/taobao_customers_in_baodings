package gy.myproject.view.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gy.myproject.R;
import gy.myproject.base.BaseActivity;
import gy.myproject.databinding.ActivityRegisterPswBinding;
//注册设置密码
public class RegisterPswActivity extends BaseActivity<ActivityRegisterPswBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_register_psw;
    }
}
