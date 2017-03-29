package com.example.Zadanie2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan on 29.03.2017.
 */
public class Messages {
    protected List<String> listOfMessages = new ArrayList<>();
    private Boolean setEditableMessages = false;

    public void setSetEditableMessages(){
        setEditableMessages = true;
    }

    public void addMessage(String name, String email, String comment){
        if (!name.equals("") && !email.equals("") && !comment.equals(""))
            listOfMessages.add(name + "&" + email + "&" + comment);
    }

    public String printMessages(){
        String temp = "";
        int counter = 0;
        for (String element : listOfMessages) {
            String [] splitElement = element.split("&");

            if (setEditableMessages)
                temp = temp + "<b>" + splitElement[0] + "</b> (" + splitElement[1] + ") says [<a href=\"Zadanie2edit.jsp?edit=" + counter + "\">Edit</a>]<br><code>" + splitElement[2] + "</code><br><br>";
            else
                temp = temp + "<b>" + splitElement[0] + "</b> (" + splitElement[1] + ") says<br><code>" + splitElement[2] + "</code><br><br>";

            counter++;
        }

        return temp;
    }
}