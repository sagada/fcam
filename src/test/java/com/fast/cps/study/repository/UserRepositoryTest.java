package com.fast.cps.study.repository;

import com.fast.cps.study.FastcampusApplicationTests;
import com.fast.cps.study.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void create()
    {
        String account = "TEST01";
        String password = "TEST01";

        String status = "REGISTERED";
        String email = "Test01@naver.com";
        String phoneNumber = "010-0123-1234";

        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminUser";

        User user = new User();
        user.setAccount(account);
        user.setEmail(email);
        user.setCreatedBy(createdBy);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setStatus(status);
        user.setPassword(password);

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);

    }

    @Test
    public void read()
    {
        String phoneNumber = "010-0123-1234";
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc(phoneNumber);
        Assert.assertNotNull(user);
        System.out.println(user);
    }


}
