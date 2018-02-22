package com.example.administrator.mvpdram;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mvpdram.persenter.LoginPersenter;
import com.example.administrator.mvpdram.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    EditText username,password;
    LoginPersenter loginPersenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginPersenter = new LoginPersenter(this);

        loginPersenter.getUser();
    }
    /**
     *  登录按钮点击事件
     * @param view
     */
    public void login(View view){
        loginPersenter.login();
    }

    /**
     *  清除
     * @param view
     */
    public void clear(View view){
        clearUserName();
        clearPassword();
    }

    @Override
    public String getUserName() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }


    @Override
    public void setUserName(String userName) {
        username.setText(userName);
    }

    @Override
    public void setPassword(String password) {
        this.password.setText(password);
    }

    @Override
    public void clearUserName() {
        username.setText("");
    }

    @Override
    public void clearPassword() {
        password.setText("");
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
