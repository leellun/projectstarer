package com.newland.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.newland.mybatis.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {

    List<User> listAllByName(String name);
}
