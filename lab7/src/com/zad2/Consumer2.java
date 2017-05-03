package com.zad2;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by Jan on 04.05.2017.
 */
@MessageDriven(name = "Consumer2EJB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/test"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class Consumer2 implements MessageListener {
    @Override
    public void onMessage(final Message msg) {

            try {
                final String nazwa = msg.getStringProperty("nazwa");
                final String rodzaj = msg.getStringProperty("rodzaj");
                final String kapital = msg.getStringProperty("kapital");
                final String wlasciciel = msg.getStringProperty("wlasciciel");

                Firma firma = new Firma();
                firma.setNazwa(nazwa);
                firma.setRodzaj(rodzaj);
                firma.setKapital(kapital);
                firma.setWlasciciel(wlasciciel);

                Storage2.firmList.add(firma);
            } catch (final JMSException e) {
                throw new RuntimeException(e);
            }

    }
}
