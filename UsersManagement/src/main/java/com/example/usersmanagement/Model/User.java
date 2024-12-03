package com.example.usersmanagement.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be null")
    @Size(min = 4 , message = "name should be more than 4 letters")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "username should not be empty")
    @Size(min = 4,message = "username should be more than 4")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String username;

    @NotEmpty(message = "password should not be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String password;

    @NotEmpty(message = "email should not be empty")
    @Email(message = "should be valid email")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotEmpty(message = "role cannot be null")
    @Pattern(regexp = "(user|admin)",message = "role must be user or admin")
    @Column(columnDefinition = "varchar(5) not null check(role='user' or role='admin')")
    private String role;
    @NotNull(message = "age cannot be null")
    @Positive(message = "age must be integer")
    @Column(columnDefinition = "int not null check(age>0)")
    private int age;

}


