package gy.myproject.view;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arialyy.frame.module.AbsModule;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gy.myproject.R;
import gy.myproject.base.BaseActivity;
import gy.myproject.control.LoginModule;
import gy.myproject.databinding.ActivityLoginBinding;
import gy.myproject.view.user.EditPasswordActivity;
import gy.myproject.view.user.RegisterActivity;

//登录
public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements AbsModule.OnCallback {


    LoginModule module;

    @BindView(R.id.login_psw)
    EditText loginPsw;
    @BindView(R.id.goregister)
    TextView goregister;
    @BindView(R.id.gopassword)
    TextView gopassword;
    @BindView(R.id.login_go)
    Button loginGo;
    @BindView(R.id.login_name)
    EditText loginName;

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);

        module = getModule(LoginModule.class, this);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onSuccess(int result, Object success) {
        String s = "";
    }

    @Override
    public void onError(int result, Object error) {
        toast("网络异常");
    }

    @OnClick({R.id.goregister, R.id.gopassword, R.id.login_go})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.goregister:
                //跳转到注册
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.gopassword:
                //忘记密码
                Intent intent1 = new Intent(this, EditPasswordActivity.class);
                startActivity(intent1);
                break;
            case R.id.login_go://登录
                String name = loginName.getText().toString().trim();
                String pwd = loginPsw.getText().toString().trim();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
                    toast("账号或密码错误，请重新输入");
                } else {
                    module.user_login(name, pwd);
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
