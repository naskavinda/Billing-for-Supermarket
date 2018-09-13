package com.ruhuna.roject.supermarket.data.save;

import com.ruhuna.roject.supermarket.clientresponse.CrudOperator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/11/2018
 */
@WebServlet(name = "SaveItemMainType", urlPatterns = {"/SaveItemMainType"})
public class SaveItemMainType extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CrudOperator.save(request, response, "item_main_type/");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
