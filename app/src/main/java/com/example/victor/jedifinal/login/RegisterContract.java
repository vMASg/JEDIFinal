package com.example.victor.jedifinal.login;

/**
 * Created by Victor on 01/02/2016.
 */
public interface RegisterContract {

    interface View {

        void displayUserExists();

        void displaySuccessful();

        void navigateHome(String username);

    }

    interface Presenter {

        void registerUser(String username, String password);
    }
}
