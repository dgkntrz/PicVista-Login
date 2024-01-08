package com.dokanreviews.Login.repository;

import com.dokanreviews.Login.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByUserNameEquals(String userName);
    User deleteUserByUserName(String userName);
}
