package com.example.victor.jedifinal;

import com.example.victor.jedifinal.data.UsersServiceAPI;
import com.example.victor.jedifinal.data.UsersServiceAPIEndPoint;
import com.example.victor.jedifinal.data.UsersServiceAPIImpl;
import com.example.victor.jedifinal.login.LoginContract;
import com.example.victor.jedifinal.login.LoginPresenter;
import com.example.victor.jedifinal.login.RegisterContract;

/**
 * Created by inlab on 01/02/2016.
 */
public class Injector {

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
        return new UsersServiceAPIEndPoint();
    }
}
