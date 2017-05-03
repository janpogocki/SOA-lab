package com.zad1;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan on 03.05.2017.
 */
public class Storage {
    public static List<Message> messageList = new ArrayList<>();

    public static String getMessages(String type, String topicName){
        StringBuilder returned = new StringBuilder();

        try {
            for (int i=0; i<messageList.size(); i++) {
                Message m = messageList.get(i);
                if (m.getStringProperty("type").equals(type) && m.getStringProperty("topic").equals(topicName)) {
                    returned.append(((TextMessage) m).getText()).append("\n");
                    if (messageList.remove(m))
                        i--;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

        return returned.toString();
    }
}
