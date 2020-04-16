package com.tensquare.rabbit.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by aheadx on 2020/4/16.
 */
@Component
@RabbitListener(queues = "itheima")
public class Customer2 {

    @RabbitHandler
    public void getMsg(String msg) {
        System.out.println("itheima"+msg);
    }
}
