/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezwebservices;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Pradeep
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of ezwebservices.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        String ret = new String("{\n"
                + "    \"glossary\": {\n"
                + "        \"title\": \"example glossary\",\n"
                + "		\"GlossDiv\": {\n"
                + "            \"title\": \"S\",\n"
                + "			\"GlossList\": {\n"
                + "                \"GlossEntry\": {\n"
                + "                    \"ID\": \"SGML\",\n"
                + "					\"SortAs\": \"SGML\",\n"
                + "					\"GlossTerm\": \"Standard Generalized Markup Language\",\n"
                + "					\"Acronym\": \"SGML\",\n"
                + "					\"Abbrev\": \"ISO 8879:1986\",\n"
                + "					\"GlossDef\": {\n"
                + "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n"
                + "						\"GlossSeeAlso\": [\"GML\", \"XML\"]\n"
                + "                    },\n"
                + "					\"GlossSee\": \"markup\"\n"
                + "                }\n"
                + "            }\n"
                + "        }\n"
                + "    }\n"
                + "}");
        return ret;
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
