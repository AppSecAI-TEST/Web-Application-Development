<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="model.yourTableName.StringData"%> 

<!DOCTYPE html>

<html>
    <head>
        <title>Simple Validation</title>
        <style>
            .error {
                color:red;
            }
        </style>
    </head>

    <%
        /* replace this...
            String strLastName = "";
            String strAge = "";
            String lastNameErrorMsg = ""; // be optimistic
            String ageErrorMsg = ""; // dont show an error upon 1st rendering

        with this: */
        
        // last name & age (inside of userData) are both now ""
        StringData userData = new StringData(); 
        
        // last name error msg and age error msg (inside of userErrors) are both now ""
        StringData userErrors = new StringData();  

        // Still have a "form message" 
        String msg = ""; // this is an overall messsage (beyond field level validation)
        
        // still need to check for postback 
        if (request.getParameter("lastNameInputTag") != null) { 
            
            // persist data from the URL
            userData.lastName= request.getParameter("lastNameInputTag");
            userData.age = request.getParameter("ageInputTag");
            
            // validate the name
            if (userData.lastName.length() == 0) {
                userErrors.lastName = "Last Name is required.";
            }
                        
            // validate the age
            try {
                int i = Integer.parseInt(userData.age);
            } catch (Exception e) {
                userErrors.age = "Please enter a whole number for age.";
            }
            
            // set the form message
            String allErrors = userErrors.lastName + userErrors.age;
            if (allErrors.length() == 0) {
                msg = "Congratulations for filling out the form sucessfully.";
            } else {
                msg = "Please try again.";
            }
        }

    %>
    <body>
        <h2>Simple Validation: last name is required, age must be a whole number</h2>
        <form action="05_validate_StringData.jsp" method="get">
            Please enter your last name 
            <input name="lastNameInputTag" value="<%=userData.lastName%>"/> 
            <span class="error"><%=userErrors.lastName%></span> 
            <br/><br/>
            Please enter your age 
            <input name ="ageInputTag" value="<%=userData.age%>"/>
            <span class="error"><%=userErrors.age%></span>
            <br/><br/>
            <input type="submit" value="click me"/>
            <br/><br/>
            <%=msg%>
        </form>
    </body>
</html>
