package com.test;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.soap.Text;
import java.util.logging.Logger;

/**
 * Created by Jan on 03.05.2017.
 */

@MessageDriven(name = "MyConsumer2EJB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/test"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "NewsType = 'Sports' OR NewsType = 'Opinion'"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class MyConsumer2 implements MessageListener {

    private final static Logger LOGGER = Logger.getLogger(MyConsumer2.class.toString());

    @Override
    public void onMessage(final Message msg) {
        if (msg instanceof TextMessage) {
            try {
                final String text = ((TextMessage) msg).getText();
                LOGGER.info(() -> "Received2: " + text);
            } catch (final JMSException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
