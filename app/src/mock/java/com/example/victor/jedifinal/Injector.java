package com.example.victor.jedifinal;

import com.example.victor.jedifinal.data.UsersServiceAPI;
import com.example.victor.jedifinal.login.LoginContract;
import com.example.victor.jedifinal.login.RegisterContract;

/**
 * Created by inlab on 01/02/2016.
 */
public class Injector {

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
}
