<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!-- This form "posts" to itself. 
     Although the method is get (for educational reasons, 
     so you can actually see the user input in the Browser URL), 
     functionally, it is the same, so we say "the form posts to itself". -->

<html>
    <head><title>JSP Page That Posts to Itself</title></head>
    <body>
        <h1>JSP Page That Posts to Itself</h1>

        <form action="02_form_simple.jsp" method="get">
            Please enter your last name <input name="lastName"/>
            <br/>
            Please enter your age <input name ="age" />
            <br/><br/>
            <input type="submit"  value="OK">
        </form>
        <%
            out.println("<h3>Last Name is " + request.getParameter("lastName") + "</h3>");
            out.println("<h3>Age is " + request.getParameter("age") + "</h3>");
        %>

    </body>
</html>