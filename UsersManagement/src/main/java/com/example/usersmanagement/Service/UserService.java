package com.example.usersmanagement.Service;

import com.example.usersmanagement.ApiResponse.ApiException;
import com.example.usersmanagement.Model.User;
import com.example.usersmanagement.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUser (User user){

        userRepository.save(user);
    }

    public void updateUser(Integer id , User user){
        User user1 = userRepository.findUserById(id);
        if(user1==null){
            throw new ApiException("id not found");
        }

        user1.setAge(user.getAge());
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        user1.setRole(user.getRole());
        userRepository.save(user1);
    }



    public void deleteUser(Integer id ){

        User user = userRepository.findUserById(id);

        if(user==null){
            throw new ApiException("id not found");

        }

        userRepository.delete(user);
    }


    public void checkUsernameAndPassword(String username , String Password){

        User user = userRepository.UserByUsernameAndPassword(username, Password);
        if(user==null){
            throw new ApiException("wrong username and password");
        }

    }

    public User getUserByEmail(String email){
        User user = userRepository.userByEmail(email);

        if(user==null){
            throw new ApiException("email not found");
        }

        return user;

    }


    public List<User> getUserByRole(String role){

        if(userRepository.userByRole(role).isEmpty()){
            throw new ApiException("no user with this role");
        }

        return userRepository.userByRole(role);
    }

    public List<User> getByAge(int age){
        if (userRepository.findUserByAgeGreaterThanEqual(age).isEmpty()){
            throw new ApiException("no user equal or greater than this age");
        }

        return userRepository.findUserByAgeGreaterThanEqual(age);
    }





}
