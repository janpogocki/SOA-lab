package com.parking.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;

/**
 * Created by Jan on 17.06.2017.
 */
@Stateless(name = "TicketProducerEJB")
public class TicketProducer {
    @Resource(mappedName = "java:/queue/test")
    Queue queue;
    @Inject
    JMSContext jmsContext;

    public void sendMsg(String text, String strefa, String miejsce) {
        Message message = jmsContext.createTextMessage(text);
        try {
            message.setStringProperty("strefa", strefa);
            message.setStringProperty("miejsce", miejsce);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        jmsContext.createProducer().send(queue, message);
    }
}
