package com.example.administrator.mvpdram;

/**
 * Created by Administrator on 2017/8/3.
 */

public class LoginPresenter implements OnLoginListener {
    private LoginView loginView;
    private UserBizImpl usrBiz ;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        usrBiz = new UserBizImpl(this);
    }

    public void login(){
        UserBean userBean = new UserBean();
        userBean.setUsername(loginView.getUsername());
        userBean.setPwd(loginView.getPassword());
        usrBiz.login(userBean);
    }

    public void clear(){
        loginView.clearPassword();
        loginView.clearUsername();
    }


    @Override
    public void loginResponse(String response) {
        loginView.toastString(response);
    }
}

interface OnLoginListener{
    void loginResponse(String response);
}
