package com.parking.rest;

import com.parking.system.TicketService;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.*;
import java.io.StringReader;

/**
 * Created by Jan on 15.06.2017.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/ticket")
public class TicketRS {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }

    @POST
    @Produces("text/plain")
    @Consumes("application/json")
    public String sendPostData(String postData) {
        //String postData = _postData.replace("postData=", "");

        JsonReader reader = Json.createReader(new StringReader(postData));
        JsonObject jsonObject = reader.readObject();

        String carID = jsonObject.getString("carID");
        long startTime = Long.parseLong(jsonObject.getString("startTime"));
        long stopTime = Long.parseLong(jsonObject.getString("stopTime"));

        TicketService ticketService = new TicketService(carID, startTime, stopTime);

        return "Created new ticket: " + carID + " -- " + stopTime ;
    }
}
