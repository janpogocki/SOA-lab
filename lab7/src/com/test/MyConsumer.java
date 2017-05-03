package com.test;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.logging.Logger;

/**
 * Created by Jan on 03.05.2017.
 */

@MessageDriven(name = "MyConsumerEJB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/test"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class MyConsumer implements MessageListener {

    private final static Logger LOGGER = Logger.getLogger(MyConsumer.class.toString());

    @Override
    public void onMessage(final Message msg) {
        if (msg instanceof TextMessage) {
            try {
                final String text = ((TextMessage) msg).getText();
                LOGGER.info(() -> "Received: " + text);
            } catch (final JMSException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
