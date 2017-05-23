<%@page import="view.reportView"%>
<%@page import="view.metadataView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page language="java" import="dbUtils.DbConn" %>
<%@page language="java" import="dbUtils.*" %> 


        <%

            String query = "select customer_id, firstName as first, lastName as last, cus_loginName as email, "
                    + "cus_password as password, cus_username as username, cus_DOB as DOB, user_role as role " 
                    + "from sp17_3308_tug25055.customer, sp17_3308_tug25055.user_role " 
                    + "where customer.user_role_id = user_role.user_role_id order by lastName, firstName";

            //Create DBC connection
            DbConn dbc = new DbConn();
            String msg = dbc.getErr();
            if (msg.length() == 0) {

                 // Postback - persist user entered values
                if (request.getParameter("sqlInput") != null ) {
                    query = request.getParameter("sqlInput");
                    //Make the table
                    msg = reportView.listAll("resultSet", dbc, query);
                }  
            } //postback
            else {
                msg = "Error establishing database connection.";
            }  
            dbc.close(); // no database connection leaks !
            
        %>

        <jsp:include page="toHead.jsp"/>
        <jsp:include page="headToContent.jsp"/>
            <h2 style="text-align: center; color: white">Report Writer</h2>

            <form action ="report.jsp" method="get" class="insertTable">
                <table class="insertTableCenter">
                    <tr>
                        <td>SQL Query</td>
                        <td><input type="text" name="sqlInput" value="<%=query%>" size="100"/></td>
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