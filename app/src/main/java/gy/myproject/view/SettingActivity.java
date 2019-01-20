package gy.myproject.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gy.myproject.R;
import gy.myproject.base.BaseActivity;
//设置
public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_setting;
    }
}
