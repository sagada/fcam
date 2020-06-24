package com.fast.cps.study.repository;

import com.fast.cps.study.model.entity.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void create() throws Exception
    {
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderAt(LocalDateTime.now());
        OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);
    }



}
