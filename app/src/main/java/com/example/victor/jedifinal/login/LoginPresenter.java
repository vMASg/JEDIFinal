package com.example.victor.jedifinal.login;

import com.example.victor.jedifinal.Injector;
import com.example.victor.jedifinal.data.User;
import com.example.victor.jedifinal.data.UsersServiceAPI;

/**
 * Created by Victor on 31/01/2016.
 */
public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View view;
    private final UsersServiceAPI usersServiceAPI;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.usersServiceAPI = Injector.getUsersServiceAPI();
    }

    @Override
    public void logUserIn(String email, String password) {
//        TODO: implement method
        User user = usersServiceAPI.findUser(email);
        if (user == null) {
            view.displayBadEmail();
        } else if (user.checkPassword(password)) {
            view.navigateHome();
        } else {
            view.displayBadPassword();
        }
    }
}
