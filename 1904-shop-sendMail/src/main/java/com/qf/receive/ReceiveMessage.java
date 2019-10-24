package com.qf.receive;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveMessage {

    @RabbitListener(queues = "mail")
    public void receive(String s){
        System.out.println("接收到参数+========="+s);
    }
}
