package com.picvista.Login.controller;

import com.picvista.Login.exceptions.UserNotValidException;
import com.picvista.Login.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update")
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    @PutMapping("/username")
    public ResponseEntity<String> updateUserName(@RequestParam String oldUserName, @RequestParam String newUserName) throws UserNotValidException {
        String userId = userManageService.updateUserName(oldUserName, newUserName);
        return ResponseEntity.ok(userId);
    }

    @PutMapping("/password")
    public ResponseEntity<String> updatePassword(@RequestParam String userName, @RequestParam String password) throws UserNotValidException {
        String userId = userManageService.updatePassword(userName, password);
        return ResponseEntity.ok(userId);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<String> deleteAccount(@PathVariable String userName) throws UserNotValidException {
        String userId = userManageService.deleteUser(userName);
        return ResponseEntity.ok(userId);
    }

}
