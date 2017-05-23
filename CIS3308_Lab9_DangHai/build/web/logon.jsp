<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page language="java" import="dbUtils.DbConn" %>
<%@page language="java" import="model.Customers.*" %> 


<jsp:include page="toHead.jsp"/>

<%
            // email and password (inside of userData) are both now ""
            StringData userData = new StringData(); 
        
            // last name error msg and age error msg (inside of userErrors) are both now ""
            StringData userErrors = new StringData();  
            
            // Still have a "form message" 
            String msg = ""; // this is an overall messsage (beyond field level validation)
            String temp ="";
            // still need to check for postback 
            if (request.getParameter("emailInputTag") != null) {
                // persist data from the URL
                userData.customerEmail = request.getParameter("emailInputTag");
                userData.customerPassword = request.getParameter("passwordInputTag");
                 
                //validate email is put in
                if(userData.customerEmail.length() == 0){
                    userErrors.customerEmail = "Email is required";
                }
               
                //validate password 
                if(userData.customerPassword.length() == 0){
                    userErrors.customerPassword = "Password is required";
                }
                
                String allErrors = userErrors.customerEmail + userErrors.customerPassword;

                //setup backend connection
                DbConn dbc = new DbConn();
                msg = dbc.getErr(); // formMsg will hold db connection error, if any
                temp = msg;
                if (msg.length() == 0) {
                    StringData foundUser = SearchCustomer.logonFind(userData.customerEmail, userData.customerPassword, dbc);
                    if (foundUser == null) {
                        msg = "User name and password not found.";
                        session.invalidate();
                    } else {
                        msg = foundUser.errorMsg; // formMsg will hold db error, e.g., sql error, if any
                        if (msg.length() == 0 && allErrors.length() == 0) {
                            // otherwise, it was a good logon. welcome the user...
                            msg = "Welcome " + foundUser.firstName + " " + foundUser.lastName
                                    + ". You are now logged on.";
                            session.setAttribute("user", foundUser);
                        } else {
                            msg = "Please try again.";
                        }
                    }
                } else {
                    msg = "Database unavailable, please try again later.<br/>" + temp;
                }
            }
        %>

<jsp:include page="headToContent.jsp"/>
                <div class="formTable">
                    <h1 style="text-align: center; color:white;">Log in</h1>
                    <form action="logon.jsp" method="post">
                        <label class="labelForm"> Please enter email address: </label>
                        <br/>
                        <input type="text" name="emailInputTag" value="timelord@gmail.com" class="inputForm"/> 
                        <span class="error"><%=userErrors.customerEmail%></span> 
                        <br/><br/>
                        <label class="labelForm">Please enter your password: </label>
                        <br/>
                        <input type = "password" name ="passwordInputTag" value="thisisgallifrey" class="inputForm"/>
                        <span class="error"><%=userErrors.customerPassword%></span>
                        <br/><br/>
                        <input type="submit" value="Login" class="formButton"/>
                        <br/><br/>
                        <%=msg%>
                    </form>
                </div>
<jsp:include page="postContent.jsp"/>