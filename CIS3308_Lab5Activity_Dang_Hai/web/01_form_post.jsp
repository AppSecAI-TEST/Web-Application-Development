<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- This form also sends data to a different JSP page using the Post
     method (see form attribute).  The only difference is that you 
     see the inputs in the URL (have a look!).
     Whenever a submit button (inside a form) is pressed, all of the 
     form inputs are sent to whatever URL is listed in the form's
     action attribute.   -->
<html>
    <head>
        <title>Sending Data to Another JSP Page Using the POST method</title>
    </head>
    <body>
        <h1>Sending Data to Another JSP Page Using the POST method</h1>
        <form action="01_receive_parameters.jsp" method="post">
            Please enter your last name <input name="lastName"/>
            <br/>
            Please enter your age <input name ="age" />
            <br/>
            <input type="submit"  value="OK">
        </form>
    </body>
</html>