package com.qf.mapper;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.security.PrivateKey;
import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findUser();
}
