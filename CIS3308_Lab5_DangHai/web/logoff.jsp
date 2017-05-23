<%-- 
    Document   : logoff
    Created on : Feb 20, 2017, 3:08:12 AM
    Author     : Hai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


        <%
            session.invalidate();
        %>
        
<jsp:include page="toHead.jsp"/>
<jsp:include page="headToContent.jsp"/>
        <div class="formTable">
            <h3>You are now logged off.</h3>     
        </div>
<jsp:include page="postContent.jsp"/>