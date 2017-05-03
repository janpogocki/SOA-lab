package com.zad1;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

/**
 * Created by Jan on 03.05.2017.
 */
@Stateless(name = "Producer1EJB")
public class Producer1 {
    @Resource(mappedName = "java:/queue/test")
    Queue queue;
    @Inject
    JMSContext jmsContext;

    public void sendMsg(String text, String type, String topicName) {
        Message message = jmsContext.createTextMessage(text);
        try {
            message.setStringProperty("topic", topicName);
            message.setStringProperty("type", type);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        jmsContext.createProducer().send(queue, message);
    }
}
