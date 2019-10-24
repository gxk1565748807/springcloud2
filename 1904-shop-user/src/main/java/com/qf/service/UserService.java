package com.qf.service;

import com.qf.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findUser(Integer page, Integer size);
}
