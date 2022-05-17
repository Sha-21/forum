package com.m2i.forum.service.impl;

import com.m2i.forum.configuration.UserServiceTestConfiguration;
import com.m2i.forum.services.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Import(UserServiceTestConfiguration.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    public UserServiceTest(UserService userService) {
        this.userService = userService;
    }
}
