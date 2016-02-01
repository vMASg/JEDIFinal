package com.example.victor.jedifinal.data;

import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * Created by inlab on 01/02/2016.
 */
public class User {

    private String userName;
    private String hashedPassw;

    public User(String userName) {
        this.userName = userName;
        this.hashedPassw = "";
    }

    public void setPassword(String password) {
//        TODO: use salt?
        hashedPassw = Hashing.sha1().hashString(password, Charset.defaultCharset()).toString();
    }

    public void setHashedPassword(String hashedPassw) {
        this.hashedPassw = hashedPassw;
    }

    public String getHashedPassword() {
        return hashedPassw;
    }

    public String getUserName() {
        return userName;
    }

    public boolean checkPassword(String password) {
        return Hashing.sha1().hashString(password, Charset.defaultCharset()).toString().equals(hashedPassw);
    }
}
