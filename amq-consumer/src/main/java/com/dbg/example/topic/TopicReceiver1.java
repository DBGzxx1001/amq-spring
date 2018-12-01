package com.dbg.example.topic;
/*************************
 *          /\_/\
 *       =( °w° )=
 *          )   (  
 *         (__ __)
 *
 *     神兽保佑，永无bug！
 *************************/

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Auther: DBG_zxx
 * @Date: 2018/11/30 11:54
 * @Desc:
 */
@Component
public class TopicReceiver1 implements MessageListener{
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("TopicReceiver1 accept msg : " + ((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
