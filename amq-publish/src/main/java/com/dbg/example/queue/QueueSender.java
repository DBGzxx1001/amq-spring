package com.dbg.example.queue;
/*************************
 *          /\_/\
 *       =( °w° )=
 *          )   (  
 *         (__ __)
 *
 *     神兽保佑，永无bug！
 *************************/

import com.dbg.example.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;


/**
 * @Auther: DBG_zxx
 * @Date: 2018/11/27 14:02
 * @Desc:
 */
@Component
public class QueueSender {

    @Autowired
    @Qualifier("amqQueueTemplate")
    private JmsTemplate jmsTemplate;

    @Autowired
    private GetResponse getResponse;

    public void send(String queueName,final String message){

        // 发送 文本消息
/*        jmsTemplate.send(queueName, session ->  {
            Message msg = session.createTextMessage(message);
            return msg;
        });*/

        // replyTo  需要消费者回调
/*        jmsTemplate.send(queueName,session ->{

                Message msg = session.createTextMessage(message);

                // 告诉消费者如何应答
                Destination destination = session.createTemporaryQueue();
                MessageConsumer responseConsumer = session.createConsumer(destination);
                responseConsumer.setMessageListener(getResponse);

                msg.setJMSReplyTo(destination);
                // 配唯一ID
                String uid = System.currentTimeMillis()+"";
                msg.setJMSCorrelationID(uid);

                return msg;

        });*/


        //发送MapMessage
        jmsTemplate.send(queueName, session ->  {

            MapMessage map =  session.createMapMessage();
            map.setString("id","0001");
            map.setString("name","DBG_name");

            return map;

        });


        // 发送对象Object  被发送的实体类必须实现Serializable 接口
/*
        jmsTemplate.send(queueName, session -> {

                ObjectMessage objectMessage = session.createObjectMessage(new User(0001,"DBG_name"));

                return objectMessage;
        });
*/


        // 发送byteMessage
/*        jmsTemplate.send(queueName , session ->{

            BytesMessage bytesMessage = session.createBytesMessage();
            bytesMessage.writeBytes("BytesMessage 消息类型".getBytes());

            return bytesMessage;
        });*/


        // 发送Stream
/*        jmsTemplate.send(queueName , session -> {

            StreamMessage streamMessage = session.createStreamMessage();
            streamMessage.writeString("00001");
            streamMessage.writeString("DBG_name");

            return streamMessage;
        });*/

    }




}
