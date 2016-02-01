package com.example.victor.jedifinal.login;

import com.example.victor.jedifinal.Injector;
import com.example.victor.jedifinal.data.User;
import com.example.victor.jedifinal.data.UsersServiceAPI;

/**
 * Created by Victor on 31/01/2016.
 */
public class LoginPresenter implements LoginContract.Presenter, RegisterContract.Presenter {

    private final LoginContract.View logView;
    private final RegisterContract.View regView;
    private final UsersServiceAPI usersServiceAPI;

    public LoginPresenter(LoginContract.View logView) {
        this.logView = logView;
        this.regView = null;
        this.usersServiceAPI = Injector.getUsersServiceAPI();
    }

    public LoginPresenter(RegisterContract.View regView) {
        this.logView = null;
        this.regView = regView;
        this.usersServiceAPI = Injector.getUsersServiceAPI();
    }

    @Override
    public void logUserIn(String email, String password) {
        User user = usersServiceAPI.findUser(email);
        if (user == null) {
            logView.displayBadEmail();
        } else if (user.checkPassword(password)) {
            logView.navigateHome(email);
        } else {
            logView.displayBadPassword();
        }
    }

    @Override
    public void registerUser(String email, String password) {
        if (usersServiceAPI.findUser(email) == null) {
            User user = new User(email);
            user.setPassword(password);
            usersServiceAPI.createUser(user);
            regView.displaySuccessful();
            regView.navigateHome(email);
        } else {
            regView.displayUserExists();
        }
    }
}
