package com.example.administrator.mvpdram.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;

import com.example.administrator.mvpdram.SPUtils;

import java.lang.ref.WeakReference;

/**
 * Created by user on 2018/2/22.
 */

public class UserModel implements IUser {

    WeakReference<Context> contextWeakReference;

    public UserModel(Context context) {
        contextWeakReference = new WeakReference<Context>(context);
    }


    @Override
    public void saveUser(UserBean userBean) {
        if (contextWeakReference != null) {
            SPUtils.put(contextWeakReference.get(), "userName", userBean.getUsername());
            SPUtils.put(contextWeakReference.get(), "password", userBean.getPwd());
        }
    }

    @Override
    public UserBean getUser() {

        if (contextWeakReference != null) {
            UserBean userBean = new UserBean();
            userBean.setPwd((String) SPUtils.get(contextWeakReference.get(), "password", ""));
            userBean.setUsername((String) SPUtils.get(contextWeakReference.get(), "userName", ""));
            return userBean;
        }
        return null;
    }

    @Override
    public String login(UserBean userBean) {
        // 模拟请求， 真实应用替换为网络请求
        if (userBean.getUsername().equals("18354232734") && userBean.getPwd().equals("123456")) {
            return "登陆成功";
        }
        return "";
    }
}
