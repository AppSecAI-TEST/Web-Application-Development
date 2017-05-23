<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page language="java" import="dbUtils.DbConn" %>
<%@page language="java" import="model.Purchase.*" %> 
<%@page language="java" import="dbUtils.*" %> 


        <%
            // Declare all Strings and objects as they should be if it is first rendering
            StringData inputData = new StringData(); // all properties empty string, good for first rendering
            StringData errorMsgs = new StringData(); // all properties empty string, good for first rendering

            // This string will hold the generated email select tag
            String spaceshipSelectTag = ""; // empty string unless we can get a good db connection.

            // Strings to specify how to make the email select tag 
            String spaceshipSelectTagName = "spaceship";
            String spaceshipSelectSql = "select spaceship_id, modelName from  sp17_3308_tug25055.spaceship order by modelName";
            String spaceshipFirstOption = "<option value='0'>Select User Type</option>";

            // This string will hold the value picked by the user  
            String userSelectedValue = ""; 

            //This will hold the message telling if a user is logged in or not
            String loginMsg = "";
            //Create DBC connection
            DbConn dbc = new DbConn();
            String msg = dbc.getErr();
            if (msg.length() == 0) {
                
                // This will be the select tag for first rendering (nothing pre-selected) 
                spaceshipSelectTag = MakeTags.makeSelectTag(dbc, spaceshipSelectTagName, spaceshipSelectSql,
                        spaceshipFirstOption, userSelectedValue);

                // Postback - persist user entered values
                if (request.getParameter("customerIdInput") != null || request.getParameter("transQuantityInput") != null) {

                    //spaceship name
                    userSelectedValue = request.getParameter(spaceshipSelectTagName);
                    // Here you have to recreate the spaceshipSelectTag, passing in a new parameter 
                    // that shows what the user has already selected -- so the select tag persists.
                    spaceshipSelectTag = MakeTags.makeSelectTag(dbc, spaceshipSelectTagName, spaceshipSelectSql,
                        spaceshipFirstOption, userSelectedValue);
                }
                
                //Check for login
                if (session.getAttribute("user") != null){
                    
                    //get the user's first & last name
                    model.Customers.StringData strData 
                        = (model.Customers.StringData) session.getAttribute("user");
                    loginMsg = strData.firstName + " " + strData.lastName;
                    System.out.println("USERNAME: " + loginMsg);
                    inputData.customerId = strData.customerId;  //set session customer id value if logged in
                    if(request.getParameter("transQuantityInput") != null) { // this is postback
                        // package up Purchase String data
                        inputData.transDescrip = request.getParameter("transDescripInput");
                        inputData.transQuantity = request.getParameter("transQuantityInput");
                        inputData.spaceshipId = userSelectedValue;
                        System.out.print("User selected value: " + userSelectedValue + " ssT " + spaceshipSelectTagName);

                        // Get db connection and make sure it worked.
                        //DbConn dbc = new DbConn();
                        errorMsgs.errorMsg = dbc.getErr();

                        if (errorMsgs.errorMsg.length() == 0) {
                            // DB connection is good
                            errorMsgs = DbPurMods.insert(inputData, dbc); // errorMsgs will hold all validation messags
                            if (errorMsgs.errorMsg.length() == 0) { // this is the form level error message
                                // replace empty string with successful message
                                errorMsgs.errorMsg = "Record successfully inserted !";
                            }
                        } // if db connection is good
                    } 
                } else {
                    loginMsg = "Please <b> <a href=\"logon.jsp\" "
                                + "class=\"linkElement\">Login</a> </b> to continue";
                    System.out.println("Denied" + loginMsg);
                }
                dbc.close(); // no database connection leaks !
            } // postback
            else{
                errorMsgs.errorMsg = "Error establishing database connection.";
            }
            
        %>

        <jsp:include page="toHead.jsp"/>
        <jsp:include page="headToContent.jsp"/>
            <h2 style="text-align: center; color: white; margin-top: 2%;">Insert Purchase - <span class='headerLink'><a href="assoc.jsp">List All</a></span></h2>

            <form action ="insertAssoc.jsp" method="get" class="insertTable">
                <table class="insertTableCenter">
                    <tr>
                        <td>Customer Name </td>
                        
                        <td><% out.print(loginMsg);%></td>
                    </tr>
                    <tr>
                        <td>Spaceship </td>
                        <td><%=spaceshipSelectTag%></td>
                        <td class="error"><%=errorMsgs.spaceshipId%></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td><input type="text" name="transDescripInput" value="<%=inputData.transDescrip%>"/></td>
                        <td class="error"><%=errorMsgs.transDescrip%></td>
                    </tr>
                    <tr>
                        <td>Quantity</td>
                        <td><input type="text" name="transQuantityInput" value="<%=inputData.transQuantity%>"/></td>
                        <td class="error"><%=errorMsgs.transQuantity%></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Submit"/></td>
                        <td class="error"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><strong style="text-align: center;"><%=errorMsgs.errorMsg%></strong> </td>
                    </tr>
                </table>
            </form>
            <br/>

<jsp:include page="postContent.jsp"/>