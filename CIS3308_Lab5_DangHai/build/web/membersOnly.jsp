<%@page import="model.Customers.StringData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String msg = "";
    String img ="";
    if(session.getAttribute("user") != null){
        StringData strData = (StringData) session.getAttribute("user");
        System.out.print("Successful member page login.");
            msg = "Welcome " + strData.firstName + ", you're logged in. "
                    + "If you're seeing this, it means that you're a valued member of our company.";
            img ="<img src=\"http://joyeuxnovembre.ca/wp-content/uploads/2013/08/background-transparent-fireworks-color2.png\" "
                    + "alt=\"fireworks\" id=\"membersImg\"";
    } else {
        msg = "<b> Sorry you are not a member. You are not permitted to be here.</b> <br/>"
                + "To enter, please <b> <a href=\"logon.jsp\" "
                + "class=\"linkElement\">Login</a> </b>.";
        System.out.print("Successful member page login.");
    }
%>
<jsp:include page="toHead.jsp"/>
<jsp:include page="headToContent.jsp"/>
                <div class="formTable">
                    <%=msg%>
                </div>
                <%=img%>

<jsp:include page="postContent.jsp"/>