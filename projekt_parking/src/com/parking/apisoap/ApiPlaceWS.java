package com.parking.apisoap;
import com.parking.system.Storage;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan on 17.06.2017.
 */
@WebService()
public class ApiPlaceWS implements ApiPlaceWSInterface {
  @WebMethod
  public int freePlaces(String id) {
    if (id.equals("all")){
      return 300 - Storage.listOfPlaces.size();
    }
    else {
      List<Integer> listOfFreePlaces = new ArrayList<>();
      int idInt = Integer.parseInt(id) * 100;

      for (int i=idInt; i<idInt+100; i++){
        if (Storage.findPlaceByPlaceID(i) == -1)
          listOfFreePlaces.add(i);
      }

      return 100 - listOfFreePlaces.size();
    }
  }

  @WebMethod
  public List<Integer> freePlacesList(String id){
    List<Integer> listOfFreePlaces = new ArrayList<>();

    if (id.equals("all")){
      for (int i=100; i<400; i++){
        if (Storage.findPlaceByPlaceID(i) == -1)
          listOfFreePlaces.add(i);
      }
    }
    else {
      int idInt = Integer.parseInt(id) * 100;

      for (int i=idInt; i<idInt+100; i++){
        if (Storage.findPlaceByPlaceID(i) == -1)
          listOfFreePlaces.add(i);
      }
    }

    return listOfFreePlaces;
  }
}
