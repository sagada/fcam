package com.fast.cps.study.repository;


import com.fast.cps.study.model.entity.Item;
import com.fast.cps.study.model.enumclass.ItemStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTest {
    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @Transactional
    public void create()
    {
        //given
        Item item = new Item();
        item.setStatus(ItemStatus.REGISTERED);
        item.setName("노트북");
        item.setTitle("삼성 노트북 A100");
        item.setContent("2019년형 노트북 입니다.");
        item.setPrice(BigDecimal.valueOf(900000));
        item.setBrandName("삼성");
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
        item.setRegisteredAt(LocalDateTime.now());
        item.setPartner(partnerRepository.findById(1L).get());
        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);

    }

    @Test
    public void read()
    {

    }
}
