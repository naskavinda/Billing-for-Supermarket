package com.ruhuna.roject.supermarket.clientresponse;

import com.ruhuna.roject.supermarket.common.BaseUrl;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.core.MediaType;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/9/2018
 */
public class CrudOperator {
    public static <T> ClientResponse loadClientResponse(Class<T> className, String url) {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getClasses().add(className);
        clientConfig.getClasses().add(JacksonJsonProvider.class);

        Client client = Client.create(clientConfig);

        ClientResponse clientResponse = client.resource(BaseUrl.BASE_URL + url).accept(MediaType.APPLICATION_JSON)
                .header("content-type", MediaType.APPLICATION_JSON).get(ClientResponse.class);

        checkStatus(clientResponse);
        return clientResponse;
    }

    private static void checkStatus(ClientResponse clientResponse) {

    }

    public static void save(HttpServletRequest request, HttpServletResponse response, String url) {

        try {
            PrintWriter writer = response.getWriter();
            String jsn = request.getParameter("jsnobj").trim();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsn);
            org.json.simple.JSONObject job = (org.json.simple.JSONObject) obj;
            JSONArray jsnarr = (JSONArray) job.get("jsn");
            System.out.println("jsnarr : "+jsnarr);
            Client client = Client.create();
            WebResource webResource = client.resource(BaseUrl.BASE_URL + url);

            ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, jsnarr.remove(0).toString());

            if (clientResponse.getStatus() != 201) {
                System.out.println("Failed : HTTP error code : " + clientResponse.getStatus());

                String error = clientResponse.getEntity(String.class);
                writer.println("Error: " + error);
                return;
            }

            String output = clientResponse.getEntity(String.class);
            writer.println(output);
        } catch (ClientHandlerException | UniformInterfaceException | ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
