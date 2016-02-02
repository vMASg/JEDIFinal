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
    public User findUser(String email) {
        Cursor c = endPoint.fetchUser(email);
        if (c.moveToFirst()) {
            User user = new User(c.getString(c.getColumnIndex("username")));
            user.setHashedPassword(c.getString(c.getColumnIndex("password")));
            return user;
        }
        return null;
    }

    @Override
    public void createUser(User user) {
        ContentValues cv = new ContentValues();
        cv.put("username", user.getUserName());
        cv.put("password", user.getHashedPassword());
        endPoint.createUser(cv);
    }

    @Override
    public void saveUser(User user) {
//        TODO: implement method
    }

    @Override
    public void deleteUser(String email) {
//        TODO: implement method
    }
}
