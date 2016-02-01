package com.example.victor.jedifinal.login;

/**
 * Created by Victor on 31/01/2016.
 */
//  https://github.com/antoniolg/androidmvp/tree/master/app/src/main/java/com/antonioleiva/mvpexample/app/Login
public interface LoginContract {

    interface View {

        void displayBadEmail();

        void displayBadPassword();

        void navigateHome();

        void navigateRegistration();
    }

    interface Presenter {

        void logUserIn(String email, String password);
    }
}
