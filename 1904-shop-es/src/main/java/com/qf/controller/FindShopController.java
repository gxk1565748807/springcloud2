package com.qf.controller;

import com.alibaba.fastjson.JSONArray;
import com.qf.service.FindShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindShopController {
    @Autowired
    private FindShopService findShopService;


    @RequestMapping(value = "/findShop")
    public JSONArray findShop(@RequestParam("name") String name){
        JSONArray objects = findShopService.find(name);
        return objects;
    }

}
