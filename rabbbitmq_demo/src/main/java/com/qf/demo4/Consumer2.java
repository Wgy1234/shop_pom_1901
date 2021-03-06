package com.qf.demo4;

import com.qf.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @version 1.0
 * @user lao王
 * @date 2019/5/24 21:09
 */
public class Consumer2 {

    public static void main(String[] args) throws IOException {

        //拿到连接
        Connection connection = ConnectionUtil.getConnection();

        //获得通道
        Channel channel = connection.createChannel();

        channel.basicConsume("myqueue2",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("myqueue2接受到的消息为："+new String(body,"utf-8"));
            }
        });
    }
}
