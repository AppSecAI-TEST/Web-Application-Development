<%@page import="model.yourTableName.StringData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Session</title>
    </head>
    <%

        // Extract the value from the JSP session object. 
        // You must use the same "key value" (e.g., "userLastName") as 
        // when you put the value into the session (from the other JSP page).
        // session.getAttribute() returns an object, so type cast it to the 
        // type that you need it to be.
        StringData strDataStuff = (StringData) session.getAttribute("userDataStuff");

        String msg = strDataStuff.toString() + " was just extracted from the JSP session object";

    %>
    <body>
        <h2>How to set the JSP Session Object</h2>
        
        <h4 style="text-align: right; margin-top: -32px;">
            <a href="20_session_set.jsp">Set</a>
            | 
            <a href="21_session_get.jsp">Get</a>
        </h4>

        <%=msg%>

    </body>
</html>
