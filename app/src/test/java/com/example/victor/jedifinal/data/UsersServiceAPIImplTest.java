package com.example.victor.jedifinal.data;

import android.database.Cursor;

import com.example.victor.jedifinal.Injector;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

/**
 * Created by Victor on 01/02/2016.
 */
public class UsersServiceAPIImplTest {

    private UsersServiceAPIImpl servImp;

    @Mock
    private UsersServiceAPIEndPoint mockEndPoint;

    @Mock
    private Cursor mockCursor;

    @Before
    public void setupUsersServiceAPIImpl() {
        MockitoAnnotations.initMocks(this);
        Injector.usersServiceAPIEndPoint = mockEndPoint;
        servImp = new UsersServiceAPIImpl();
    }

    @Test
    public void findNonExistentUsersReturnsNull() {
        when(mockCursor.moveToFirst()).thenReturn(false);
        when(mockEndPoint.fetchUser("pepe")).thenReturn(mockCursor);
        assertNull(servImp.findUser("pepe"));
    }

    @Test
    public void findExistentUserReturnsUser() {
        when(mockCursor.moveToFirst()).thenReturn(true);
        when(mockCursor.getColumnIndex("username")).thenReturn(0);
        when(mockCursor.getColumnIndex("password")).thenReturn(1);
        when(mockCursor.getString(0)).thenReturn("pepe");
        when(mockCursor.getString(1)).thenReturn("#hashedPassword");
        when(mockEndPoint.fetchUser("pepe")).thenReturn(mockCursor);
        User user = servImp.findUser("pepe");
        assertNotNull(user);
        assertEquals("pepe", user.getUserName());
        assertEquals("#hashedPassword", user.getHashedPassword());
    }
}