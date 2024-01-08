package com.picvista.Login.service;

import com.picvista.Login.exceptions.GenericException;
import com.picvista.Login.exceptions.UsernameAlreadyExistsException;
import com.picvista.Login.model.User;
import com.picvista.Login.model.UserDTO;
import com.picvista.Login.repository.UserRepository;
import com.picvista.Login.utils.Constants;
import com.picvista.Login.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
