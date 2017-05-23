<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page language="java" import="dbUtils.DbConn" %>
<%@page language="java" import="model.Purchase.*" %> 
<%@page language="java" import="dbUtils.*" %> 


        <%
            // Declare all Strings and objects as they should be if it is first rendering
            StringData inputData = new StringData(); // all properties empty string, good for first rendering
            StringData errorMsgs = new StringData(); // all properties empty string, good for first rendering

            StringData retrievedData = new StringData(); //all properties should be filled
            
            // This string will hold the generated email select tag
            String emailSelectTag = ""; // empty string unless we can get a good db connection.
            // Strings to specify how to make the email select tag 
            String emailSelectTagName = "email";
            String emailSelectSql = "select customer_id, cus_loginName from sp17_3308_tug25055.customer order by cus_loginName";
            String emailFirstOption = "<option value='0'>Select User</option>";

            // This string will hold the value picked by the user  
            String userSelectedValue = ""; 
            
            // This string will hold the generated email select tag
            String spaceshipSelectTag = ""; // empty string unless we can get a good db connection.
            // Strings to specify how to make the email select tag 
            String spaceshipSelectTagName = "spaceship";
            String spaceshipSelectSql = "select spaceship_id, modelName from  sp17_3308_tug25055.spaceship order by modelName";
            String spaceshipFirstOption = "<option value='0'>Select User Type</option>";

            // This string will hold the value picked by the user  
            String otherSelectedValue = ""; 

            //Create DBC connection
            DbConn dbc = new DbConn();
            String msg = dbc.getErr();
            if (msg.length() == 0) {
                //get data of user for the update query 
                String purchaseId = request.getParameter("id");
                if(purchaseId != null && request.getParameter("transQuantityInput") == null){
                    retrievedData = SearchPurchase.findPurchase(purchaseId, dbc);
                    System.out.println(retrievedData.toString());
                    inputData.purchaseId = retrievedData.purchaseId;
                    inputData.customerId = retrievedData.customerId;
                    inputData.spaceshipId = retrievedData.spaceshipId;
                    inputData.transCost = retrievedData.transCost;
                    inputData.transDate = retrievedData.transDate;
                    inputData.transDescrip = retrievedData.transDescrip;
                    inputData.transQuantity = retrievedData.transQuantity;
                }
               
                // This will be the select tag for first rendering (nothing pre-selected) 
                emailSelectTag = MakeTags.makeSelectTag(dbc, emailSelectTagName, emailSelectSql,
                    emailFirstOption, inputData.customerId);
                // This will be the select tag for first rendering (nothing pre-selected) 
                spaceshipSelectTag = MakeTags.makeSelectTag(dbc, spaceshipSelectTagName, spaceshipSelectSql,
                        spaceshipFirstOption, inputData.spaceshipId);

                // Postback - persist user entered values
                if (request.getParameter("purchaseIdInput") != null || request.getParameter("transQuantityInput") != null) {
                    //Email
                    userSelectedValue = request.getParameter(emailSelectTagName);
                    // Here you have to recreate the emailSelectTag, passsing in a new parameter 
                    // that shows what the user has already selected -- so the select tag persists.
                    emailSelectTag = MakeTags.makeSelectTag(dbc, emailSelectTagName, emailSelectSql,
                        emailFirstOption, userSelectedValue);
                    
                    //spaceship name
                    otherSelectedValue = request.getParameter(spaceshipSelectTagName);
                    // Here you have to recreate the spaceshipSelectTag, passing in a new parameter 
                    // that shows what the user has already selected -- so the select tag persists.
                    spaceshipSelectTag = MakeTags.makeSelectTag(dbc, spaceshipSelectTagName, spaceshipSelectSql,
                        spaceshipFirstOption, otherSelectedValue);
                }
                
              
                if(request.getParameter("transQuantityInput") != null) { // this is postback
                    // package up Purchase String data
                    inputData.purchaseId = request.getParameter("purchaseIdInput");
                    inputData.transDescrip = request.getParameter("transDescripInput");
                    inputData.transQuantity = request.getParameter("transQuantityInput");
                    inputData.transDate = request.getParameter("transDateInput");
                    inputData.transCost = request.getParameter("transCostInput");
                    inputData.customerId = userSelectedValue;
                    inputData.spaceshipId = otherSelectedValue;
                    System.out.print("User selected value: " + otherSelectedValue + " ssT " + spaceshipSelectTagName);

                    // Get db connection and make sure it worked.
                    //DbConn dbc = new DbConn();
                    errorMsgs.errorMsg = dbc.getErr();

                    if (errorMsgs.errorMsg.length() == 0) {
                        // DB connection is good
                        errorMsgs = DbPurMods.update(inputData, dbc); // errorMsgs will hold all validation messags
                        if (errorMsgs.errorMsg.length() == 0) { // this is the form level error message
                            // replace empty string with successful message
                            errorMsgs.errorMsg = "Record successfully inserted !";
                        }
                    } // if db connection is good
                } 
                dbc.close(); // no database connection leaks !
            } // postback
            else{
                errorMsgs.errorMsg = "Error establishing database connection.";
            }
            
        %>

        <jsp:include page="toHead.jsp"/>
        <jsp:include page="headToContent.jsp"/>
            <h2 style="text-align: center; color: white; margin-top: 2%;">Update Purchase - <span class='headerLink'><a href="assoc.jsp">List All</a></span></h2>

            <form action ="updateAssoc.jsp" method="get" class="insertTable">
                <table class="insertTableCenter">
                    <tr>     
                        <td>Transaction Id</td>
                        <td><input type="hidden"  name="purchaseIdInput" value="<%=inputData.purchaseId%>"/><%=inputData.purchaseId%></td>
                        <td class="error"><%=errorMsgs.purchaseId%></td>
                    </tr>
                    <tr>
                        <td>Customer </td>
                        <td><%=emailSelectTag%></td>
                        <td class="error"><%=errorMsgs.customerId%></td>
                    </tr>
                    <tr>
                        <td>Spaceship </td>
                        <td><%=spaceshipSelectTag%></td>
                        <td class="error"><%=errorMsgs.spaceshipId%></td>
                    </tr>
                    <tr>
                        <td>Date</td>
                        <td><input type="text" name="transDateInput" value="<%=inputData.transDate%>"/></td>
                        <td class="error"><%=errorMsgs.transDate%></td>
                    </tr>
                    <tr>
                        <td>Cost</td>
                        <td><input type="text" name="transCostInput" value="<%=inputData.transCost%>"/></td>
                        <td class="error"><%=errorMsgs.transCost%></td>
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
                        <td style="text-align:center;"><input type="submit" value="Submit"/></td>
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