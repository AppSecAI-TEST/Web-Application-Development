<%-- 
    Document   : logoff
    Created on : Feb 20, 2017, 3:08:12 AM
    Author     : Hai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


        <%
            session.invalidate();
            response.sendRedirect("index.jsp");
        %>
        
