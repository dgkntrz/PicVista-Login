package com.dokanreviews.Login.service;

import com.dokanreviews.Login.exceptions.GenericException;
import com.dokanreviews.Login.exceptions.UsernameAlreadyExistsException;
import com.dokanreviews.Login.model.User;
import com.dokanreviews.Login.model.UserDTO;
import com.dokanreviews.Login.repository.UserRepository;
import com.dokanreviews.Login.utils.Constants;
import com.dokanreviews.Login.utils.UserMapper;
import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String createAccount(UserDTO userDTO) throws GenericException {
        User user = userMapper.mapDtoToUser(userDTO, passwordEncoder);
        try{
            return userRepository.save(user).getUserId();
        } catch (DuplicateKeyException ex){
            throw new UsernameAlreadyExistsException(Constants.USER_ALREADY_EXISTS);
        } catch (Exception ex) {
            throw new GenericException(ex.getMessage());
        }

    }

}
