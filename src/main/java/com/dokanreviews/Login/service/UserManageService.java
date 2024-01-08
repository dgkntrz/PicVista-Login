package com.dokanreviews.Login.service;

import com.dokanreviews.Login.exceptions.UserNotValidException;
import com.dokanreviews.Login.model.User;
import com.dokanreviews.Login.repository.UserRepository;
import com.dokanreviews.Login.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManageService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String updateUserName(String oldUserName, String newUserName) throws UserNotValidException {
        User user = userRepository.findUserByUserNameEquals(oldUserName);
        User existingUser = userRepository.findUserByUserNameEquals(newUserName);
        if (user == null){
            throw new UserNotValidException(Constants.USER_NOT_FOUND);
        }
        if (existingUser != null){
            throw new UserNotValidException(Constants.USER_ALREADY_EXISTS);
        }
        user.setUserName(newUserName);
        userRepository.save(user);
        return user.getUserId();
    }

    public String updatePassword(String userName, String password) throws UserNotValidException {
        User user = userRepository.findUserByUserNameEquals(userName);
        if (user == null){
            throw new UserNotValidException(Constants.USER_NOT_FOUND);
        }
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return user.getUserId();
    }

    public String deleteUser(String userName) throws UserNotValidException {
        User user = userRepository.deleteUserByUserName(userName);
        if (user == null){
            throw new UserNotValidException(Constants.USER_NOT_FOUND);
        }
        return user.getUserId();
    }

}
