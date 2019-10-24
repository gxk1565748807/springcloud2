package com.qf.client;


import com.qf.pojo.User;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class ErrorMessage implements OrderClient {


    @Override
    public String findOrder(@RequestBody User user){
        return "该服务无法访问，降级";
    }
}
