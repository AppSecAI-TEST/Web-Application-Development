<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!-- This form also "posts" to itself and it demonstrates
     the value attribute of the <input> tag.
 -->

<html>
    <head><title>Self posting JSP Page (demonstrates value attribute of input tag)</title></head>
    <body>
        <h2>Self posting JSP Page, use of input tag's value attribute</h2>

        <form action="02a_form_simple_with_values.jsp" method="get">
            Please enter your last name <input name="lastName" value="put your last name here"/>
            <br/>
            Please enter your age <input name ="age" value="don't forget to enter your age" />
            <br/><br/>
            <input type="submit"  value="OK">
        </form>
        <%
            out.println("<h3>Last Name is " + request.getParameter("lastName") + "</h3>");
            out.println("<h3>Age is " + request.getParameter("age") + "</h3>");
        %>

    </body>
</html>