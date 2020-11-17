/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.parkinglot.servlet;

import com.park.parkinglot.common.CarDetails.CarDetails;
import com.park.parkinglot.ejb.CarBean;
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
@WebServlet(name = "Cars", urlPatterns = {"/Cars"})
public class Cars extends HttpServlet {
           @Inject
           private CarBean carBean;
                   //ADMIN
    @Override
     
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {
         
         request.setAttribute("activePage",10);
          request.setAttribute("numberOfFreeParkingSpots","Cars");
          
          List<CarDetails>cars=carBean.getAllCars();
          request.setAttribute("cars",cars);
          
          request.getRequestDispatcher("/WEB-INF/pages/cars.jsp").forward(request,response);
         
         
     }
     }
   