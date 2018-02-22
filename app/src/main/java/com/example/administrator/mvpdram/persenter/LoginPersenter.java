package com.example.administrator.mvpdram.persenter;

import com.example.administrator.mvpdram.model.IUser;
import com.example.administrator.mvpdram.model.UserBean;
import com.example.administrator.mvpdram.model.UserModel;
import com.example.administrator.mvpdram.view.LoginView;

/**
 * Created by user on 2018/2/22.
 */

public class LoginPersenter {

    LoginView loginView;
    IUser iUser;


    public LoginPersenter(LoginView loginView) {
        this.loginView = loginView;
        iUser = new UserModel(loginView.getContext());
    }

    public void getUser(){
        UserBean userBean = iUser.getUser();

        if (userBean != null){
            loginView.setPassword(userBean.getPwd());
            loginView.setUserName(userBean.getUsername());
        }
    }

    public void login(){
        String userName = loginView.getUserName();
        String password = loginView.getPassword();

        if (userName.isEmpty()){
            loginView.toast("用户名不能为空");
            return;
        }
        if (password.isEmpty()){
            loginView.toast("密码不能为空");
            return;
        }

        UserBean userBean = new UserBean();
        userBean.setUsername(userName);
        userBean.setPwd(password);

        String resulse = iUser.login(userBean);

        if (resulse.isEmpty()){
            loginView.toast("登陆失败");
        }else {
            iUser.saveUser(userBean);
            loginView.toast(resulse);
        }

    }



}
