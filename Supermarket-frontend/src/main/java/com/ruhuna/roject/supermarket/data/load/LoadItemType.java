package com.ruhuna.roject.supermarket.data.load;

import com.ruhuna.roject.supermarket.clientresponse.CrudOperator;
import com.ruhuna.roject.supermarket.model.ItemSubType;
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
 * Date  : 9/14/2018
 */
@WebServlet(name = "LoadItemType", urlPatterns = {"/LoadItemType"})
public class LoadItemType extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        List<ItemSubType> itemSubTypes;
        String id = request.getParameter("userId");

        try {

            ClientResponse clientResponse = CrudOperator.loadClientResponse(ItemSubType.class, "item_types/"+id);
            System.out.println("clientResponse : "+clientResponse.toString());

            GenericType<List<ItemSubType>> genericType = new GenericType<List<ItemSubType>>() {
            };
            itemSubTypes = clientResponse.getEntity(genericType);
            System.out.println("itemSubTypes "+itemSubTypes);
            if (itemSubTypes.isEmpty()) {
                writer.println("No Data");
            } else {
                itemSubTypes.stream().map(ItemSubType::getType).forEach(System.out::print);
                writer.println(itemSubTypes.toString());
            }
        } catch (ClientHandlerException | UniformInterfaceException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
