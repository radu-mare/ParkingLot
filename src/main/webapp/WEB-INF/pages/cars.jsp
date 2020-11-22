<%-- 
    Document   : cars.jsp
    Created on : Nov 10, 2020, 8:08:57 AM
    Author     : Admin
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle ="Cars">
    <h1>Cars</h1>


    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddCar" role="button">Add Car</a>




    <c:forEach var="car" items="${cars}" varStatus="status">
        <div class ="row">
            <div class ="col-md-3">
                ${car.licensePlate}  

            </div> 
            <div class ="col-md-3">
                ${car.parkingSpot}  

            </div>
            <div class ="col-md-3">
                ${car.username}    

            </div>
            <div class ="col-md-3">

                <a  class="btn btn-secondary" href="${pageContext.request.contextPath}/EditCar?id=${car.id}" role="button">Edit Car</a>
            </div>

        </div>




    </c:forEach>  
    <h5>Free parking spots: ${numberOfFreeParkingSpots}</h5>  



</t:pageTemplate>


