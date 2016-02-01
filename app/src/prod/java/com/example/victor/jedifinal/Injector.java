package com.example.victor.jedifinal;

import com.example.victor.jedifinal.data.UsersServiceAPI;
import com.example.victor.jedifinal.data.UsersServiceAPIImpl;

/**
 * Created by inlab on 01/02/2016.
 */
public class Injector {

    public static UsersServiceAPI getUsersServiceAPI() {
        return new UsersServiceAPIImpl();
    }
}
