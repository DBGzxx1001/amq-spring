package com.dbg.example.queue;
/*************************
 *          /\_/\
 *       =( °w° )=
 *          )   (  
 *         (__ __)
 *
 *     神兽保佑，永无bug！
 *************************/

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @Auther: DBG_zxx
 * @Date: 2018/11/30 11:53
 * @Desc:
 */
@Component
public class QueueReceiver2 implements MessageListener {


    @Override
    public void onMessage(Message message) {
        try {


        // 接收Text消息
            if (message instanceof TextMessage) {
                String textMsg = ((TextMessage) message).getText();
                System.out.println("QueueReceiver2 accept msg : " + textMsg);
            }

            // 接收Map消息
			if (message instanceof MapMessage) {
				MapMessage mm = (MapMessage) message;
				System.out.println("queue 获取 MapMessage：   id：" + mm.getString("id")
						+ "     name:" + mm.getString("name"));
			}

/*			// 接收Object消息
			if (message instanceof ObjectMessage) {
				ObjectMessage objectMessage = (ObjectMessage) message;
				User user = (User) objectMessage.getObject();
				System.out.println("获取 ObjectMessage：  "+user);
			}*/

/*			// 接收bytes消息
			if (message instanceof BytesMessage) {
				byte[] b = new byte[1024];
				int len = -1;
				BytesMessage bm = (BytesMessage) message;
				while ((len = bm.readBytes(b)) != -1) {
					System.out.println(new String(b, 0, len));
				}
			}*/

/*			// 接收Stream消息
			if (message instanceof StreamMessage) {
				StreamMessage streamMessage = (StreamMessage) message;
				System.out.println(streamMessage.readString());
				System.out.println(streamMessage.readInt());
			}*/
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
