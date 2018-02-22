package com.example.administrator.mvpdram.view;


import android.content.Context;

/**
 * Created by Administrator on 2017/8/3.
 */

public interface  LoginView {
    String getUserName();
    String getPassword();
    void setUserName(String userName);
    void setPassword(String password);
    void clearUserName();
    void clearPassword();
    void toast(String msg);
    Context getContext();
}
