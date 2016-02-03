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
        this.currentUser = usersServiceAPI.findUser(id);
        view.showUserName(this.currentUser.getUserName());
        String profileLocation = this.currentUser.getUserProfilePictureLocation();
        if (profileLocation == null) {
            view.showDefaultProfileImage();
        } else {
            view.showUserProfileImage(profileLocation);
        }
    }
}
