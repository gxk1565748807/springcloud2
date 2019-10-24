package com.qf.client;

import com.qf.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "SHOP-ORDER",fallback = ErrorMessage.class)
public interface OrderClient {

    @GetMapping("/findOrder")
    public String findOrder(@RequestBody User user);
}
