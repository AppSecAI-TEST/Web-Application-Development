<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>This JSP Page Receives the data (either Get or Post) and prints it </title>
    </head>
    <body>
        <h1>This JSP Page Receives the data (either Get or Post) and prints it </h1>
        <%
            out.println("<h1>Hello Mr or Ms " + request.getParameter("lastName")
                    + ", I see that you are " + request.getParameter("age") + " years old.</h1>");
        %>
    </body>
</html>