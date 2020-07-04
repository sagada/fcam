package com.fast.cps.study.repository;

import com.fast.cps.study.model.entity.User;
import com.fast.cps.study.model.enumclass.UserStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void create()
    {
        String account = "TEST02";
        String password = "TEST02";


        String email = "Test02@naver.com";
        String phoneNumber = "010-0123-0234";

        LocalDateTime registeredAt = LocalDateTime.now();

        User user = User.builder()
                .account(account)
                .email(email)
                .phoneNumber(phoneNumber)
                .registeredAt(registeredAt)
                .status(UserStatus.REGISTERED)
                .password(password)
                .build();

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);

    }

    @Test
    public void read()
    {
        String phoneNumber = "010-0123-1234";
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc(phoneNumber);

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("-------------주문 묶음--------------");
            System.out.println("수령인 : " + orderGroup.getRevName());
            System.out.println("수령지 : " + orderGroup.getRevAddress());
            System.out.println("총금액 : " + orderGroup.getTotalPrice());
            System.out.println("총 수량 : " + orderGroup.getTotalQuantity());

            System.out.println("-------------주문 상세--------------");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                System.out.println("파트너나 카테고리 : " +orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문 상품 : " + orderDetail.getItem().getName());
                System.out.println("고객 센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태 : " + orderDetail.getStatus());
                System.out.println("도착 예정일자 : " + orderDetail.getArrivalDate());

            });
        });
        Assert.assertNotNull(user);
        System.out.println(user);
    }


}
