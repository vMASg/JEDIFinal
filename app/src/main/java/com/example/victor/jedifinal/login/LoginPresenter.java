package com.example.victor.jedifinal.login;

/**
 * Created by Victor on 31/01/2016.
 */
public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void logUserIn(String email, String password) {
//        TODO: implement method
    }
}
