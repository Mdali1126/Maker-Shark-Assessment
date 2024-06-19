package com.makershark.Assessment.sevice;

import com.makershark.Assessment.exception.UserNotFoundException;
import com.makershark.Assessment.model.User;
import com.makershark.Assessment.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data

public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User fetchUserByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public User updateUser(User user, String userName) {
        try {
            User existingUser = userRepository.findByUsername(userName).orElseThrow();
            if (existingUser == null) {
                throw new UserNotFoundException(userName);
            }
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            userRepository.save(existingUser);
            return userRepository.findByUsername(userName).orElseThrow();
        } catch (UserNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public void deleteUser(String username) {
        User user = fetchUserByUsername(username);
        if (user == null) {
            throw new UserNotFoundException(username);
        } else {
            userRepository.deleteUserByUsername(username);
        }
    }
}
