<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page language="java" import="dbUtils.*" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Simple Validation</title>
        <style>
            body {
                background-color:#CCCCCC;
                font-size: 14px;
                font-family:arial;
            }
        </style>
    </head>

    <%

        // Strings to specify how to make the email select tag 
        String emailSelectTagName = "email";
        String emailSelectSql = "select customer_id, cus_loginName from sp17_3308_tug25055.customer order by cus_loginName";
        String emailFirstOption = "<option value='0'>Select User</option>";
        
        // This string will hold the generated email select tag
        String emailSelectTag = ""; // empty string unless we can get a good db connection.
        
        // This string will hold the value picked by the user  
        String userSelectedValue = ""; 
  
        String strAmtSpentMin = "";
        
        DbConn dbc = new DbConn();
        String msg = dbc.getErr();
        if (msg.length() == 0) {
            
            // This will be the select tag for first rendering (nothing pre-selected) 
            emailSelectTag = MakeTags.makeSelectTag(dbc, emailSelectTagName, emailSelectSql,
                    emailFirstOption, userSelectedValue);

            // Postback - persist user entered values
            if (request.getParameter("amtSpentMin") != null) {
                strAmtSpentMin = request.getParameter("amtSpentMin");
                userSelectedValue = request.getParameter(emailSelectTagName);
                // Here you have to recreate the emailSelectTag, passsing in a new parameter 
                // that shows what the user has already selected -- so the select tag persists.
                emailSelectTag = MakeTags.makeSelectTag(dbc, emailSelectTagName, emailSelectSql,
                    emailFirstOption, userSelectedValue);
            }
        }
        
        
        // This string will hold the generated email select tag
        String emailSelectTag2 = ""; // empty string unless we can get a good db connection.
        
        // This string will hold the value picked by the user  
        String userSelectedValue2 = ""; 
        String emailSelectTagName2 = "spaceship";
        String emailSelectSql2 = "select spaceship_id, modelName from  sp17_3308_tug25055.spaceship order by modelName";
        String emailFirstOption2 = "<option value='0'>Select User</option>";
        
        if (msg.length() == 0) {
            // This will be the select tag for first rendering (nothing pre-selected) 
            emailSelectTag2 = MakeTags.makeSelectTag(dbc, emailSelectTagName2, emailSelectSql2,
                    emailFirstOption2, userSelectedValue2);

            // Postback - persist user entered values
            if (request.getParameter("amtSpentMin") != null) {
                strAmtSpentMin = request.getParameter("amtSpentMin");
                userSelectedValue2 = request.getParameter(emailSelectTagName2);
                // Here you have to recreate the emailSelectTag, passsing in a new parameter 
                // that shows what the user has already selected -- so the select tag persists.
                emailSelectTag2 = MakeTags.makeSelectTag(dbc, emailSelectTagName2, emailSelectSql2,
                    emailFirstOption2, userSelectedValue2);
            }
        }

    %>
    <body>
        <h2>Search Activity (Starter Concepts)</h2>
        <form action="searchStarter.jsp" method="get">
            Show purchases where amount spent was over  
            <input name="amtSpentMin" value="<%=strAmtSpentMin%>"/> 
            <br/><br/>
            Show purchases made by user
            <%=emailSelectTag%>
            <br/><br/>
            Show product
            <%=emailSelectTag2%>
            <br/><br/>
            <input type="submit" value="click me"/>
        </form>
        <br/><br/>
        <%=msg%>
    </body>
</html>