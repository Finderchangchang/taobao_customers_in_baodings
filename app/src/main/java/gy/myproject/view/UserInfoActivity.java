package gy.myproject.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gy.myproject.R;
import gy.myproject.base.BaseActivity;
import gy.myproject.databinding.ActivityLoginBinding;
import gy.myproject.databinding.ActivityUserInfoBinding;


public class UserInfoActivity extends BaseActivity<ActivityUserInfoBinding> {
    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_user_info;
    }
}
