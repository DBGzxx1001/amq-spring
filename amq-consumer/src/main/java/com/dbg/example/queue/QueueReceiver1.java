package com.dbg.example.queue;
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
 * @Date: 2018/11/30 11:52
 * @Desc:
 */
@Component
public class QueueReceiver1 implements MessageListener{
    @Override
    public void onMessage(Message message) {
        try {
            // 接收Text消息
            if (message instanceof TextMessage) {
                String textMsg = ((TextMessage) message).getText();
                System.out.println("QueueReceiver1 accept msg : " + textMsg);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
