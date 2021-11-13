package com.security.learning.chapter4.repository;

import com.security.learning.chapter4.entity.CustomUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomUserRepository extends CrudRepository<CustomUserEntity, Long> {
    CustomUserEntity findByUsername(String username);
}
