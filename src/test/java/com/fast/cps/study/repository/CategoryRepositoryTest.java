package com.fast.cps.study.repository;

import com.fast.cps.study.FastcampusApplicationTests;
import com.fast.cps.study.model.entity.Category;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends FastcampusApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Transactional
    public void create()
    {
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);
        category.setType(type);

        Category newCategory = categoryRepository.save(category);

        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getTitle(), title);
        Assert.assertEquals(newCategory.getType(), type);

    }

    @Test
    public void read()
    {
        String type = "COMPUTER";
        String title = "컴퓨터";
        Optional<Category> optionalCategory = categoryRepository.findByType("COMPUTER");
        optionalCategory.ifPresent(c->{
            Assert.assertEquals(c.getType(), type);
            Assert.assertEquals(c.getTitle(), title);
        });
    }

}
