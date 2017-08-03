package com.example.administrator.mvpdram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.file.attribute.UserPrincipal;

public class MainActivity extends AppCompatActivity implements LoginView {

    EditText username,password;
    LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new LoginPresenter(this); // 将View传到Presenter层
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    /**
     *  登录按钮点击事件
     * @param view
     */
    public void login(View view){
        presenter.login();
    }

    /**
     *  清除
     * @param view
     */
    public void clear(View view){
        presenter.clear();
    }



    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void clearUsername() {
        username.setText("");
    }

    @Override
    public void clearPassword() {
        password.setText("");
    }

    @Override
    public void toastString(String msg) {
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }
}
