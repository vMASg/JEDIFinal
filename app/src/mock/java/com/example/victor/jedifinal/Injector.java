package com.example.victor.jedifinal;

import com.example.victor.jedifinal.data.UsersServiceAPI;

/**
 * Created by inlab on 01/02/2016.
 */
public class Injector {

    private static UsersServiceAPI usersServiceAPI;


    public static UsersServiceAPI getUsersServiceAPI() {
        return usersServiceAPI;
    }

    public static void setUsersServiceAPI(UsersServiceAPI usersServiceAPI) {
        Injector.usersServiceAPI = usersServiceAPI;
    }
}
