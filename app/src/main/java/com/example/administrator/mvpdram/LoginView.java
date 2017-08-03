package com.example.administrator.mvpdram;

/**
 * Created by Administrator on 2017/8/3.
 */

public interface  LoginView {
    public String getUsername();
    public String getPassword();
    public void clearUsername();
    public void clearPassword();
    public void toastString(String msg);
}
