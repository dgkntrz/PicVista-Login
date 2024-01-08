package com.picvista.Login.controller;

import com.picvista.Login.exceptions.GenericException;
import com.picvista.Login.model.UserDTO;
import com.picvista.Login.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody UserDTO userDTO) throws GenericException {
        String userId = signUpService.createAccount(userDTO);
        return ResponseEntity.ok(userId);
    }

}
