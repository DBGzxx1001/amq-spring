package test01;
/*************************
 *          /\_/\
 *       =( °w° )=
 *          )   (  
 *         (__ __)
 *
 *     神兽保佑，永无bug！
 *************************/

import com.dbg.example.queue.QueueSender;
import com.dbg.example.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
/**
 * @Auther: DBG_zxx
 * @Date: 2018/11/27 14:53
 * @Desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:../webapp/WEB-INF/config/spring-mvc.xml","classpath:../webapp/WEB-INF/config/applicationContext1.xml"})
@ContextConfiguration(locations = {"classpath*:config/spring-mvc.xml","classpath*:config/applicationContext.xml"})
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/spring-mvc.xml","file:*/main/webapp/WEB-INF/config/applicationContext.xml"})
@WebAppConfiguration
public class PublishTest {

    @Resource
    QueueSender queueSender;
    @Autowired
    TopicSender topicSender;

    @Test
    public void queueSend(){
        queueSender.send("test.queue","lalal");
    }

    @Test
    public void TopicSend(){
        topicSender.send("test.topic","topic 啦啦啦");
    }

}
