<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page language="java" import="view.*" %>
<%@page language="java" import="dbUtils.DbConn" %>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List All Users</title>
        <style>
            body {
                background-color: #F4F4F4; /* light gray */
                font-family: verdana, sans-serif;
            }
            .resultSet {
                background-color: #888888; /* dark grey shows thru between th and td */
                margin: auto; /* center table within its container */
            }
            .resultSet th {
                background-color: #608890;  /* dark green/blue */
                color: white;
                font-weight: bold;
                padding: 4px 6px;  /* top/bottom then left/right */
            }
            .resultSet td {
                background-color: #F0F8FF; /* light green/blue */
                padding: 2px 6px;  /* top/bottom then left/right */
            }
            h1, h2 {
                text-align:center;
            }
        </style>
    </head>
    <body>

        <%
            DbConn dbc = new DbConn();
            String msg = dbc.getErr(); // returns "" if connection is good, else error msg.
            if (msg.length() == 0) { // got open connection

                // returns a string that contains a HTML table with the db data in it
                // pass in the name of the CSS style that you want applied to the HTML 
                // table ("dependency injection") and pass in an open DbConn object.
                msg = customerView.listAllUsers("resultSet", dbc);
            }
            // PREVENT DB CONNECTION LEAKS (every code path that opens a db connection 
            // also must close it).
            dbc.close();            
        %>

        <h2>User List</h2>
        <% out.print(msg);%>

        <%System.out.print("This is test message to the server!!!");%>
    </body>
</html>