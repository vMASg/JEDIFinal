package com.example.victor.jedifinal.data;

/**
 * Created by inlab on 01/02/2016.
 */
public interface UsersServiceAPI {

    User findUser(String username);

    void createUser(User user);

    void saveUser(User user);

    void deleteUser(String username);
}
