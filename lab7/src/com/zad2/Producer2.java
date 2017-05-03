package com.zad2;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

/**
 * Created by Jan on 04.05.2017.
 */
@Stateless(name = "Producer2EJB")
public class Producer2 {
    @Resource(mappedName = "java:/topic/test")
    Topic queue;
    @Inject
    JMSContext jmsContext;

    public void sendMsg(String nazwa, String rodzaj, String kapital, String wlasiciel) {
        Message message = jmsContext.createMessage();
        try {
            message.setStringProperty("nazwa", nazwa);
            message.setStringProperty("rodzaj", rodzaj);
            message.setStringProperty("kapital", kapital);
            message.setStringProperty("wlasciciel", wlasiciel);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        jmsContext.createProducer().send(queue, message);
    }
}
