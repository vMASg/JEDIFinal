package com.example.victor.jedifinal.profile;

/**
 * Created by inlab on 03/02/2016.
 */
public interface ProfileContract {

    interface View {
        void showUserName(String username);

        void showUserProfileImage(String imagePath);

        void showDefaultProfileImage();

        void showHomeTown(String hometown);

        void showBirthday(int day, int month, int year);
    }

    interface Presenter {
        void setCurrentUser(String id);

        void setPassword(String password);

        void setHomeTown(String homeTown);

        void setBirthday(int day, int month, int year);

        void saveUserData();
    }
}
