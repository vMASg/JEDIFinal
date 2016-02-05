package com.example.victor.jedifinal;

import android.content.Context;

import com.example.victor.jedifinal.data.UsersServiceAPI;
import com.example.victor.jedifinal.data.UsersServiceAPIEndPoint;
import com.example.victor.jedifinal.data.UsersServiceAPIImpl;
import com.example.victor.jedifinal.login.LoginContract;
import com.example.victor.jedifinal.login.LoginPresenter;
import com.example.victor.jedifinal.login.RegisterContract;
import com.example.victor.jedifinal.profile.ProfileActivity;
import com.example.victor.jedifinal.profile.ProfileContract;
import com.example.victor.jedifinal.profile.ProfilePresenter;

/**
 * Created by inlab on 01/02/2016.
 */
public class Injector {

    public static Context context;

    public static UsersServiceAPI getUsersServiceAPI() {
        return new UsersServiceAPIImpl();
    }

    public static LoginContract.Presenter getLoginPresenter(LoginContract.View view) {
        return new LoginPresenter(view);
    }

    public static RegisterContract.Presenter getRegisterPresenter(RegisterContract.View view) {
        return new LoginPresenter(view);
    }

    public static UsersServiceAPIEndPoint getUsersServiceAPIEndPoint() {
        return new UsersServiceAPIEndPoint(context);
    }

    public static ProfileContract.Presenter getProfilePresenter(ProfileContract.View view) {
        return new ProfilePresenter(view);
    }

    public static Class<?> getHomeScreenActivity() {
        return ProfileActivity.class;
    }

    public static Class<?> getEditProfileActivity() {
//        TODO: implement method
        return null;
    }
}
