<%@page import="model.Purchase.StringDataList"%>
<%@page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@page language="java" import="com.google.gson.*" %>
<%@page language="java" import="dbUtils.*" %>

<%
    StringDataList purchaseList = new StringDataList(0); // Empty country list with no db error.
    
    DbConn dbc = new DbConn();
    purchaseList.dbError = dbc.getErr(); // returns "" if connection is good, else db error msg.
    // This will hold the id values
    int valId1 = 0;
    int valId2 = 0;
    if (purchaseList.dbError.length() == 0) { // got open connection
        
        String email = request.getParameter("email");
        if (email == null) {
            email="";
        }
        String spaceship = request.getParameter("spaceship");
        if (spaceship == null) {
            spaceship="";
        }
        String startDate = request.getParameter("lowDate");
        String endDate = request.getParameter("highDate");


        // purchaseList is an object with an array of country objects inside, 
        // plus a possible dbError.
        System.out.println("jsp page ready to search for purchase with email: " 
                + email + " spaceship: " + spaceship + " startDate: " + startDate + " endDate: " + endDate);
        
        boolean flag = false;
        try{
            valId1 = Integer.parseInt(email);
            valId2 = Integer.parseInt(spaceship);
            flag = true;
        }catch(Exception e){
            flag = false;
            System.out.print("Error casting input picklist values to integers: " + e);
        }
        
        if(flag){
            purchaseList = view.purchaseView.getPurchaseList(dbc, valId1, valId2, startDate, endDate);
        }
    } 
    
    // PREVENT DB connection leaks:
    dbc.close(); // EVERY code path that opens a db connection, must also close it.
    
    Gson gson = new Gson();
    out.print(gson.toJson(purchaseList).trim());
%>