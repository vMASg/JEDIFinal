package com.example.victor.jedifinal.data;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.victor.jedifinal.Injector;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
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

    @Mock
    private User mockUser;

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
        when(mockCursor.getColumnIndex("prof_pic_locat")).thenReturn(2);
        when(mockCursor.getString(0)).thenReturn("pepe");
        when(mockCursor.getString(1)).thenReturn("#hashedPassword");
        when(mockCursor.isNull(2)).thenReturn(true);
        when(mockEndPoint.fetchUser("pepe")).thenReturn(mockCursor);
        User user = servImp.findUser("pepe");
        assertNotNull(user);
        assertEquals("pepe", user.getUserName());
        assertEquals("#hashedPassword", user.getHashedPassword());
    }

    @Test
    public void userWithProfilePictureCallsSetProfPic() {
        when(mockCursor.moveToFirst()).thenReturn(true);
        when(mockCursor.getColumnIndex("username")).thenReturn(0);
        when(mockCursor.getColumnIndex("password")).thenReturn(1);
        when(mockCursor.getColumnIndex("prof_pic_locat")).thenReturn(2);
        when(mockCursor.getString(0)).thenReturn("pepe");
        when(mockCursor.getString(1)).thenReturn("#hashedPassword");
        when(mockCursor.getString(2)).thenReturn("profilePictureLoc");
        when(mockCursor.isNull(2)).thenReturn(false);
        when(mockEndPoint.fetchUser("pepe")).thenReturn(mockCursor);
        User user = servImp.findUser("pepe");
        assertEquals("profilePictureLoc", user.getUserProfilePictureLocation());
    }

    @Test
    public void userWithProfilePictureNotCallsSetProfPic() {
        when(mockCursor.moveToFirst()).thenReturn(true);
        when(mockCursor.getColumnIndex("username")).thenReturn(0);
        when(mockCursor.getColumnIndex("password")).thenReturn(1);
        when(mockCursor.getColumnIndex("prof_pic_locat")).thenReturn(2);
        when(mockCursor.getString(0)).thenReturn("pepe");
        when(mockCursor.getString(1)).thenReturn("#hashedPassword");
        when(mockCursor.getString(2)).thenReturn("profilePictureLoc");
        when(mockCursor.isNull(2)).thenReturn(true);
        when(mockEndPoint.fetchUser("pepe")).thenReturn(mockCursor);
        User user = servImp.findUser("pepe");
        assertNull(user.getUserProfilePictureLocation());
    }

    @Captor
    private ArgumentCaptor<ContentValues> contentValuesArgumentCaptor;

    @Ignore("put method in ContentView not mocked")
    @Test
    public void createUserCalls() {
        when(mockUser.getUserName()).thenReturn("pepe");
        when(mockUser.getHashedPassword()).thenReturn("#hashedPassword");
        servImp.createUser(mockUser);
        verify(mockEndPoint).createUser(contentValuesArgumentCaptor.capture());
        ContentValues cv = contentValuesArgumentCaptor.getValue();
        assertEquals("pepe", cv.getAsString("username"));
        assertEquals("#hashedPassword", cv.getAsString("password"));
    }
}