package com.fast.cps.study.repository;

import com.fast.cps.study.FastcampusApplicationTests;
import com.fast.cps.study.model.entity.AdminUser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AdminUserRepositoryTest extends FastcampusApplicationTests {
    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void create()
    {
        AdminUser adminUser = new AdminUser();
        adminUser.setAccount("AdminUser04");
        adminUser.setPassword("AdminUser04");
        adminUser.setStatus("REGISTERED");
        adminUser.setRole("PARTNER");

        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        Assert.assertNotNull(newAdminUser);
        Assert.assertEquals(newAdminUser.getAccount(), "AdminUser04");
        newAdminUser.setAccount("CHANGE");
        adminUserRepository.save(newAdminUser);
    }
}
