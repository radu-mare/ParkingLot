<%-- 
    Document   : menu
    Created on : Nov 17, 2020, 12:59:38 PM
    Author     : Admin
--%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top" >
  <a class="navbar-brand" href="${pageContext.request.contextPath}">Parking lot</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
          <li class="nav-item active ${pageContext.request.requestURI eq 'Cars' ? ' active' : ''}">
        <a class="nav-link" href="${pageContext.request.contextPath}/Cars">Cars <span class="sr-only">(current)</span></a>
      </li>
         <li class="nav-item active ${pageContext.request.requestURI eq 'Users' ? ' active' : ''}">
        <a class="nav-link" href="${pageContext.request.contextPath}/Users">Users <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active ${pageContext.request.requestURI eq '/ParkingLot/about.jsp' ? ' active' : ''}">
        <a class="nav-link" href="${pageContext.request.contextPath}/about.jsp">About <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="${pageContext.request.contextPath}" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="${pageContext.request.contextPath}">Action</a>
          <a class="dropdown-item" href="${pageContext.request.contextPath}">Another action</a>
          <a class="dropdown-item" href="${pageContext.request.contextPath}">Something else here</a>
        </div>
      </li>
    </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a><!-- comment -->
            </li>
        </ul>
 
          <%--   <form class="form-inline my-2 my-lg-0">    
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>    --%>
  </div>
</nav>   
