package com.parking.system;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan on 12.06.2017.
 */
@WebService()
public class PlaceWS implements PlaceWSInterface {
  @WebMethod
  public void setOccupied(int id, String carID){
      long currentTime = System.currentTimeMillis();

      //create temporary ticket
      TicketService ticketService = new TicketService(carID, currentTime);

      Place place = new Place(id, currentTime, carID);

      if (Storage.findPlaceByPlaceID(id) == -1){
          // not exists
          Storage.listOfPlaces.add(place);
      }
      else {
          Storage.listOfPlaces.set(Storage.findPlaceByPlaceID(id), place);
      }
  }

  @WebMethod
  public void setFree(int id){
      int placeInList = Storage.findPlaceByPlaceID(id);

      if (placeInList != -1) {
          String carID = Storage.listOfPlaces.get(placeInList).getCarID();
          Storage.listOfPlaces.remove(Storage.findPlaceByPlaceID(id));

          // move ticket to archive
          Ticket movedTicket = Storage.listOfTickets.get(Storage.findTicketByCarID(carID));
          Storage.listOfTickets.remove(movedTicket);

          Long[] newEntry = new Long[2];
          newEntry[0] = movedTicket.getStartTime();
          newEntry[1] = System.currentTimeMillis();

          if (Storage.archiveListOfTickets.containsKey(movedTicket.getCarID())) {
              // juz posiadamy taka rejestracje
              Storage.archiveListOfTickets.get(movedTicket.getCarID()).add(newEntry);
          } else {
              List<Long[]> list = new ArrayList<>();
              list.add(newEntry);
              Storage.archiveListOfTickets.put(movedTicket.getCarID(), list);
          }

          // increment counter of most used places
          if (Storage.archiveMostUsedPlaces.containsKey(id)) {
              // posiadamy to miejsce w bazie
              Storage.archiveMostUsedPlaces.replace(id, Storage.archiveMostUsedPlaces.get(id) + 1);
          } else {
              Storage.archiveMostUsedPlaces.put(id, 1);
          }
      }
  }
}
