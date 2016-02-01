package com.example.victor.jedifinal.login;

import com.example.victor.jedifinal.Injector;
import com.example.victor.jedifinal.data.User;
import com.example.victor.jedifinal.data.UsersServiceAPI;
import com.example.victor.jedifinal.data.UsersServiceAPIImpl;
import com.example.victor.jedifinal.login.LoginContract;
import com.example.victor.jedifinal.login.LoginPresenter;

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
 * Created by Victor on 31/01/2016.
 */
//  https://codelabs.developers.google.com/codelabs/android-testing/#5
public class LoginPresenterTest {

    @Mock
    private UsersServiceAPI usersServiceAPI;

    @Mock
    private LoginContract.View loginView;

    private LoginPresenter mLoginPresenter;

    @Before
    public void setupLoginPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        Injector.setUsersServiceAPI(usersServiceAPI);
        mLoginPresenter = new LoginPresenter(loginView);
    }

    @Test
    public void loginPresenterFetchesRightUser() {
        mLoginPresenter.logUserIn("user@somewhere.com", "password");
        verify(usersServiceAPI).findUser("user@somewhere.com");
    }

    @Test
    public void loginPresenterCallsBadEmailIfUsersDoesNotExist() {
        when(usersServiceAPI.findUser("user@somewhere.com")).thenReturn(null);
        mLoginPresenter.logUserIn("user@somewhere.com", "password");
        verify(loginView).displayBadEmail();
    }

    @Mock
    private User mockedUser;

    @Test
    public void loginPresenterCallsBadPasswordIfPasswordDoesNotMatch() {
        when(mockedUser.checkPassword("password")).thenReturn(false);
        when(usersServiceAPI.findUser("user@somewhere.com")).thenReturn(mockedUser);
        mLoginPresenter.logUserIn("user@somewhere.com", "password");
        verify(loginView).displayBadPassword();
    }

    @Test
    public void loginPresenterCallsNavigateHomeOnSuccessfulLogin() {
        when(mockedUser.checkPassword("password")).thenReturn(true);
        when(usersServiceAPI.findUser("user@somewhere.com")).thenReturn(mockedUser);
        mLoginPresenter.logUserIn("user@somewhere.com", "password");
        verify(loginView).navigateHome();
    }
}