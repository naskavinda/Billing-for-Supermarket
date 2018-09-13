package com.ruhuna.roject.supermarket.data.load;

import com.ruhuna.roject.supermarket.clientresponse.CrudOperator;
import com.ruhuna.roject.supermarket.model.ItemMainType;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/9/2018
 */
@WebServlet(name = "LoadItemMainType",urlPatterns = {"/LoadItemMainType"})
public class LoadItemMainType extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        List<ItemMainType> itemMainTypes;

        try {

            ClientResponse clientResponse = CrudOperator.loadClientResponse(ItemMainType.class, "item_main_type/");
            System.out.println("clientResponse : "+clientResponse.toString());

            GenericType<List<ItemMainType>> genericType = new GenericType<List<ItemMainType>>() {
            };
            itemMainTypes = clientResponse.getEntity(genericType);
            if (itemMainTypes.isEmpty()) {
                writer.println("No Data");
            } else {
                itemMainTypes.stream().forEach(itemMainType -> System.out.println(itemMainType.getType()));
                writer.println(itemMainTypes.toString());
            }
        } catch (ClientHandlerException | UniformInterfaceException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
