package com.qf.service.impl;

import com.qf.service.MialService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MialService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void send(String mail) {
        rabbitTemplate.convertAndSend("mail",mail);
    }
}
