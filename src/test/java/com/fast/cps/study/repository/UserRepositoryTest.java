package com.fast.cps.study.repository;


import com.fast.cps.study.FastcampusApplicationTests;
import com.fast.cps.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

public class UserRepositoryTest extends FastcampusApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create()
    {
        User user = new User();
        user.setAccount("account1");
        user.setEmail("email1");
        user.setPhoneNumber("010-1234-1234");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");
        User newUser =  userRepository.save(user);

        System.out.println(newUser.getId());
    }

    @Test
    public void read()
    {
        Long findId = 1L;
        userRepository
                    .findById(findId)
                    .ifPresent(selectedUser -> {
                        System.out.println(selectedUser.getEmail());
                        selectedUser.setEmail("최강창민");
                        userRepository.save(selectedUser);
                    });

        userRepository
                    .findById(findId)
                    .ifPresent(selectedUser -> {
                        System.out.println(selectedUser.getEmail());
                    });
    }
}
