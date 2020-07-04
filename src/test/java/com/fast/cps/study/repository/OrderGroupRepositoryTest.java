package com.fast.cps.study.repository;

import com.fast.cps.study.FastcampusApplicationTests;
import com.fast.cps.study.model.entity.OrderGroup;
import com.fast.cps.study.model.enumclass.OrderType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public class OrderGroupRepositoryTest extends FastcampusApplicationTests {
    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    @Transactional
    public void create()
    {
        OrderGroup orderGroup = new OrderGroup();
        orderGroup.setCreatedBy("AdminServer");
        orderGroup.setCreatedAt(LocalDateTime.now())  ;
        orderGroup.setTotalQuantity(1);
//        orderGroup.setUserId(1L); //외래키
        orderGroup.setOrderType(OrderType.ALL);
        orderGroup.setStatus("DELIVERING");
        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
        Assert.assertNotNull(newOrderGroup);
    }

    @Test
    public void read()
    {

    }

}
