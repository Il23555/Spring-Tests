package com.example.sweater.controller;

import com.example.sweater.domain.User;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class RegistrationControllerTest {

    @Autowired
    RegistrationController registrationController;

    Map<String,Object> model = new HashMap<>();

    @Test
    void addUser() {
        User user1 = new User();
        user1.setUsername("ilyuza");
        user1.setPassword("12345");
        registrationController.addUser(user1, model);
        Assert.assertEquals("User exists!", model.get("message"));

        User user2 = new User();
        user2.setUsername("Zhenya");
        user2.setPassword("u8956789");
        Assert.assertEquals("redirect:/login", registrationController.addUser(user2, model));

        Assert.assertEquals("registration", registrationController.addUser(user2, model));
    }

    @Test
    void isValidPassword() {
        RegistrationController registrationController = new RegistrationController();
        Assert.assertFalse(registrationController.isValidPassword("abc"));
        Assert.assertTrue(registrationController.isValidPassword("aaaabbbcc"));
    }


    @Test
    void isValidLogin() {
        RegistrationController registrationController = new RegistrationController();
        Assert.assertFalse(registrationController.isValidLogin("12"));
        Assert.assertTrue(registrationController.isValidLogin("John"));
    }
}