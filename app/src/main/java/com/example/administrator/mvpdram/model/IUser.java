package com.example.administrator.mvpdram.model;

/**
 * Created by user on 2018/2/22.
 */

public interface IUser {
    void saveUser(UserBean userBean);
    UserBean getUser();
    String login(UserBean userBean);
}
