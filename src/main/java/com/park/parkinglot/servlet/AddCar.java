/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.parkinglot.servlet;

import com.park.parkinglot.common.CarDetails.UserDetails;
import com.park.parkinglot.ejb.CarBean;
import com.park.parkinglot.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "AdminRole"} ))
@WebServlet(name = "AddCar", urlPatterns = {"/AddCar"})
public class AddCar extends HttpServlet {

    @Inject
    UserBean userBean;
    
    @Inject
    CarBean carBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDetails> users = userBean.getAllUsers();
        request.setAttribute("users", users); 

        request.getRequestDispatcher("/WEB-INF/pages/addCar.jsp").forward(request, response);

    }
     
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String licensePlate=request.getParameter("license_plate");
        String parkingSpot=request.getParameter("parking_spot");
        int ownerId=Integer.parseInt(request.getParameter("owner_id"));

        carBean.createCar(licensePlate, parkingSpot, ownerId);
        
        response.sendRedirect(request.getContextPath()+ "/Cars");                                             

    }

}   
