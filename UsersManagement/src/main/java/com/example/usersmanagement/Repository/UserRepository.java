package com.example.usersmanagement.Repository;

import com.example.usersmanagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository <User,Integer> {



    User findUserById(Integer id);
    @Query("select u from User u where u.username=?1 and u.password=?2")
    User UserByUsernameAndPassword(String username,String password);

    @Query("select u from User u where u.email=?1")
    User userByEmail(String email);
    @Query("select u from User u where u.role=?1")
    List<User> userByRole(String role);
    List<User> findUserByAgeGreaterThanEqual(int age);

}
