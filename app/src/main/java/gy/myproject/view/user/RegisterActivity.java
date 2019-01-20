package gy.myproject.view.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gy.myproject.R;
import gy.myproject.base.BaseActivity;
import gy.myproject.databinding.ActivityRegisterBinding;
//注册
public class RegisterActivity extends BaseActivity<ActivityRegisterBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_register;
    }
}
