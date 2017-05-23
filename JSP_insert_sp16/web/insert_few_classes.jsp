<%@page contentType="text/html" pageEncoding="UTF-8"%>  

<%@page language="java" import="dbUtils.DbConn" %>
<%@page language="java" import="java.sql.PreparedStatement" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Customer</title>
        <link href="mystyle.css" rel="stylesheet" type="text/css" />
        <style>
        </style>
    </head>
    <body>
        <%
            // Declare all Strings and objects as they should be for first rendering

            // both textboxes will be empty 1st rendering
            String strEmail = "";
            String strEmailMsg = "";

            // both error messages will be empty 1st rendering
            String strPassw = "";
            String strPasswMsg = "";

            // form message will be empty 1st rendering
            String formMsg = "";

            if (request.getParameter("email") != null) { // this is postback

                // Take user entered data from the URL and save this so the data will persist 
                // in the textboxes upon submit. See value attributes of <input> tags below.
                strEmail = request.getParameter("email");
                strPassw = request.getParameter("passw");

                // "validation" -- for this simple version, just make sure they entered something 
                // into each of the two fields.
                if (strEmail.length() == 0) {
                    strEmailMsg = "Email Address is required";
                }
                if (strPassw.length() == 0) {
                    strPasswMsg = "Password is required";
                }

                String allValidationErrors = strEmailMsg + strPasswMsg;
                if (allValidationErrors.length() == 0) { // pass validation, so proceed
                    
                    // Get db connection and make sure it worked.
                    DbConn dbc = new DbConn();
                    formMsg = dbc.getErr();
                    if (formMsg.length() == 0) { // DB connection is good

                        try {

                            String sql = "INSERT INTO customer (email_address, pwd) values (?,?)";
                            PreparedStatement pStatement = dbc.getConn().prepareStatement(sql);

                            // Encode string values into the prepared statement (wrapper class).
                            pStatement.setString(1, strEmail);
                            pStatement.setString(2, strPassw);

                            // here the UPDATE is actually executed
                            int numRows = pStatement.executeUpdate();
                            formMsg = numRows + " record successfully inserted !";

                        } catch (Exception e) {
                            formMsg = "Could not insert. Exception message: " + e.getMessage();
                        }
                    } // if db connection is good
                    dbc.close(); // no database connection leaks !
                    
                } else { // did not pass validation 
                    formMsg = "Please Try Again";
                }

            } // postback
        %>

        <jsp:include page="top.jsp" />

        <div id="content">

            <br/><br/>
            <h3>Insert Customer (few classes) - <span class='headerLink'><a href="customers.jsp">List All</a></span></h3>

            <form action ="insert_few_classes.jsp" method="get">

                <br/>
                Email Address
                <input type="text"  name="email" value="<%=strEmail%>"/>
                <span class="error"><%=strEmailMsg%> </span>

                <br/><br/><br/>
                Password
                <input type="password"  name="passw" value="<%=strPassw%>"/>
                <span class="error"><%=strPasswMsg%> </span>
                <br/><br/><br/>

                <input type="submit" value="Submit"/>
            </form>

            <br/><br/><br/>
            <strong><%=formMsg%></strong>  
        </div>
    </body>
</html>