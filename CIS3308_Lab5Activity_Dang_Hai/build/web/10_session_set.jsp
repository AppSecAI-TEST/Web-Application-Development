<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Session</title>
    </head>
    <%

        // Declare & initialize values to be displayed on the page
        String strLastName = "";
        String msg = ""; // this is an overall messsage (beyond field level validation)
        
        // check for postback
        if (request.getParameter("lastName") != null) {
            
            // this is postback...
            strLastName = request.getParameter("lastName");
            
            // whatever the user entered, put it into the JSP session object
            session.setAttribute("userLastName", strLastName);
            msg = strLastName + " has been written to the JSP session object"; 
        }

    %>
    <body>
        <h2>How to set the JSP Session Object</h2>
        <h4 style="text-align: right; margin-top: -32px;">
            <a href="10_session_set.jsp">Set</a>
            | 
            <a href="11_session_get.jsp">Get</a>
        </h4>
        <form action="10_session_set.jsp" method="get">
            Please enter your last name (this will be put into the JSP session)
            <input name="lastName" value="<%out.print(strLastName);%>"/> 
            <br/><br/>
            <input type="submit" value="click me"/>
            <br/><br/>
            <%=msg%>
        </form>
    </body>
</html>
