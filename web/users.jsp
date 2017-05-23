<%-- 
    Document   : customer
    Created on : Feb 6, 2017, 12:10:40 AM
    Author     : Hai
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page language="java" import="view.*" %>
<%@page language="java" import="dbUtils.DbConn" %>
<%@page import="model.Customers.DbCusMods"%>
<%@page import="model.Customers.StringData"%>

<jsp:include page="toHead.jsp"/>
<jsp:include page="headToContent.jsp"/>

<h1 style="text-align: center">Customers List</h1>
<h2 style="text-align: center"><a href="insertUser.jsp">Create an Account</a></h2>
        <%
            StringData inputData = new StringData(); // all properties empty string, good for first rendering
            StringData errorMsgs = new StringData(); // all properties empty string, good for first rendering

            String deleteId = request.getParameter("deleteId");
            if(request.getParameter("deleteId") != null && request.getParameter("deleteId") != ""){
                inputData.customerId = deleteId;
            }
            
            
            DbConn dbc = new DbConn();
            String msg = dbc.getErr(); // returns "" if connection is good, else error msg.
            
            if (msg.length() == 0) { // got open connection
                        errorMsgs.errorMsg = dbc.getErr();

                        if (errorMsgs.errorMsg.length() == 0) {
                            // DB connection is good
                            errorMsgs = DbCusMods.delete(inputData, dbc); // errorMsgs will hold all validation messags
                            if (errorMsgs.errorMsg.length() == 0) { // this is the form level error message
                                // replace empty string with successful message
                                errorMsgs.errorMsg = "Record successfully deleted !";
                            }
                        } // if db connection is good
                // returns a string that contains a HTML table with the db data in it
                // pass in the name of the CSS style that you want applied to the HTML 
                // table ("dependency injection") and pass in an open DbConn object.
                msg = customerView.listWithDelete("resultSet", dbc);
                msg += " " + errorMsgs.errorMsg;
            } else {
                msg = "Error establishing database connection.";
                errorMsgs.errorMsg = msg;
            } 
            // PREVENT DB CONNECTION LEAKS (every code path that opens a db connection 
            // also must close it).
            dbc.close();            
        %>

        <% out.print(msg);%>
<jsp:include page="postContent.jsp"/>