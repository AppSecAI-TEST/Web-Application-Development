<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page language="java" import="dbUtils.DbConn" %>
<%@page language="java" import="model.Customers.*" %> 
<%@page language="java" import="dbUtils.*" %> 


        <%
            // Declare all Strings and objects as they should be if it is first rendering
            StringData inputData = new StringData(); // all properties empty string, good for first rendering
            StringData errorMsgs = new StringData(); // all properties empty string, good for first rendering

            // This string will hold the generated email select tag
            String roleSelectTag = ""; // empty string unless we can get a good db connection.

            // Strings to specify how to make the email select tag 
            String roleSelectTagName = "role";
            String roleSelectSql = "select user_role_id, user_role from sp17_3308_tug25055.user_role";
            String roleFirstOption = "<option value='0'>Select User Type</option>";

            // This string will hold the value picked by the user  
            String userSelectedValue = ""; 

            //Create DBC connection
            DbConn dbc = new DbConn();
            String msg = dbc.getErr();
            if (msg.length() == 0) {

                // This will be the select tag for first rendering (nothing pre-selected) 
                roleSelectTag = MakeTags.makeSelectTag(dbc, roleSelectTagName, roleSelectSql,
                        roleFirstOption, userSelectedValue);

                // Postback - persist user entered values
                if (request.getParameter("customerEmailInput") != null || request.getParameter("customerPasswordInput") != null) {

                    //Email
                    userSelectedValue = request.getParameter(roleSelectTagName);
                    // Here you have to recreate the emailSelectTag, passsing in a new parameter 
                    // that shows what the user has already selected -- so the select tag persists.
                    roleSelectTag = MakeTags.makeSelectTag(dbc, roleSelectTagName, roleSelectSql,
                        roleFirstOption, userSelectedValue);
                }

                if (request.getParameter("customerEmailInput") != null) { // this is postback
                    // package up Customer String data
                    inputData.customerEmail = request.getParameter("customerEmailInput");
                    inputData.customerUsername = request.getParameter("customerUsernameInput");
                    inputData.customerPassword = request.getParameter("customerPasswordInput");
                    inputData.customerPassword2 = request.getParameter("customerPasswordInput2");
                    inputData.firstName = request.getParameter("firstNameInput");
                    inputData.lastName = request.getParameter("lastNameInput");
                    inputData.customerDOB = request.getParameter("customerDOBInput");
                    inputData.role = userSelectedValue;
                    System.out.print("User selected value: " + userSelectedValue + " rsT " + roleSelectTagName);
                    
                    // Get db connection and make sure it worked.
                    //DbConn dbc = new DbConn();
                    errorMsgs.errorMsg = dbc.getErr();

                    if (errorMsgs.errorMsg.length() == 0) {
                        // DB connection is good
                        errorMsgs = DbCusMods.insert(inputData, dbc); // errorMsgs will hold all validation messags
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
            <h2 style="text-align: center; color: white">Insert Customer - <span class='headerLink'><a href="users.jsp">List All</a></span></h2>

            <form action ="insertUser.jsp" method="get" class="insertTable">
                <table class="insertTableCenter">
                    <tr>
                        <td>Email Address</td>
                        <td><input type="text"  name="customerEmailInput" value="<%=inputData.customerEmail%>"/></td>
                        <td class="error"><%=errorMsgs.customerEmail%></td>
                    </tr>
                    <tr>
                        <td>Your UserName</td>
                        <td><input type="text" name="customerUsernameInput" value="<%=inputData.customerUsername%>"/></td>
                        <td class="error"><%=errorMsgs.customerUsername%></td>
                    </tr>
                    <tr>
                        <td>Your Password</td>
                        <td><input type="password" name="customerPasswordInput" value="<%=inputData.customerPassword%>"/></td>
                        <td class="error"><%=errorMsgs.customerPassword%></td>
                    </tr>
                    <tr>
                        <td>Retype Your Password</td>
                        <td><input type="password" name="customerPasswordInput2" value="<%=inputData.customerPassword2%>"/></td>
                        <td class="error"><%=errorMsgs.customerPassword2%></td>
                    </tr>
                    <tr>
                        <td>User Role</td>
                        <td><%=roleSelectTag%></td>
                        <td class="error"><%=errorMsgs.role%></td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstNameInput" value="<%=inputData.firstName%>"/></td>
                        <td class="error"><%=errorMsgs.firstName%></td> 
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastNameInput" value="<%=inputData.lastName%>"/></td>
                        <td class="error"><%=errorMsgs.lastName%></td>
                    </tr>
                    <tr style="margin-bottom: 2%;" >
                        <td>Date of Birth </td>
                        <td><input type="text" name="customerDOBInput" value="<%=inputData.customerDOB%>"/></td>
                        <td class="error"><%=errorMsgs.customerDOB%></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Submit"/></td>
                        <td class="error"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><strong style="text-align: center;"><%=errorMsgs.errorMsg%></strong></td>
                    </tr>
                </table>
            </form>
            <br/>

<jsp:include page="postContent.jsp"/>