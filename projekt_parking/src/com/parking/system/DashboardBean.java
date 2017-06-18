package com.parking.system;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Jan on 17.06.2017.
 */

@ManagedBean(name = "DashboardBean", eager = true)
@SessionScoped
public class DashboardBean {
    public void logout() {
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        try {
            origRequest.getSession().invalidate();
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLoggedUser() {
        HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return origRequest.getRemoteUser();
    }

    public boolean isAdmin(){
        if (getLoggedUser().equals("admin"))
            return true;
        else
            return false;
    }

    public void redirect() {
        HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        if (origRequest.getRemoteUser() != null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("dashboard.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // -----------------------------------

    public String getDashboardContent(){
        String user = getLoggedUser();

        if (user.equals("admin")){
            StringBuilder returned = new StringBuilder();

            for (int i=100; i<400; i++)
                returned.append(getDashboardAboutPlace(i));

            return returned.toString();
        }
        else if (user.equals("controller1")) {
            StringBuilder returned = new StringBuilder();

            for (int i=100; i<200; i++)
                returned.append(getDashboardAboutPlace(i));

            return returned.toString();
        }
        else if (user.equals("controller1")) {
            StringBuilder returned = new StringBuilder();

            for (int i=200; i<300; i++)
                returned.append(getDashboardAboutPlace(i));

            return returned.toString();
        }
        else if (user.equals("controller1")) {
            StringBuilder returned = new StringBuilder();

            for (int i=300; i<400; i++)
                returned.append(getDashboardAboutPlace(i));

            return returned.toString();
        }
        else
            return "";
    }

    private String getDashboardAboutPlace(int id){
        int numberOnList = Storage.findPlaceByPlaceID(id);

        if (numberOnList == -1){
            // jest wolne
            return "[" + id + "] WOLNE<br>";
        }
        else {
            String returned = "<b>[" + id + "] ";

            Place place = Storage.listOfPlaces.get(numberOnList);
            String carID = place.getCarID();
            returned = returned + carID + " // ";

            Ticket ticket = Storage.listOfTickets.get(Storage.findTicketByCarID(carID));
            long startTime = ticket.getStartTime();
            long endTime = ticket.getEndTime();
            long currentTime = System.currentTimeMillis();

            Calendar calendar = Calendar.getInstance();

            calendar.setTimeInMillis(startTime);
            returned = returned + calendar.get(Calendar.DAY_OF_MONTH) + "." + calendar.get(Calendar.MONTH) + "." + calendar.get(Calendar.YEAR) + ", "
                    + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + " -> ";

            calendar.setTimeInMillis(endTime);
            returned = returned + calendar.get(Calendar.DAY_OF_MONTH) + "." + calendar.get(Calendar.MONTH) + "." + calendar.get(Calendar.YEAR) + ", "
                    + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);

            if (currentTime > endTime){
                long diff = (currentTime - endTime) / 1000;
                long hourDelay = diff / 3600;
                long minuteDelay = (diff % 3600) / 60;
                long secDelay = (diff % 60) + 1;

                returned = "<font color=\"red\">" + returned + " // OPÓŹNIENIE: " + hourDelay + ":" + minuteDelay + ":" + secDelay + "</font><br>";
            }
            else
                returned = returned + "<br>";

            return returned + "</b>";
        }
    }

    // -----------------------------------

    public String getReportContent(){

        Iterator<Map.Entry<String, List<Long[]>>> iterator = Storage.archiveListOfTickets.entrySet().iterator();
        StringBuilder returned = new StringBuilder();

        while (iterator.hasNext()){
            Map.Entry<String, List<Long[]>> entry = iterator.next();
            returned.append(getReportAboutCarID(entry.getKey()));
        }

        return returned.toString();
    }

    public String getReportAboutCarID(String carID){
        List<Long[]> listOfTimestamps = Storage.archiveListOfTickets.get(carID);
        StringBuilder returned = new StringBuilder("<b>" + carID + "</b><br>");
        long sumOfSecondsOnParking = 0;

        for (int i=0; i<listOfTimestamps.size(); i++){
            Calendar calendar = Calendar.getInstance();

            calendar.setTimeInMillis(listOfTimestamps.get(i)[0]);
            returned.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;").append(i+1).append(". ").append(calendar.get(Calendar.DAY_OF_MONTH)).append(".").append(calendar.get(Calendar.MONTH)).append(".").append(calendar.get(Calendar.YEAR)).append(", ").append(calendar.get(Calendar.HOUR_OF_DAY)).append(":").append(calendar.get(Calendar.MINUTE)).append(":").append(calendar.get(Calendar.SECOND)).append(" -> ");

            calendar.setTimeInMillis(listOfTimestamps.get(i)[1]);
            returned.append(calendar.get(Calendar.DAY_OF_MONTH)).append(".").append(calendar.get(Calendar.MONTH)).append(".").append(calendar.get(Calendar.YEAR)).append(", ").append(calendar.get(Calendar.HOUR_OF_DAY)).append(":").append(calendar.get(Calendar.MINUTE)).append(":").append(calendar.get(Calendar.SECOND)).append("<br>");

            sumOfSecondsOnParking = sumOfSecondsOnParking + ((listOfTimestamps.get(i)[1] - listOfTimestamps.get(i)[0])/1000);
        }

        long hourDelay = sumOfSecondsOnParking / 3600;
        long minuteDelay = (sumOfSecondsOnParking % 3600) / 60;
        long secDelay = (sumOfSecondsOnParking % 60) + 1;

        returned.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>SUMA NA PARKINGU:</b> ").append(hourDelay).append(":").append(minuteDelay).append(":").append(secDelay).append("<br><br>");

        return returned.toString();
    }

    // -----------------------------------

    public String getReportMostUsedPlacesContent(){
        StringBuilder returned = new StringBuilder("<b>10 najchętniej używanych miejsc:</b><br><br>");

        List<String> listOfPopularPlaces = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = Storage.archiveMostUsedPlaces.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            listOfPopularPlaces.add(entry.getValue() + " " + entry.getKey());
        }

        // sort list
        Collections.sort(listOfPopularPlaces, Collections.reverseOrder());

        int max;
        if (listOfPopularPlaces.size() < 10)
            max = listOfPopularPlaces.size();
        else
            max = 10;

        for (int i=0; i<max; i++){
            String [] split = listOfPopularPlaces.get(i).split(" ");
            returned.append("ID ").append(split[1]).append(" - ").append(split[0]).append(" razy<br>");
        }

        return returned.toString();
    }
}
