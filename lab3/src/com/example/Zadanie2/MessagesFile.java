package com.example.Zadanie2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan on 29.03.2017.
 */
public class MessagesFile extends Messages {
    private String filePath = "D:\\Java\\SOA-lab\\lab3\\web\\messages.txt";
    private static List<String> listOfBlockedMessages = new ArrayList<>();

    public static void setBlock(String messageID){
        listOfBlockedMessages.add(messageID);
    }

    public static Boolean isBlocked(String messageID){
        return listOfBlockedMessages.contains(messageID);
    }

    public static void removeBlock(String messageID){
        listOfBlockedMessages.remove(messageID);
    }

    public MessagesFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String [] lineSplit = line.split("&");
                addMessage(lineSplit[0], lineSplit[1], lineSplit[2]);
            }
        } catch (IOException e){}
    }

    public String getMessage(String messageID){
        return listOfMessages.get(Integer.parseInt(messageID)).split("&")[2];
    }

    public void updateMessage(String messageID, String content){
        String [] previousMsg = listOfMessages.get(Integer.parseInt(messageID)).split("&");
        listOfMessages.set(Integer.parseInt(messageID), previousMsg[0] + "&" + previousMsg[1] + "&" + content);
        saveListToFile();
    }

    public void saveListToFile(){
        try {
            PrintWriter pw = new PrintWriter(filePath);
            for (String element : listOfMessages){
                String [] elementSplit = element.split("&");
                pw.println(elementSplit[0] + "&" + elementSplit[1] + "&" + elementSplit[2]);
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}