package com.test.rabbitmq;

import ch.qos.logback.core.util.TimeUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Author zhuhp
 * @Date 2019/7/27
 */
public class Consumer {

    static final String QUEUE_NAME = "test.queue";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = RabbitFactory.newFactory();

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 消费者接收消息
        channel.basicConsume(QUEUE_NAME,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);

                //接收消息
                System.out.println("标签：" + consumerTag);
                System.out.println("consumer 接收消息"+new String(body));

                // 告诉服务器收到消息
                channel.basicAck(envelope.getDeliveryTag(),false);

            }
        });

        // close
        Thread.sleep(1000);
        channel.close();
        connection.close();
    }
}
