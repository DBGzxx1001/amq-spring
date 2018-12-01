package com.dbg.example.topic;
/*************************
 *          /\_/\
 *       =( °w° )=
 *          )   (  
 *         (__ __)
 *
 *     神兽保佑，永无bug！
 *************************/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @Auther: DBG_zxx
 * @Date: 2018/11/30 13:47
 * @Desc:
 */
@Component
public class TopicSender {

    @Autowired
    @Qualifier(value = "jmsTopicTemplate")
    private JmsTemplate jmsTemplate;

    public void send(String topicName , final String message){
        // 发送 文本消息
        jmsTemplate.send(topicName, session ->  {
            Message msg = session.createTextMessage(message);
            return msg;
        });

        // replyTo  需要消费者回调
/*        jmsTemplate.send(topicName,session ->{

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
/*        jmsTemplate.send(topicName, session ->  {

            MapMessage map =  session.createMapMessage();
            map.setString("id","0001");
            map.setString("name","DBG_name");

            return map;

        });*/


        // 发送对象Object  被发送的实体类必须实现Serializable 接口
/*        jmsTemplate.send(topicName, session -> {

                ObjectMessage objectMessage = session.createObjectMessage(new User(0001,"DBG_name"));

                return objectMessage;
        });*/


        // 发送byteMessage  有乱码问题
/*
        jmsTemplate.send(topicName , session ->{

            BytesMessage bytesMessage = session.createBytesMessage();
            bytesMessage.writeBytes("BytesMessage 消息类型".getBytes());

            return bytesMessage;
        });
*/


        // 发送Stream
/*        jmsTemplate.send(topicName , session -> {

            StreamMessage streamMessage = session.createStreamMessage();
            streamMessage.writeString("00001");
            streamMessage.writeString("DBG_name");

            return streamMessage;
        });*/

    }

}
