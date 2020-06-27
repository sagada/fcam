package com.fast.cps.study.repository;

import com.fast.cps.study.FastcampusApplicationTests;
import com.fast.cps.study.model.entity.User;
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

        // select * from user where id =

        String findAccount = "account1";
        Optional<User> user = userRepository.findByAccount(findAccount);
        user.ifPresent(seletedUser -> {
            seletedUser.getOrderDetails().stream().forEach(detail->{
                System.out.println(detail.getItem());
            });

        });
    }

    @Test
    public void find_아이디와_계정이름_read()
    {

    }

    @Test
    @Transactional
    public void delete()
    {
        Long findId = 3L;
        Optional<User> user = userRepository.findById(findId);

        userRepository
                .findById(findId)
                .ifPresent(selectedUser -> {
                    userRepository.deleteById(findId);
                });

        userRepository.findById(findId).orElseThrow(()-> new IllegalArgumentException("없어 유저가..."));
    }
}
