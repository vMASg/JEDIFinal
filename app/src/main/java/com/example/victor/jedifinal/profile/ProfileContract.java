package com.example.victor.jedifinal.profile;

/**
 * Created by inlab on 03/02/2016.
 */
public interface ProfileContract {

    interface View {
        void showUserName(String username);

        void showUserProfileImage(String imagePath);

        void showDefaultProfileImage();
    }

    interface Presenter {
        void setCurrentUser(String id);
    }
}
