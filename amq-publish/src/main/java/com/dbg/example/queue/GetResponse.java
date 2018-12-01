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
 * @Date: 2018/11/27 14:25
 * @Desc:  回调
 */
@Component
public class GetResponse implements MessageListener {
    public void onMessage(Message message) {
        String textMsg = null;
        try {
            textMsg = ((TextMessage) message).getText();
            System.out.println("GetResponse accept msg : " + textMsg);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
