package com.example.victor.jedifinal.profile;

import com.example.victor.jedifinal.Injector;
import com.example.victor.jedifinal.data.User;
import com.example.victor.jedifinal.data.UsersServiceAPI;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
/**
 * Created by inlab on 03/02/2016.
 */
public class ProfilePresenterTest {

    @Mock
    private UsersServiceAPI usersServiceAPI;

    @Mock
    private ProfileContract.View profileView;

    @Mock
    private User mockUser;

    private ProfilePresenter mProfilePresenter;

    @Before
    public void setupProfilePresenter() {
        MockitoAnnotations.initMocks(this);

        Injector.usersServiceAPI = usersServiceAPI;
        mProfilePresenter = new ProfilePresenter(profileView);
    }
    
    @Test
    public void setCurrentUserUpdatesViewInformation() {
        when(mockUser.getUserName()).thenReturn("username");
        when(mockUser.getUserProfilePictureLocation()).thenReturn("location");
        when(usersServiceAPI.findUser("userid")).thenReturn(mockUser);
        mProfilePresenter.setCurrentUser("userid");
        verify(profileView).showUserName("username");
        verify(profileView).showUserProfileImage("location");
    }

    @Test
    public void setCurrentUserWithoutProfilePictureCallsShowDefaultProfileImage() {
        when(mockUser.getUserName()).thenReturn("username");
        when(mockUser.getUserProfilePictureLocation()).thenReturn(null);
        when(usersServiceAPI.findUser("userid")).thenReturn(mockUser);
        mProfilePresenter.setCurrentUser("userid");
//        verify(profileView).showUserName("username");
        verify(profileView).showDefaultProfileImage();
    }
}