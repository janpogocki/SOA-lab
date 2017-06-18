package com.parking.system;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Jan on 12.06.2017.
 */
@WebService()
public interface PlaceWSInterface {
    @WebMethod
    public void setOccupied(int id, String carID);

    @WebMethod
    public void setFree(int id);
}
