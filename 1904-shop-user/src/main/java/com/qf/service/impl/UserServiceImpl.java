package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.mapper.UserMapper;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUser(Integer page, Integer size) {
        Page<Object> objects = PageHelper.startPage(page, size);
        List<User> user = userMapper.findUser();
        long total = objects.getTotal();

        return user;
    }
}
