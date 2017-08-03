package com.example.administrator.mvpdram;

/**
 * Created by Administrator on 2017/8/3.
 */

public class LoginPresenter implements OnLoginListener {
    private LoginView loginView;
    private UserBizImpl usrBiz ; // 数据处理层

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        usrBiz = new UserBizImpl(this);
    }
    // 登录
    public void login(){
        UserBean userBean = new UserBean();
        userBean.setUsername(loginView.getUsername());
        userBean.setPwd(loginView.getPassword());
        usrBiz.login(userBean);
    }

    // 清除文字
    public void clear(){
        loginView.clearPassword();
        loginView.clearUsername();
    }

    // 登录成功回调
    @Override
    public void loginResponse(String response) {
        loginView.toastString(response);
    }
}

interface OnLoginListener{
    void loginResponse(String response);
}
