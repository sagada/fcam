package com.fast.cps.study.repository;

import com.fast.cps.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
