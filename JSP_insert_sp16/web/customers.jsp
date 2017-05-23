<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page language="java" import="dbUtils.DbConn"%> 
<%@page language="java" import="model.customer.*"%>  
<%@page language="java" import="view.CustomerView"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Customer List</title>
        <link href="mystyle.css" rel="stylesheet" type="text/css" />
        <style>
        </style>
    </head>
    <body> 

        <%

            DbConn dbc = new DbConn();
            String formMsg = dbc.getErr();
            if (formMsg.length() == 0) {
                formMsg = CustomerView.customersByName("tableCSS", dbc);
            } // database connection ok or not
            dbc.close(); // close the db connection (THIS ONE IMPORTANT-no leaks!)
        %>

        <jsp:include page="top.jsp" />

        <div id="content">

            <div style="margin:auto; text-align:center;">
                <br/>
                <h3>Customer List
                    - <span class='headerLink'><a href="insert.jsp">Insert (classes)</a></span>
                    - <span class='headerLink'><a href="insert_few_classes.jsp">Insert (few classes)</a></span>
                </h3>

                <br/>
                <%=formMsg%> 
            </div>
            
        </div> 
    </body>
</html>