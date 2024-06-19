package com.makershark.Assessment.sevice;

import com.makershark.Assessment.model.User;

public interface UserService {

    void registerUser(User user);
    User fetchUserByUsername(String username);
    User updateUser(User user,String username);
    void deleteUser(String username);

}
