<%@page import="view.metadataView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page language="java" import="dbUtils.DbConn" %>
<%@page language="java" import="dbUtils.*" %> 


        <%
            // Declare all Strings and objects as they should be if it is first rendering
            //StringData inputData = new StringData(); // all properties empty string, good for first rendering
            //StringData errorMsgs = new StringData(); // all properties empty string, good for first rendering

            // This string will hold the generated email select tag
            String metaSelectTag = ""; // empty string unless we can get a good db connection.

            // Strings to specify how to make the email select tag 
            String metaSelectTagName = "meta";
            String metaSelectSql = "SELECT TABLE_NAME FROM information_schema.tables WHERE table_schema = 'sp17_3308_tug25055'";
            String metaFirstOption = "<option value='0'>Select User Type</option>";

            // This string will hold the value picked by the user  
            String userSelectedValue = ""; 

            //Create DBC connection
            DbConn dbc = new DbConn();
            String msg = dbc.getErr();
            if (msg.length() == 0) {

                // This will be the select tag for first rendering (nothing pre-selected) 
                metaSelectTag = MakeTags.makeMetaSelectTag(dbc, metaSelectTagName, metaSelectSql,
                        metaFirstOption, userSelectedValue);

                 // Postback - persist user entered values
                if (request.getParameter(metaSelectTagName) != null ) {

                    //Table
                    userSelectedValue = request.getParameter("meta");
                    System.out.println("Meta: " + userSelectedValue);
                    metaSelectTag = MakeTags.makeMetaSelectTag(dbc, metaSelectTagName, metaSelectSql,
                        metaFirstOption, userSelectedValue);
                    
                    //Make the table
                    msg = metadataView.listAllMetaData("resultSet", dbc, userSelectedValue);
                } else {
                    System.out.println("Null meta: " + userSelectedValue);
                }

            } //postback
            else {
                msg = "Error establishing database connection.";
            }  
            dbc.close(); // no database connection leaks !
            
        %>

        <jsp:include page="toHead.jsp"/>
        <jsp:include page="headToContent.jsp"/>
            <h2 style="text-align: center; color: white">Metadata </h2>

            <form action ="listFields.jsp" method="get" class="insertTable">
                <table class="insertTableCenter">
                    <tr>
                        <td>Meta Table List</td>
                        <td><%=metaSelectTag%></td>
                        <td class="error"></td>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Submit"/></td>
                        <td class="error"></td>
                    </tr>
                </table>
            </form>
            <br/>
            <%=msg%>

<jsp:include page="postContent.jsp"/>