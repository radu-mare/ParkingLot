/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.parkinglot.servlet;

import com.park.parkinglot.common.CarDetails.CarDetails;
import com.park.parkinglot.common.CarDetails.UserDetails;
import com.park.parkinglot.ejb.CarBean;
import com.park.parkinglot.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EditCar", urlPatterns = {"/EditCar"})
public class EditCar extends HttpServlet {

     @Inject
    UserBean userBean;
    
    @Inject
    CarBean carBean;
    @Override
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       

        List<UserDetails> users = userBean.getAllUsers();
        request.setAttribute("users", users); 
        
        int carId=Integer.parseInt(request.getParameter("id"));
        CarDetails car = carBean.findById(carId);
        request.setAttribute("car",car);

        request.getRequestDispatcher("/WEB-INF/pages/editCar.jsp").forward(request, response);

    }
     
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String licensePlate=request.getParameter("license_plate");
          String parkingSpot=request.getParameter("parking_spot");
          Integer userId=Integer.parseInt(request.getParameter("owner_id"));
          Integer carId=Integer.parseInt(request.getParameter("car_id"));

          carBean.updateCar(carId, licensePlate,parkingSpot, userId);
           
          response.sendRedirect(request.getContextPath()+ "/Cars");
        
    }

}
