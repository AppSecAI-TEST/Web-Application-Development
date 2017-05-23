<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page language="java" import="dbUtils.DbConn" %>
<%@page language="java" import="model.Spaceships.*" %> 
<%@page language="java" import="dbUtils.*" %> 


        <%
            // Declare all Strings and objects as they should be if it is first rendering
            StringData inputData = new StringData(); // all properties empty string, good for first rendering
            StringData errorMsgs = new StringData(); // all properties empty string, good for first rendering


            //Create DBC connection
            DbConn dbc = new DbConn();
            String msg = dbc.getErr();
            if (msg.length() == 0) {
                if (request.getParameter("modelNameInput") != null) { // this is postback
                    // package up Customer String data
                    inputData.modelName = request.getParameter("modelNameInput");
                    inputData.modelYear = request.getParameter("modelYearInput");
                    inputData.modelType = request.getParameter("modelTypeInput");
                    inputData.maxCapacity = request.getParameter("maxCapacityInput");
                    inputData.spaceshipPrice = request.getParameter("spaceshipPriceInput");
                    inputData.imageUrl = request.getParameter("imageUrlInput");
                    inputData.fuelCapacity = request.getParameter("fuelCapacityInput");
                    
                    // Get db connection and make sure it worked.
                    //DbConn dbc = new DbConn();
                    errorMsgs.errorMsg = dbc.getErr();

                    if (errorMsgs.errorMsg.length() == 0) {
                        // DB connection is good
                        errorMsgs = DbSpMods.insert(inputData, dbc); // errorMsgs will hold all validation messags
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
            <h2 style="text-align: center;  color: white">Insert Spaceship - <span class='headerLink'><a href="other.jsp">List All</a></span></h2>

            <form action ="insertOther.jsp" method="get" class="insertTable">
                <table class="insertTableCenter">
                    <tr>
                        <td>Model Name</td>
                        <td><input type="text"  name="modelNameInput" value="<%=inputData.modelName%>"/></td>
                        <td class="error"><%=errorMsgs.modelName%></td>
                    </tr>
                    <tr>
                        <td>Model Date</td>
                        <td><input type="text" name="modelYearInput" value="<%=inputData.modelYear%>"/></td>
                        <td class="error"><%=errorMsgs.modelYear%></td>
                    </tr>
                    <tr>
                        <td>Model Type</td>
                        <td><input type="text" name="modelTypeInput" value="<%=inputData.modelType%>"/></td>
                        <td class="error"><%=errorMsgs.modelType%></td>
                    </tr>
                    <tr>
                        <td>Max Capacity</td>
                        <td><input type="text" name="maxCapacityInput" value="<%=inputData.maxCapacity%>"/></td>
                        <td class="error"><%=errorMsgs.maxCapacity%></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><input type="text" name="spaceshipPriceInput" value="<%=inputData.spaceshipPrice%>"/></td>
                        <td class="error"><%=errorMsgs.spaceshipPrice%></td> 
                    </tr>
                    <tr>
                        <td>Image URL</td>
                        <td><input type="text" name="imageUrlInput" value="<%=inputData.imageUrl%>"/></td>
                        <td class="error"><%=errorMsgs.imageUrl%></td>
                    </tr>
                    <tr>
                        <td>Fuel Capacity</td>
                        <td><input type="text" name="fuelCapacityInput" value="<%=inputData.fuelCapacity%>"/></td>
                        <td class="error"><%=errorMsgs.fuelCapacity%></td>
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