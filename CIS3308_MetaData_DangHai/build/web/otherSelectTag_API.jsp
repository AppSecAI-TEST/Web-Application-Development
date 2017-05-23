<%@page import="view.spaceshipView"%>
<%@page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%> 

<%@page language="java" import="com.google.gson.*" %>
<%@page language="java" import="dbUtils.*" %>

<%
    /* 
    Note (in the 1st line of this file) that Web API JSP pages have a different contentType 
    (application/json). A JSP page would have contentType "text/html"

    The com.google.gson import line (line 3 above) references the GSON that should 
    have been added as a jar file to your project Libraries. 
    */
    SelectOptionList spaceshipList = new SelectOptionList();

     DbConn dbc = new DbConn();
    String msg = dbc.getErr(); // returns "" if connection is good, else error msg.
    if (msg.length() == 0) { // got open connection
        spaceshipList = spaceshipView.getSpaceShipJson(dbc);
    }
    // PREVENT DB CONNECTION LEAKS (every code path that opens a db connection 
    // also must close it).
    dbc.close();            

   
    Gson gson = new Gson();
    out.print(gson.toJson(spaceshipList).trim());
%>