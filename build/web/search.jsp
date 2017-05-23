<%-- 
    Document   : search
    Created on : Feb 6, 2017, 12:15:09 AM
    Author     : Hai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="view.*" %>
<%@page language="java" import="dbUtils.*" %>
<%

        // Strings to specify how to make the email select tag 
        String emailSelectTagName = "email";
        String emailSelectSql = "select customer_id, cus_loginName from sp17_3308_tug25055.customer order by cus_loginName";
        String emailFirstOption = "<option value='0'>Select User</option>";
        
        // This string will hold the generated email select tag
        String emailSelectTag = ""; // empty string unless we can get a good db connection.
        
        // This string will hold the value picked by the user  
        String userSelectedValue = ""; 
  
       
        // This string will hold the generated spaceship select tag
        String spaceShipName = ""; // empty string unless we can get a good db connection.
        
        // Strings to specify how to make the spaceship select tag 
        String spaceshipSelectTagName2 = "spaceship";
        String spaceshipSelectSql2 = "select spaceship_id, modelName from  sp17_3308_tug25055.spaceship order by modelName";
        String spaceshipFirstOption2 = "<option value='0'>Select User</option>"; 
        
        // This string will hold the value picked by the user  
        String userSelectedValue2 = ""; 
        
        
        // This will hold the date values typed in by user
        String strLowDate = "";
        String strHighDate = "";
        
        // This will hold the id values
        int valId1 = 0;
        int valId2 = 0;
        
        //Creat DBC connection
        DbConn dbc = new DbConn();
        String msg = dbc.getErr();
        if (msg.length() == 0) {
            
            // This will be the select tag for first rendering (nothing pre-selected) 
            emailSelectTag = MakeTags.makeSelectTag(dbc, emailSelectTagName, emailSelectSql,
                    emailFirstOption, userSelectedValue);

            // This will be the select tag for first rendering (nothing pre-selected) 
            spaceShipName = MakeTags.makeSelectTag(dbc, spaceshipSelectTagName2, spaceshipSelectSql2,
                    spaceshipFirstOption2, userSelectedValue2);
            
            // Postback - persist user entered values
            if (request.getParameter("lowDate") != null || request.getParameter("highDate") != null) {
                strLowDate = request.getParameter("lowDate");
                strHighDate = request.getParameter("highDate");
                
                //Email
                userSelectedValue = request.getParameter(emailSelectTagName);
                // Here you have to recreate the emailSelectTag, passsing in a new parameter 
                // that shows what the user has already selected -- so the select tag persists.
                emailSelectTag = MakeTags.makeSelectTag(dbc, emailSelectTagName, emailSelectSql,
                    emailFirstOption, userSelectedValue);
                
                //Spaceship
                userSelectedValue2 = request.getParameter(spaceshipSelectTagName2);
                // Here you have to recreate the spaceshipSelectTag, passsing in a new parameter 
                // that shows what the user has already selected -- so the select tag persists.
                spaceShipName = MakeTags.makeSelectTag(dbc, spaceshipSelectTagName2, spaceshipSelectSql2,
                    spaceshipFirstOption2, userSelectedValue2);
            }
            
            boolean flag = false;
            try{
                valId1 = Integer.parseInt(userSelectedValue);
                valId2 = Integer.parseInt(userSelectedValue2);
                flag = true;
            }catch(Exception e){
                flag = false;
                System.out.print("Error casting input picklist values to integers: " + e);
            } 
            
            if(flag){
                msg = purchaseView.search("resultSet", dbc, valId1, valId2, strLowDate, strHighDate);
            }
        } else {
            msg = "Error establishing database connection.";
        }  
    %>
    
<jsp:include page="toHead.jsp"/>
<jsp:include page="headToContent.jsp"/>
            <h2 style="text-align: center; color:white;">Search Activity Form</h2>
            <form action="search.jsp" method="get" class="inputTable">
                Show purchases made by user
                <%=emailSelectTag%>
                <br/><br/>
                Show product
                <%=spaceShipName%>
                <br/><br/>
                Date range between 
                <input type="text" name="lowDate" value="<%=strLowDate%>" placeholder="YYYY/DD/MM"/> and 
                <input type="text" name="highDate" value="<%=strHighDate%>" placeholder="YYYY/DD/MM"/>
                <br/><br/>
                <input type="submit" value="Search"/>
            </form>
                
            <br/><br/>
            <% out.print(msg);%>
            
            
<jsp:include page="postContent.jsp"/>