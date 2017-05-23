package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dbUtils.DbConn;
import model.Customers.*;

public final class logon_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write(" \n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "toHead.jsp", out, false);
      out.write('\n');
      out.write('\n');

            // email and password (inside of userData) are both now ""
            StringData userData = new StringData(); 
        
            // last name error msg and age error msg (inside of userErrors) are both now ""
            StringData userErrors = new StringData();  
            
            // Still have a "form message" 
            String msg = ""; // this is an overall messsage (beyond field level validation)
            String temp ="";
            // still need to check for postback 
            if (request.getParameter("emailInputTag") != null) {
                // persist data from the URL
                userData.customerEmail = request.getParameter("emailInputTag");
                userData.customerPassword = request.getParameter("passwordInputTag");
                 
                //validate email is put in
                if(userData.customerEmail.length() == 0){
                    userErrors.customerEmail = "Email is required";
                }
               
                //validate password 
                if(userData.customerPassword.length() == 0){
                    userErrors.customerPassword = "Password is required";
                }
                
                String allErrors = userErrors.customerEmail + userErrors.customerPassword;

                //setup backend connection
                DbConn dbc = new DbConn();
                msg = dbc.getErr(); // formMsg will hold db connection error, if any
                temp = msg;
                if (msg.length() == 0) {
                    StringData foundUser = SearchCustomer.logonFind(userData.customerEmail, userData.customerPassword, dbc);
                    if (foundUser == null) {
                        msg = "User name and password not found.";
                        session.invalidate();
                    } else {
                        msg = foundUser.errorMsg; // formMsg will hold db error, e.g., sql error, if any
                        if (msg.length() == 0 && allErrors.length() == 0) {
                            // otherwise, it was a good logon. welcome the user...
                            msg = "Welcome " + foundUser.firstName + " " + foundUser.lastName
                                    + ". You are now logged on.";
                            session.setAttribute("user", foundUser);
                        } else {
                            msg = "Please try again.";
                        }
                    }
                } else {
                    msg = "Database unavailable, please try again later.<br/>" + temp;
                }
            }
        
      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "headToContent.jsp", out, false);
      out.write("\n");
      out.write("                <div class=\"formTable\">\n");
      out.write("                    <h1 style=\"text-align: center; color:white;\">Log in</h1>\n");
      out.write("                    <form action=\"logon.jsp\" method=\"post\">\n");
      out.write("                        <label class=\"labelForm\"> Please enter email address: </label>\n");
      out.write("                        <br/>\n");
      out.write("                        <input type=\"text\" name=\"emailInputTag\" value=\"timelord@gmail.com\" class=\"inputForm\"/> \n");
      out.write("                        <span class=\"error\">");
      out.print(userErrors.customerEmail);
      out.write("</span> \n");
      out.write("                        <br/><br/>\n");
      out.write("                        <label class=\"labelForm\">Please enter your password: </label>\n");
      out.write("                        <br/>\n");
      out.write("                        <input type = \"password\" name =\"passwordInputTag\" value=\"thisisgallifrey\" class=\"inputForm\"/>\n");
      out.write("                        <span class=\"error\">");
      out.print(userErrors.customerPassword);
      out.write("</span>\n");
      out.write("                        <br/><br/>\n");
      out.write("                        <input type=\"submit\" value=\"Login\" class=\"formButton\"/>\n");
      out.write("                        <br/><br/>\n");
      out.write("                        ");
      out.print(msg);
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "postContent.jsp", out, false);
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
