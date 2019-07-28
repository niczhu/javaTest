package com.test.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author zhuhp
 * @Date 2019/7/27
 */
public class RabbitFactory {

    static final String NAME = "guest";
    static final String PWD = "guest";
    static final int PORT = 5672;

    public static ConnectionFactory newFactory(){

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setUsername(NAME);
        factory.setPassword(PWD);
        factory.setPort(PORT);
        return factory;
    }
}
