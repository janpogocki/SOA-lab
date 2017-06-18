package com.parking.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Jan on 17.06.2017.
 */
public class Storage {
    private static List<Message> messageList = new ArrayList<>();

    private static boolean contains(Message message){
        for (int i=0; i<messageList.size(); i++){
            try {
                if (((TextMessage) message).getText().equals(((TextMessage) messageList.get(i)).getText()))
                    return true;
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public static void addMessage(Message message){
        try {
            if (((TextMessage) message).getText().equals("CLEAR"))
                messageList = new ArrayList<>();
        } catch (JMSException e) {
            e.printStackTrace();
        }

        messageList.add(message);
    }

    public static String getMessages(String strefa){
        StringBuilder returned = new StringBuilder();

        List<Message> listOfMessages = new ArrayList<>(new LinkedHashSet<>(Storage.messageList));

        try {
            for (int i=0; i<listOfMessages.size(); i++) {
                Message m = listOfMessages.get(i);
                if (m.getStringProperty("strefa").equals(strefa)) {
                    returned.append(((TextMessage) m).getText() + " (" + m.getStringProperty("miejsce") + ")").append("\n");
                    if (listOfMessages.remove(m))
                        i--;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

        return returned.toString();
    }
}
