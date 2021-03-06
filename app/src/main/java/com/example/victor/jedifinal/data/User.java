package com.example.victor.jedifinal.data;

import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * Created by inlab on 01/02/2016.
 */
public class User {

    private String userName;
    private String hashedPassw;
    private String userProfilePictureLocation;
    private String hometown;
    private int birthdayDay;
    private int birthdayMonth;
    private int birthdayYear;

    public User(String userName) {
        this.userName = userName;
        this.hashedPassw = "";
        this.userProfilePictureLocation = null;
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

    public String getUserProfilePictureLocation() {
        return userProfilePictureLocation;
    }

    public void setUserProfilePictureLocation(String userProfilePictureLocation) {
        this.userProfilePictureLocation = userProfilePictureLocation;
    }

    public String getHometown() {
        return hometown;
    }

    public int getBirthdayDay() {
        return birthdayDay;
    }

    public int getBirthdayMonth() {
        return birthdayMonth;
    }

    public int getBirthdayYear() {
        return birthdayYear;
    }

    public void setBirthdayDay(int birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public void setBirthdayMonth(int birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    public void setBirthdayYear(int birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    public void setHometown(String hometown) {
        if (hometown.length() == 0) {
            this.hometown = null;
        } else {
            this.hometown = hometown;
        }
    }
}
