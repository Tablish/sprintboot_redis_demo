package com.qyc.rabbitmq;

import com.qyc.rabbitmq.Entity.User;
import com.qyc.rabbitmq.Fanout.FanoutSender;
import com.qyc.rabbitmq.Many.Sender2;
import com.qyc.rabbitmq.Many.Sender3;
import com.qyc.rabbitmq.OneToOne.Sender1;
import com.qyc.rabbitmq.TopicDemo.TopicSender1;
import com.qyc.rabbitmq.object.ObjectSender1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

    @Autowired
    private Sender1 sender1;
    @Autowired
    private Sender2 sender2;
    @Autowired
    private Sender3 sender3;
    @Autowired
    private ObjectSender1 objectSender1;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private TopicSender1 topicSender1;
    /*
     * @author qianyongchao
     * @description 一对一
     * @date 17:08 2018/12/6
     * @param
     * @return
     */
    @Test
    public void oneToOne() {
	    sender1.send();
    }

    /*
     * @author qianyongchao
     * @description 一对多
     * @date 17:08 2018/12/6
     * @param
     * @return
     */

    /* result
        Consumer2 hello Thu Dec 06 17:17:11 CST 2018
        Consumer3 hello Thu Dec 06 17:17:14 CST 2018
        Consumer2 hello Thu Dec 06 17:17:17 CST 2018
        Consumer3 hello Thu Dec 06 17:17:20 CST 2018
        Consumer2 hello Thu Dec 06 17:17:23 CST 2018
        Consumer3 hello Thu Dec 06 17:17:26 CST 2018
        Consumer2 hello Thu Dec 06 17:17:29 CST 2018
        Consumer3 hello Thu Dec 06 17:17:32 CST 2018
        Consumer2 hello Thu Dec 06 17:17:35 CST 2018
        Consumer3 hello Thu Dec 06 17:17:38 CST 2018
     */
    /*@Test
    public void oneToMany() throws InterruptedException {
        for(int i = 0; i < 10; i++) {
            Thread.sleep(3000);
            sender2.send();
        }
    }*/

    /*
     * @author qianyongchao
     * @description 多对多
     * @date 17:08 2018/12/6
     * @param
     * @return
     */

    /* result
    Consumer3 hello Thu Dec 06 17:21:45 CST 2018
    Consumer2 hello Thu Dec 06 17:21:45 CST 2018
    Consumer2 hello Thu Dec 06 17:21:48 CST 2018
    Consumer3 hello Thu Dec 06 17:21:48 CST 2018
    Consumer2 hello Thu Dec 06 17:21:51 CST 2018
    Consumer3 hello Thu Dec 06 17:21:51 CST 2018
    Consumer2 hello Thu Dec 06 17:21:54 CST 2018
    Consumer3 hello Thu Dec 06 17:21:54 CST 2018
    Consumer3 hello Thu Dec 06 17:21:57 CST 2018
    Consumer2 hello Thu Dec 06 17:21:57 CST 2018
    Consumer2 hello Thu Dec 06 17:22:00 CST 2018
    Consumer3 hello Thu Dec 06 17:22:00 CST 2018
    Consumer2 hello Thu Dec 06 17:22:03 CST 2018
    Consumer3 hello Thu Dec 06 17:22:03 CST 2018
    Consumer2 hello Thu Dec 06 17:22:06 CST 2018
    Consumer3 hello Thu Dec 06 17:22:06 CST 2018
    Consumer3 hello Thu Dec 06 17:22:09 CST 2018
    Consumer2 hello Thu Dec 06 17:22:09 CST 2018
    Consumer3 hello Thu Dec 06 17:22:12 CST 2018
    Consumer2 hello Thu Dec 06 17:22:12 CST 2018
*/
    @Test
    public void manyToMany() throws InterruptedException {
        for(int i = 0; i < 10; i++) {
            sender2.send();
            sender3.send();
            Thread.sleep(3000);
        }
    }


    //不管是一对多还是多对多，并不是按照一定的顺序执行的，也就是现在我还不清楚情况下，消费者 消费的先后顺序！

    /*
     * @author qianyongchao
     * @description
     * @date 18:20 2018/12/6
     * @param 对象demo
     * @return void
     */

    /*
        object_sender:User(userName=qianyongchao, password=123456)
        Consumer2 User(userName=qianyongchao, password=123456)
    * */
    @Test
    public void objectTest() {
        User user = new User("qianyongchao", "123456");
        objectSender1.sender(user);
    }

    /*
    *
    topic sender1  message 1
    topic consumer2  message 1
    topic consumer1  message 1
    * */
    @Test
    public void topicTest() {
        topicSender1.send1();
    }


    /*
        fanout sender Fri Dec 07 10:30:32 CST 2018
        2018-12-07 10:30:32.196  INFO 2000 --- [       Thread-3] o.s.a.r.l.SimpleMessageListenerContainer : Waiting for workers to finish.
        fanout consumer1 fanout sender Fri Dec 07 10:30:32 CST 2018
        fanout consumer3 fanout sender Fri Dec 07 10:30:32 CST 2018
        fanout consumer2 fanout sender Fri Dec 07 10:30:32 CST 2018
    * */
    @Test
    public void fanoutTest() {
        fanoutSender.fanoutSender();
    }
}
