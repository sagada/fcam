package com.fast.cps.study.repository;


import com.fast.cps.study.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    @Transactional
    public void create()
    {
        //given
        String name = "노트북";
        String content = "노트북 특가!";
        int price = 100000;

        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setContent(content);
        Item newItem = itemRepository.save(item);
        assertThat(newItem.getName()).isEqualTo(name);
    }

    @Test
    public void read()
    {
        Long id = 1L;
        Item item = itemRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("id : 1 없어"));
        System.out.println(item);
        assertThat(item.getId()).isEqualTo(id);
    }
}
