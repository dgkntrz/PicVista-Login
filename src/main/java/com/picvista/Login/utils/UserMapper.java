package com.picvista.Login.utils;

import com.picvista.Login.model.User;
import com.picvista.Login.model.UserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserMapper {

    public User mapDtoToUser(UserDTO userDTO, PasswordEncoder passwordEncoder){
        return new User(userDTO.getUserName(), passwordEncoder.encode(userDTO.getPassword()), LocalDateTime.now().toString(), userDTO.getEmail() );
    }
}
