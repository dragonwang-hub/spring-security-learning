package com.security.learning.chapter4.service;

import com.security.learning.chapter4.dto.CustomUser;
import com.security.learning.chapter4.entity.CustomUserEntity;
import com.security.learning.chapter4.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomUserRepository customUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUserEntity userEntity = customUserRepository.findByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        // 将roles string转换成list权限集合。 security的方法
        CustomUser user = CustomUser.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .enable(userEntity.isEnable())
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList(userEntity.getRoles()))
                .build();
        return user;
    }
}
