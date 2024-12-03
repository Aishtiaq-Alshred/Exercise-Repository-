package com.example.usersmanagement.Controller;

import com.example.usersmanagement.Model.User;
import com.example.usersmanagement.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/User")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid@RequestBody User user , Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("user added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id ,@Valid@RequestBody User user , Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        userService.updateUser(id, user);
        return ResponseEntity.status(HttpStatus.OK).body("user updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id ){

        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("user deleted");
    }

    @GetMapping("/check/{username}/{password}")
    public ResponseEntity checkUsernameAndPassword(@PathVariable String username , @PathVariable String password){

        userService.checkUsernameAndPassword(username, password);
        return ResponseEntity.status(HttpStatus.OK).body("correct username and password");
    }
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){


        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByEmail(email));
    }
    @GetMapping("/getByRole/{role}")
    public ResponseEntity getUserByRole(@PathVariable String role){

        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByRole(role));
    }
    @GetMapping("/getByAge/{age}")
    public ResponseEntity getUserByAge(@PathVariable int age){

        return ResponseEntity.status(HttpStatus.OK).body(userService.getByAge(age));
    }







}
