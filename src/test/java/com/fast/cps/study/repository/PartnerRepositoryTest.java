package com.fast.cps.study.repository;

import com.fast.cps.study.FastcampusApplicationTests;
import com.fast.cps.study.model.entity.Partner;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public class PartnerRepositoryTest extends FastcampusApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    @Transactional
    public void create()
    {
        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "010-1234-1423";
        String partnerNumber = "010-1111-2222";
        String businessNumber = "1234567890";
        String ceoName = "이건희";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminUser";

        Partner partner = new Partner();
        partner.setAddress(address);
        partner.setBusinessNumber(businessNumber);
        partner.setCallCenter(callCenter);
        partner.setCeoName(ceoName);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);
        partner.setName(name);
        partner.setStatus(status);
        partner.setPartnerNumber(partnerNumber);
        partner.setRegisteredAt(registeredAt);

        //임시 카테고리 ID
        partner.setCategoryId(1L);

        Partner newPartner = partnerRepository.save(partner);
        Assert.assertNotNull(newPartner);
        Assert.assertEquals(newPartner.getName(), name);
    }

    @Test
    public void read()
    {

    }
}
