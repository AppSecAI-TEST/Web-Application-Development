<%@page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%> 

<%@page language="java" import="com.google.gson.*" %>

<%@page language="java" import="dbUtils.*" %>
<%@page language="java" import="view.CountryFlagView" %>
<%@page language="java" import="model.CountryFlag.StringDataList" %>

<%
    StringDataList countryFlagList = new StringDataList(0); // Empty country list with no db error.
    
    DbConn dbc = new DbConn();
    countryFlagList.dbError = dbc.getErr(); // returns "" if connection is good, else db error msg.
    
    if (countryFlagList.dbError.length() == 0) { // got open connection
        
        String countryNameStartsWith = request.getParameter("q");
        if (countryNameStartsWith == null) {
            countryNameStartsWith="";
        }

        // countryFlagList is an object with an array of country objects inside, 
        // plus a possible dbError.
        System.out.println("jsp page ready to search for country with "+countryNameStartsWith);
        countryFlagList = view.CountryFlagView.getCountryFlagList(countryNameStartsWith, dbc);
    } 
    
    // PREVENT DB connection leaks:
    dbc.close(); // EVERY code path that opens a db connection, must also close it.
    
    Gson gson = new Gson();
    out.print(gson.toJson(countryFlagList).trim());
%>