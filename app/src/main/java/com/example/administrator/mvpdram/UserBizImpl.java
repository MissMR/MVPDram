package com.example.administrator.mvpdram;

/**
 * Created by Administrator on 2017/8/3.
 */

public class UserBizImpl implements userBiz {
    private OnLoginListener listener;  //将处理结果回调给Presenter

    public UserBizImpl(OnLoginListener listener){
        this.listener = listener;
    }

    @Override
    public void login(UserBean userBean) {
            String username = userBean.getUsername();
            String pwd = userBean.getPwd();

        if (username.equals("逄涛帅不帅") && pwd.equals("帅")){
            String msg = userBean.getUsername()+":"+userBean.getPwd();
            listener.loginResponse(msg);
        }else {
            listener.loginResponse("用户名或密码错误");
        }

    }
}

interface userBiz{
    void login(UserBean userBean);
}


