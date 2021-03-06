package com.example.victor.jedifinal.data;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.victor.jedifinal.Injector;

/**
 * Created by inlab on 01/02/2016.
 */
public class UsersServiceAPIImpl implements UsersServiceAPI {

    private UsersServiceAPIEndPoint endPoint;

    public UsersServiceAPIImpl() {
        endPoint = Injector.getUsersServiceAPIEndPoint();
    }

    @Override
    public User findUser(String username) {
        Cursor c = endPoint.fetchUser(username);
        if (c.moveToFirst()) {
            User user = new User(c.getString(c.getColumnIndex("username")));
            user.setHashedPassword(c.getString(c.getColumnIndex("password")));
            if (!c.isNull(c.getColumnIndex("prof_pic_locat"))) {
                user.setUserProfilePictureLocation(c.getString(c.getColumnIndex("prof_pic_locat")));
            }
            user.setBirthdayDay(c.getInt(c.getColumnIndex("birthday_day")));
            user.setBirthdayMonth(c.getInt(c.getColumnIndex("birthday_month")));
            user.setBirthdayYear(c.getInt(c.getColumnIndex("birthday_year")));
            user.setHometown(c.getString(c.getColumnIndex("hometown")));
            return user;
        }
        return null;
    }

    @Override
    public void createUser(User user) {
        ContentValues cv = new ContentValues();
        cv.put("username", user.getUserName());
        cv.put("password", user.getHashedPassword());
        String userProfilePictureLocation = user.getUserProfilePictureLocation();
        if (userProfilePictureLocation != null) {
            cv.put("prof_pic_locat", userProfilePictureLocation);
        }
        endPoint.createUser(cv);
    }

    @Override
    public void saveUser(User user) {
        ContentValues cv = new ContentValues();
        cv.put("password", user.getHashedPassword());

        String userProfilePictureLocation = user.getUserProfilePictureLocation();
        String hometown = user.getHometown();
        int birthdayDay = user.getBirthdayDay();
        int birthdayMonth = user.getBirthdayMonth();
        int birthdayYear = user.getBirthdayYear();
        if (userProfilePictureLocation != null) {
            cv.put("profile_pic_locat", userProfilePictureLocation);
        }
        if (hometown != null) {
            cv.put("hometown", hometown);
        }
        if (birthdayDay > 0) {
            cv.put("birthday_day", birthdayDay);
        }
        if (birthdayMonth > 0) {
            cv.put("birthday_month", birthdayMonth);
        }
        if (birthdayYear > 0) {
            cv.put("birthday_year", birthdayYear);
        }
        endPoint.updateUser(user.getUserName(), cv);
    }

    @Override
    public void deleteUser(String username) {
//        TODO: implement method
    }
}
