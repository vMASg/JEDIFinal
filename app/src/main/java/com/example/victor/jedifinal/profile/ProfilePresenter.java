package com.example.victor.jedifinal.profile;

import com.example.victor.jedifinal.Injector;
import com.example.victor.jedifinal.data.User;
import com.example.victor.jedifinal.data.UsersServiceAPI;

/**
 * Created by inlab on 03/02/2016.
 */
public class ProfilePresenter implements ProfileContract.Presenter {

    private final ProfileContract.View view;
    private final UsersServiceAPI usersServiceAPI;
    private User currentUser;

    public ProfilePresenter(ProfileContract.View view) {
        this.view = view;
        this.usersServiceAPI = Injector.getUsersServiceAPI();
    }

    @Override
    public void setCurrentUser(String id) {
        currentUser = usersServiceAPI.findUser(id);
        view.showUserName(currentUser.getUserName());

        String profileLocation = currentUser.getUserProfilePictureLocation();
        String hometown = currentUser.getHometown();
        int birthdayDay = currentUser.getBirthdayDay();

        if (profileLocation == null) {
            view.showDefaultProfileImage();
        } else {
            view.showUserProfileImage(profileLocation);
        }

        if (hometown != null) {
            view.showHomeTown(hometown);
        }
        if (birthdayDay > 0) {
            view.showBirthday(
                    birthdayDay,
                    currentUser.getBirthdayMonth(),
                    currentUser.getBirthdayYear()
            );
        }
    }

    @Override
    public void setPassword(String password) {
        currentUser.setPassword(password);
    }

    @Override
    public void setHomeTown(String homeTown) {
        currentUser.setHometown(homeTown);
    }

    @Override
    public void setBirthday(int day, int month, int year) {
        currentUser.setBirthdayDay(day);
        currentUser.setBirthdayMonth(month);
        currentUser.setBirthdayYear(year);
    }

    @Override
    public void saveUserData() {
//        TODO: capture possible errors
        usersServiceAPI.saveUser(currentUser);
    }
}
