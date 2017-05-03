package com.zad1;

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
@MessageDriven(name = "Consumer1EJB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class Consumer1 implements MessageListener {

    private final static Logger LOGGER = Logger.getLogger(Consumer1.class.toString());

    @Override
    public void onMessage(final Message msg) {
        if (msg instanceof TextMessage) {
            try {
                final String text = ((TextMessage) msg).getText();
                LOGGER.info(() -> "Received1: " + text);

                Storage.messageList.add(msg);
            } catch (final JMSException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
