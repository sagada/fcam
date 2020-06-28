package com.fast.cps.study.repository;

import com.fast.cps.study.model.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;



    @Test
    public void create() throws Exception
    {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));

        orderDetail.setStatus("WAITING");
        orderDetail.setQuantity(1);
//        orderDetail.setOrderGroupId(1L); //어떠한 장바구니에
//        orderDetail.setItemId(1L); //어떤 상품
        orderDetail.setTotalPrice(BigDecimal.valueOf(9000000));
        orderDetail.setCreatedBy("AdminServer");
        orderDetail.setCreatedAt(LocalDateTime.now());
        OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(orderDetail1);
    }

}
