package org.tts.util;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description :
 * @Auther : Tianjx
 * @CreateTime : 2022/10/17 13:57
 */
public class RabbitConnectUtils {

    public static Connection getConnection() throws Exception {

        ConnectionFactory connectionFactory =new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("tts");
        connectionFactory.setPassword("tts123");
        Connection connection = connectionFactory.newConnection();
        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection connection = getConnection();
        System.out.println(connection);
        connection.close();
    }
}
