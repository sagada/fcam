package com.fast.cps.study.repository;


import com.fast.cps.study.model.entity.Item;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create()
    {
        //given
        Item item = new Item();
        item.setStatus("UNREGISTERED");
        item.setName("노트북");
        item.setTitle("삼성 노트북 A100");
        item.setContent("2019년형 노트북 입니다.");
        item.setPrice(900000);
        item.setBrandName("삼성");
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
        item.setRegisteredAt(LocalDateTime.now());
//        item.setPartnerId(1L);
        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);

    }

    @Test
    public void read()
    {

    }
}
