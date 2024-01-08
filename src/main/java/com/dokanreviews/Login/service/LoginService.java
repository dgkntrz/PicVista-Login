package com.dokanreviews.Login.service;

import com.dokanreviews.Login.exceptions.PasswordNotValidException;
import com.dokanreviews.Login.exceptions.UserNotValidException;
import com.dokanreviews.Login.model.User;
import com.dokanreviews.Login.model.UserDTO;
import com.dokanreviews.Login.repository.UserRepository;
import com.dokanreviews.Login.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User logIn(UserDTO userDTO) throws PasswordNotValidException, UserNotValidException {
        User user = userRepository.findUserByUserNameEquals(userDTO.getUserName());
        if (user == null){
            throw new UserNotValidException(Constants.USER_NOT_FOUND);
        }
        if (!passwordMatcher(userDTO.getPassword(), user.getPassword())){
            throw new PasswordNotValidException(Constants.WRONG_PASSWORD);
        }
        return user;
    }

    private boolean passwordMatcher(String password, String encryptedPassword){
        return passwordEncoder.matches(password, encryptedPassword);
    }

}
