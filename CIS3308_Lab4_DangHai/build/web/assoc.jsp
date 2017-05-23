<%-- 
    Document   : buys
    Created on : Feb 6, 2017, 12:13:47 AM
    Author     : Hai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page language="java" import="view.*" %>
<%@page language="java" import="dbUtils.DbConn" %>

<jsp:include page="toHead.jsp"/>
<jsp:include page="headToContent.jsp"/>

<h1 style="text-align: center">Transactions List</h1>
        <%
            DbConn dbc = new DbConn();
            String msg = dbc.getErr(); // returns "" if connection is good, else error msg.
            if (msg.length() == 0) { // got open connection

                // returns a string that contains a HTML table with the db data in it
                // pass in the name of the CSS style that you want applied to the HTML 
                // table ("dependency injection") and pass in an open DbConn object.
                msg = purchaseView.listAllUsers("resultSet", dbc);
            }
            // PREVENT DB CONNECTION LEAKS (every code path that opens a db connection 
            // also must close it).
            dbc.close();            
        %>

        <% out.print(msg);%>
<jsp:include page="postContent.jsp"/>