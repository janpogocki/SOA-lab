package com.parking.system;

/**
 * Created by Jan on 12.06.2017.
 */
public class TicketService {
    // temporary ticket constructor
    public TicketService(String carID, long startTime){
        Ticket ticket = new Ticket(carID, startTime, startTime+(10*1000));
        Storage.listOfTickets.add(ticket);
    }

    public TicketService(String carID, long startTime, long stopTime){
        Ticket ticket = new Ticket(carID, startTime, stopTime);
        int ticketID = Storage.findTicketByCarID(carID);

        if (ticketID != -1)
            Storage.listOfTickets.set(ticketID, ticket);
        else
            Storage.listOfTickets.add(ticket);
    }
}
