package com.test.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Exchanger;

/**
 * @Author zhuhp
 * @Date 2019/7/27
 */
public class Productor {

    static final String QUEUE_NAME = "test.queue";
    static final String EXCHANGE_NAME = "test.exchange";
    static final String EXCHANGE_NAME_BAK = "test.exchange.bak";
    static final String ROUT_KEY = "root.key.test";

    public static void main(String[] ss) throws Exception{

        ConnectionFactory factory = RabbitFactory.newFactory();

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        // 创建备份交换器
        Map<String,Object> bakArgs = new HashMap<>();
        bakArgs.put("alternate-exchange",EXCHANGE_NAME_BAK);
        // 创建u交换器
        channel.exchangeDeclare(EXCHANGE_NAME,"direct" ,false,false,false,null);
//        channel.exchangeDeclare(EXCHANGE_NAME,"direct" ,false,false,false,bakArgs);
//        channel.exchangeDeclare(EXCHANGE_NAME_BAK,"fanout" ,false,false,false,null);

        Map<String,Object> arg = new HashMap<>();
        // 消息 10s 未消费自动删除
//        arg.put("x-message-ttl",10000);
        // 队列 10s未使用 ，队列被 删除
//        arg.put("x-expires",10000);


        channel.queueDeclare(QUEUE_NAME,false,false,false,arg);
        //通过路由键绑定交换器
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME,ROUT_KEY);
        // 发送消息给rqbbitmq
        channel.basicPublish(EXCHANGE_NAME,ROUT_KEY,true,
                MessageProperties.PERSISTENT_TEXT_PLAIN," ==> hello rabbit mq===".getBytes());

        //消息未发送成功处理办法
        /**
         * 1, 发布消息时，明确发的消息失败需要得到相应的通知；mandatory=true;
         * 2, 设置监听事件，并处理消息；
         */
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int i, String s, String s1, String s2, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
                System.out.println("routkey:" + s2 + " replyText:" + s);
            }
        });
        channel.close();
        connection.close();

    }
}
