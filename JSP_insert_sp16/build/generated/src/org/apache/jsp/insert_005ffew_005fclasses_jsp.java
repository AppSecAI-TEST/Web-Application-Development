package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dbUtils.DbConn;
import java.sql.PreparedStatement;

public final class insert_005ffew_005fclasses_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Insert Customer</title>\n");
      out.write("        <link href=\"mystyle.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <style>\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            // Declare all Strings and objects as they should be for first rendering

            // both textboxes will be empty 1st rendering
            String strEmail = "";
            String strEmailMsg = "";

            // both error messages will be empty 1st rendering
            String strPassw = "";
            String strPasswMsg = "";

            // form message will be empty 1st rendering
            String formMsg = "";

            if (request.getParameter("email") != null) { // this is postback

                // Take user entered data from the URL and save this so the data will persist 
                // in the textboxes upon submit. See value attributes of <input> tags below.
                strEmail = request.getParameter("email");
                strPassw = request.getParameter("passw");

                // "validation" -- for this simple version, just make sure they entered something 
                // into each of the two fields.
                if (strEmail.length() == 0) {
                    strEmailMsg = "Email Address is required";
                }
                if (strPassw.length() == 0) {
                    strPasswMsg = "Password is required";
                }

                String allValidationErrors = strEmailMsg + strPasswMsg;
                if (allValidationErrors.length() == 0) { // pass validation, so proceed
                    
                    // Get db connection and make sure it worked.
                    DbConn dbc = new DbConn();
                    formMsg = dbc.getErr();
                    if (formMsg.length() == 0) { // DB connection is good

                        try {

                            String sql = "INSERT INTO customer (email_address, pwd) values (?,?)";
                            PreparedStatement pStatement = dbc.getConn().prepareStatement(sql);

                            // Encode string values into the prepared statement (wrapper class).
                            pStatement.setString(1, strEmail);
                            pStatement.setString(2, strPassw);

                            // here the UPDATE is actually executed
                            int numRows = pStatement.executeUpdate();
                            formMsg = numRows + " record successfully inserted !";

                        } catch (Exception e) {
                            formMsg = "Could not insert. Exception message: " + e.getMessage();
                        }
                    } // if db connection is good
                    dbc.close(); // no database connection leaks !
                    
                } else { // did not pass validation 
                    formMsg = "Please Try Again";
                }

            } // postback
        
      out.write("\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "top.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"content\">\n");
      out.write("\n");
      out.write("            <br/><br/>\n");
      out.write("            <h3>Insert Customer (few classes) - <span class='headerLink'><a href=\"customers.jsp\">List All</a></span></h3>\n");
      out.write("\n");
      out.write("            <form action =\"insert_few_classes.jsp\" method=\"get\">\n");
      out.write("\n");
      out.write("                <br/>\n");
      out.write("                Email Address\n");
      out.write("                <input type=\"text\"  name=\"email\" value=\"");
      out.print(strEmail);
      out.write("\"/>\n");
      out.write("                <span class=\"error\">");
      out.print(strEmailMsg);
      out.write(" </span>\n");
      out.write("\n");
      out.write("                <br/><br/><br/>\n");
      out.write("                Password\n");
      out.write("                <input type=\"password\"  name=\"passw\" value=\"");
      out.print(strPassw);
      out.write("\"/>\n");
      out.write("                <span class=\"error\">");
      out.print(strPasswMsg);
      out.write(" </span>\n");
      out.write("                <br/><br/><br/>\n");
      out.write("\n");
      out.write("                <input type=\"submit\" value=\"Submit\"/>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <br/><br/><br/>\n");
      out.write("            <strong>");
      out.print(formMsg);
      out.write("</strong>  \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
