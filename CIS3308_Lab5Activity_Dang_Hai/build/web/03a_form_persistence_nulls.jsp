<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!-- This form "posts" to itself  -->
<html>
    <head><title>Form with Persistent Values</title></head>

    <body>
        <h1>Form with Persistent Values: nulls showing</h1>
        <form action="03a_form_persistence_nulls.jsp" method="get">
            Please enter your last name 
            <input name="lastName" value="<%out.print(request.getParameter("lastName"));%>"/>
            <br/>
            Please enter your age 
            <input name ="age" value="<%out.print(request.getParameter("age"));%>"/>
            <br/><br/>
            <input type="submit" value="click me"/>
        </form>
    </body>
</html>