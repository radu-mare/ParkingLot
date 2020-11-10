/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.parkinglot.ejb;

import com.park.parkinglot.common.CarDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
//import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import javax.persistence.Query;

/**
 *
 * @author Admin
 */
@Stateless
public class CarBean {

    private static final Logger LOG = Logger.getLogger(CarBean.class.getName());
    @PersistenceContext
    private EntityManager em;

    public List<CarDetails> getAllCars() {
        LOG.info("getAllCars");
        try {
              Query query = em.createQuery("SELECT c FROM Car c");
        List<Car> cars = (List<Car>) query.getResultList();
        return copyCarsToDetails(cars);
            /*List<Car> cars = (List<Car>) em.createQuery("SELECT c FROM Car c").getResultList();
            return cars;*/
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
      
        
        

    private List<CarDetails> copyCarsToDetails(List<Car> cars) {
        List<CarDetails> detailsList = new ArrayList<>();
        for(Car car: cars){
            CarDetails carDetails= new CarDetails(car.getId(),
                    car.getLicensePlate(),
                    car.getParkingSpot(),
                    car.getUsername());
                     car.getUser().getUsername());
                    
                    detailsList.add(carDetails);
                    
            
        }
        return detailsList;

    }

    private void getLicensePlate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }

