package gy.myproject.view.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gy.myproject.R;
import gy.myproject.base.BaseActivity;
//修改密码
public class EditPasswordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_edit_password;
    }
}
