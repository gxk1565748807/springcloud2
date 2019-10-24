package com.qf.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qf.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping("/findOrder")
    @HystrixCommand(fallbackMethod = "errorMes")
    public String findOrder(@RequestBody User user){
        int i = 1/0;
        return "通过"+user+"查询出该笔订单";
    }

    public String errorMes(@RequestBody User user){
        return "熔断发生了";
    }
}
