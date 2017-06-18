package com.parking.apisoap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Jan on 17.06.2017.
 */
@WebService()
public interface ApiPlaceWSInterface {
    @WebMethod
    public int freePlaces(String id);

    @WebMethod
    public List<Integer> freePlacesList(String id);
}
