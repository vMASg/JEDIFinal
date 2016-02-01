package com.example.victor.jedifinal.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Victor on 01/02/2016.
 */
public class UserTest {

    private User user;

    @Before
    public void setupUser() {
        user = new User("pepito");
    }

    @Test
    public void getUserNameReturnsUserName() {
        assertEquals("pepito", user.getUserName());
    }

    @Test
    public void compareSamePassword() {
        user.setPassword("longAndHardToGuessPasswordXxx");
        assertTrue(user.checkPassword("longAndHardToGuessPasswordXxx"));
    }

    @Test
    public void compareDifferentPasswords() {
        user.setPassword("longAndHardToGuessPasswordXxx");
        assertFalse(user.checkPassword("differentPassword"));
    }

}