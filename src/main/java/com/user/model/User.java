package com.user.model;


import com.user.exception.DuplicateEmail;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "truong nay khong duoc de trong")
    @Size(min = 5, max = 45, message = "ten co do dai tu 5 den 45 ky tu")
    private String firstName;

    @Column(nullable = false)
    @NotEmpty(message = "truong nay khong duoc de trong")
    @Size(min = 5, max = 45, message = "ten co do dai tu 5 den 45 ky tu")
    private String lastName;

    @Pattern(regexp = "^0\\d{9,10}", message = "sai dinh dang phone")
    private String phone;

    @Min(18)
    private int age;

    @DuplicateEmail
    @NotEmpty
    private String email;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
