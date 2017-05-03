package com.test;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

/**
 * Created by Jan on 03.05.2017.
 */
@Stateless
@LocalBean
public class MyProducer {

    @Resource(mappedName = "java:/topic/test")
    Topic testQueue;
    @Inject
    JMSContext jmsContext;

    public void enqueue(final String text) {
        Message message = jmsContext.createTextMessage(text);
        try {
            message.setStringProperty("NewsType", "Sports");
        } catch (JMSException e) {
            e.printStackTrace();
        }
        //jmsContext.createProducer().send(testQueue, text);
        jmsContext.createProducer().send(testQueue, message);
    }
}
