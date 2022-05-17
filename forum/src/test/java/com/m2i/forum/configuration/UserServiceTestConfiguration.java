package com.m2i.forum.configuration;

import com.m2i.forum.models.User;
import com.m2i.forum.services.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class UserServiceTestConfiguration {

    @TestConfiguration
    static class UserServiceTestContextConfiguration {
        @Bean
        public UserService employeeService() {
            return new UserService() {
                @Override
                public Optional<User> findByUsername(String username) {
                    return Optional.empty();
                }

                @Override
                public boolean existsUsername(String username) {
                    return false;
                }

                @Override
                public Optional<User> findByEmail(String email) {
                    return Optional.empty();
                }

                @Override
                public boolean existsEmail(String email) {
                    return false;
                }

                @Override
                public void deleteById(Long id) {

                }

                @Override
                public void add(User entity) {

                }

                @Override
                public void save(User entity) {

                }

                @Override
                public User update(User entity) {
                    return null;
                }

                @Override
                public void delete(User entity) {

                }

                @Override
                public User findById(Long key) {
                    return null;
                }

                @Override
                public List<User> findAll() {
                    return null;
                }
            };
        }
    }
    @Autowired
    private UserService employeeService;
}
