package com.newland.security.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Set<String> authoritys = new HashSet<>();
            authoritys.add(String.format("ROLE_%s", "admin"));
            authoritys.add("permission:insert");
            List<GrantedAuthority> auths = AuthorityUtils.createAuthorityList(authoritys.toArray(new String[]{}));
            return new User(username, "", auths);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
