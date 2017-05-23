<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head><title>Form with Persistence: Nulls Suppressed</title></head>

    <%
        String strLastName = "";
        String strAge = "";
        String msg = "";
        if (request.getParameter("lastName") != null) { // this is post back, persis user values
            strLastName = request.getParameter("lastName");
            strAge = request.getParameter("age");
            msg = "<h3>Last Name is " + strLastName + "</h3>"; 
            msg += "<h3>Age is " + strAge + "</h3>";
        }
    %>
    <body>
        <h1>Form with Persistence: Nulls Suppressed</h1>
        <form action="03b_form_nulls_suppressed.jsp" method="get">
            Please enter your last name 
            <input name="lastName" value="<%out.print(strLastName);%>"/>
            <br/>
            Please enter your age 
            <input name ="age" value="<%out.print(strAge);%>"/>
            <br/><br/>
            <input type="submit" value="click me"/>
        </form>
            <% out.print(msg); %>
            <%=msg%>  <!-- This is just shorthand for the above line (convenient and often used). -->
    </body>
</html>