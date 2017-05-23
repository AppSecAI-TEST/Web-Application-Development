package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dbUtils.DbConn;
import model.Customers.*;
import dbUtils.*;

public final class insertUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

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
            
        
      out.write("\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "toHead.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "headToContent.jsp", out, false);
      out.write("\n");
      out.write("            <h3 style=\"text-align: center;\">Insert Customer - <span class='headerLink'><a href=\"users.jsp\">List All</a></span></h3>\n");
      out.write("\n");
      out.write("            <form action =\"insertUser.jsp\" method=\"get\" class=\"insertTable\">\n");
      out.write("                <table class=\"insertTableCenter\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Email Address</td>\n");
      out.write("                        <td><input type=\"text\"  name=\"customerEmailInput\" value=\"");
      out.print(inputData.customerEmail);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.customerEmail);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Your UserName</td>\n");
      out.write("                        <td><input type=\"text\" name=\"customerUsernameInput\" value=\"");
      out.print(inputData.customerUsername);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.customerUsername);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Your Password</td>\n");
      out.write("                        <td><input type=\"password\" name=\"customerPasswordInput\" value=\"");
      out.print(inputData.customerPassword);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.customerPassword);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Retype Your Password</td>\n");
      out.write("                        <td><input type=\"password\" name=\"customerPasswordInput2\" value=\"");
      out.print(inputData.customerPassword2);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.customerPassword2);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>User Role</td>\n");
      out.write("                        <td>");
      out.print(roleSelectTag);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>First Name</td>\n");
      out.write("                        <td><input type=\"text\" name=\"firstNameInput\" value=\"");
      out.print(inputData.firstName);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.firstName);
      out.write("</td> \n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Last Name</td>\n");
      out.write("                        <td><input type=\"text\" name=\"lastNameInput\" value=\"");
      out.print(inputData.lastName);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.lastName);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr style=\"margin-bottom: 2%;\" >\n");
      out.write("                        <td>Date of Birth </td>\n");
      out.write("                        <td><input type=\"text\" name=\"customerDOBInput\" value=\"");
      out.print(inputData.customerDOB);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.customerDOB);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td style=\"text-align:center;\"><input type=\"submit\" value=\"Submit\"/></td>\n");
      out.write("                        <td class=\"error\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td><strong style=\"text-align: center;\">");
      out.print(errorMsgs.errorMsg);
      out.write("</strong></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("            <br/>\n");
      out.write("\n");
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
