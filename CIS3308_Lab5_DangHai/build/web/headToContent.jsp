<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="model.Customers.StringData"%>
</head>
    <body>
        
    <%
        String msg = "<a href ='logon.jsp'>Log On</a>";

        if (session.getAttribute("user") != null) {
            StringData loggedOnUser = (StringData) session.getAttribute("user");
            msg = "Welcome " + loggedOnUser.firstName + " " + loggedOnUser.lastName
                    + ",  <a href ='logoff.jsp'>Log Off?</a>";
        } 
    %>
        
        
        <div  id="container">
            <div id="titleNav">
                <div id="title">
                    Named Space
                </div>
                <div id="nav">
                    <a href="index.jsp" class="navLinks">Home</a> |
                    <a href="users.jsp" class="navLinks">Customers</a> |
                    <a href="other.jsp" class="navLinks">Spaceships</a> |
                    <a href="assoc.jsp" class="navLinks">Buys</a> |
                    <a href="search.jsp" class="navLinks">Search</a> |
                    <a href="membersOnly.jsp" class="navLinks">Members</a> |
                    <a href="labs.jsp" class="navLinks">Labs</a> |  
                    
                    <div style='padding: 4px 10px; display:inline-block; border-bottom:#CCCCCC;'>
                        <%=msg%>
                    </div>
                </div>
                <span class="stopFloat"></span>
            </div>

            <div id="content">