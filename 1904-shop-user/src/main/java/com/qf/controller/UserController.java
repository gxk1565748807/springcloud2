package com.qf.controller;

import com.netflix.discovery.converters.Auto;
import com.qf.client.OrderClient;
import com.qf.pojo.User;
import com.qf.service.MialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    OrderClient orderClient;

    @Autowired
    MialService mialService;

    @RequestMapping("/findOrder")
    public String FindOrder(@RequestParam("id") Integer id){

        User user = new User();
        user.setId(id);
        user.setUsername("瓜皮周飞");

        String order = orderClient.findOrder(user);
        return order;
    }

    @RequestMapping("sendMail")
    public String sendMail(@RequestParam("mail") String mail){
        //调用server
        mialService.send(mail);
        return "success!!!!";
    }

}
