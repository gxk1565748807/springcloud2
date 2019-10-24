package com.qf.response;

import com.qf.pojo.User;
import lombok.Data;

import java.util.List;


@Data
public class UserResponse {
    private Long total;
    private List<User> userList;
    private int size;
}