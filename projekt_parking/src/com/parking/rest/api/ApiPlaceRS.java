package com.parking.rest.api;

import com.parking.system.Storage;

import javax.json.*;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan on 17.06.2017.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/api/place_rest/{id}")
public class ApiPlaceRS {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public String getClichedMessage(@PathParam("id") String id) {
        // Return some cliched textual content
        int free_places;
        JsonArrayBuilder listOfFreePlaces = Json.createArrayBuilder();

        if (id.equals("all")){
            free_places = 300 - Storage.listOfPlaces.size();

            for (int i=100; i<400; i++){
                if (Storage.findPlaceByPlaceID(i) == -1)
                    listOfFreePlaces.add(i);
            }
        }
        else {
            int idInt = Integer.parseInt(id) * 100;
            free_places = 0;

            for (int i=idInt; i<idInt+100; i++){
                if (Storage.findPlaceByPlaceID(i) == -1) {
                    listOfFreePlaces.add(i);
                    free_places++;
                }
            }
        }

        JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
                .add("free_places", free_places)
                .add("free_places_id_array", listOfFreePlaces);

        JsonObject jsonObject = objectBuilder.build();

        try (Writer writer = new StringWriter()) {
            Json.createWriter(writer).write(jsonObject);
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Error";
    }
}
