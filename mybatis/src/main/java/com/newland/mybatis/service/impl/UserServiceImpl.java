package com.newland.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.newland.mybatis.entity.User;
import com.newland.mybatis.mapper.UserMapper;
import com.newland.mybatis.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public List<User> listAllByName(String name) {
        return baseMapper.selectAllByName(name);
    }
}
