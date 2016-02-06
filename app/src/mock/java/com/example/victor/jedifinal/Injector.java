package com.example.victor.jedifinal;

import android.content.Context;

import com.example.victor.jedifinal.data.UsersServiceAPI;
import com.example.victor.jedifinal.data.UsersServiceAPIEndPoint;
import com.example.victor.jedifinal.login.LoginContract;
import com.example.victor.jedifinal.login.RegisterContract;
import com.example.victor.jedifinal.profile.ProfileActivity;
import com.example.victor.jedifinal.profile.ProfileContract;

import java.lang.Class;

/**
 * Created by inlab on 01/02/2016.
 */
public class Injector {

    public static Context context;

    public static UsersServiceAPI usersServiceAPI;
    public static UsersServiceAPI getUsersServiceAPI() {
        return usersServiceAPI;
    }

    public static LoginContract.Presenter loginPresenter;
    public static LoginContract.Presenter getLoginPresenter(LoginContract.View view) {
        return loginPresenter;
    }

    public static RegisterContract.Presenter registerPresenter;
    public static RegisterContract.Presenter getRegisterPresenter(RegisterContract.View view) {
        return registerPresenter;
    }

    public static UsersServiceAPIEndPoint usersServiceAPIEndPoint;
    public static UsersServiceAPIEndPoint getUsersServiceAPIEndPoint() {
        return usersServiceAPIEndPoint;
    }

    public static ProfileContract.Presenter profilePresenter;
    public static ProfileContract.Presenter getProfilePresenter(ProfileContract.View view) {
        return profilePresenter;
    }

    public static Class<?> profileActivity;
    public static Class<?> getProfileActivity() {
        return profileActivity;
    }

}
