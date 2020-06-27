package com.fast.cps.study.repository;

import com.fast.cps.study.FastcampusApplicationTests;
import com.fast.cps.study.model.entity.OrderGroup;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderGroupRepositoryTest extends FastcampusApplicationTests {
    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create()
    {
        OrderGroup orderGroup = new OrderGroup();
        orderGroup.setCreatedBy("AdminServer");
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setTotalQuantity(1);
        orderGroup.setUserId(1L);
        orderGroup.setOrderType("즉시");
        orderGroup.setStatus("DELIVERING");
        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
        Assert.assertNotNull(newOrderGroup);
    }

}
