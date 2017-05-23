<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@page language="java" import="dbUtils.DbConn" %>
<%@page language="java" import="model.customer.*" %>

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
            // Declare all Strings and objects as they should be if it is first rendering
            StringData inputData = new StringData(); // all properties empty string, good for first rendering
            StringData errorMsgs = new StringData(); // all properties empty string, good for first rendering

            if (request.getParameter("emailAddressInput") != null) { // this is postback

                // package up Customer String data
                inputData.emailAddress = request.getParameter("emailAddressInput");
                inputData.pwd = request.getParameter("pwdInput");
                inputData.pwd2 = request.getParameter("pwd2Input");
                inputData.firstName = request.getParameter("firstNameInput");
                inputData.lastName = request.getParameter("lastNameInput");
                inputData.creditLimit = request.getParameter("creditLimitInput");

                // Get db connection and make sure it worked.
                DbConn dbc = new DbConn();
                errorMsgs.errorMsg = dbc.getErr();
                if (errorMsgs.errorMsg.length() == 0) { // DB connection is good
                    errorMsgs = DbMods.insert(inputData, dbc); // errorMsgs will hold all validation messags
                    if (errorMsgs.errorMsg.length() == 0) { // this is the form level error message
                        // replace empty string with successful message
                        errorMsgs.errorMsg = "Record successfully inserted !";
                    }
                } // if db connection is good

                dbc.close(); // no database connection leaks !
            } // postback
        %>

        <jsp:include page="top.jsp" />

        <div id="content">
            <h3>Insert Customer - <span class='headerLink'><a href="customers.jsp">List All</a></span></h3>

            <form action ="insert.jsp" method="get">
                <table>
                    <tr>
                        <td>Email Address</td>
                        <td><input type="text"  name="emailAddressInput" value="<%=inputData.emailAddress%>"/></td>
                        <td class="error"><%=errorMsgs.emailAddress%></td> 
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password"  name="pwdInput" value="<%=inputData.pwd%>"/></td>
                        <td class="error"><%=errorMsgs.pwd%></td>
                    </tr>
                    <tr>
                        <td>Retype Your Password</td>
                        <td><input type="password" name="pwd2Input" value="<%=inputData.pwd2%>"/></td>
                        <td class="error"><%=errorMsgs.pwd2%></td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstNameInput" value="<%=inputData.firstName%>"/></td>
                        <td class="error"><%=errorMsgs.firstName%></td> 
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastNameInput" value="<%=inputData.lastName%>"/></td>
                        <td class="error"><%=errorMsgs.lastName%></td>
                    </tr>

                    <tr>
                        <td>Credit Limit</td>
                        <td><input type="text" name="creditLimitInput" value="<%=inputData.creditLimit%>"/></td>
                        <td class="error"><%=errorMsgs.creditLimit%></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="text-align:center;"><input type="submit" value="Submit"/></td>
                        <td class="error"></td>
                    </tr>
                </table>
            </form>
            <br/>
            <strong><%=errorMsgs.errorMsg%></strong>  
        </div>
    </body>
</html>