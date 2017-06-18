package com.parking.rest;

import com.parking.jms.Storage;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created by Jan on 17.06.2017.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/controller/mobile/{id}")
public class MobileMessagesRS {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage(@PathParam("id") String id) {
        // Return some cliched textual content

        return Storage.getMessages(id);
    }
}
