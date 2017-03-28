package com.example.Zadanie1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jan on 28.03.2017.
 */
public class UsersBean {
    private static List<String> listOfUsers = new ArrayList<>();

    public UsersBean(){}

    public UsersBean(String user, String date){
        addUser(user, date);
    }

    public int count(){
        return listOfUsers.size();
    }

    public void addUser(String user, String date){
        listOfUsers.add(user + "&" + date);
    }

    public void deleteUser(String user, String date){
        listOfUsers.remove(user + "&" + date);
    }

    public List<String> getListOfUsers(String sort) {
        if (sort.equals("asc"))
            Collections.sort(listOfUsers);
        else
            Collections.sort(listOfUsers, Collections.reverseOrder());

        return listOfUsers;
    }
}
