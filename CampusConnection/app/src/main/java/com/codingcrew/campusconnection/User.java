package com.codingcrew.campusconnection;

import java.util.List;

/**
 * Created by Saul on 9/25/2016.
 */

public class User {
    private static User sUserClass;

    private String mUsername;
    private String mPassword;

    public static User getInstance() {
        if(sUserClass == null) {
            sUserClass = new User();

        }

        return sUserClass;
    }
    private User(){
        mPassword = "";
        mUsername = "";
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
