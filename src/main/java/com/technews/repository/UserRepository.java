package com.technews.repository;

import com.technews.model.User;
// extend the JPARepository
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//repository can take User and the id (integer)
public interface UserRepository extends JpaRepository<User, Integer> {
    //Custom query method - find users by email
    User findUserByEmail(String email) throws Exception;

}