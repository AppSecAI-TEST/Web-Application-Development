package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dbUtils.DbConn;
import model.Purchase.*;
import dbUtils.*;

public final class insertAssoc_jsp extends org.apache.jasper.runtime.HttpJspBase
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
            String spaceshipSelectTag = ""; // empty string unless we can get a good db connection.

            // Strings to specify how to make the email select tag 
            String spaceshipSelectTagName = "spaceship";
            String spaceshipSelectSql = "select spaceship_id, modelName from  sp17_3308_tug25055.spaceship order by modelName";
            String spaceshipFirstOption = "<option value='0'>Select User Type</option>";

            // This string will hold the value picked by the user  
            String userSelectedValue = ""; 

            //This will hold the message telling if a user is logged in or not
            String loginMsg = "";
            //Create DBC connection
            DbConn dbc = new DbConn();
            String msg = dbc.getErr();
            if (msg.length() == 0) {
                
                // This will be the select tag for first rendering (nothing pre-selected) 
                spaceshipSelectTag = MakeTags.makeSelectTag(dbc, spaceshipSelectTagName, spaceshipSelectSql,
                        spaceshipFirstOption, userSelectedValue);

                // Postback - persist user entered values
                if (request.getParameter("customerIdInput") != null || request.getParameter("transQuantityInput") != null) {

                    //spaceship name
                    userSelectedValue = request.getParameter(spaceshipSelectTagName);
                    // Here you have to recreate the spaceshipSelectTag, passing in a new parameter 
                    // that shows what the user has already selected -- so the select tag persists.
                    spaceshipSelectTag = MakeTags.makeSelectTag(dbc, spaceshipSelectTagName, spaceshipSelectSql,
                        spaceshipFirstOption, userSelectedValue);
                }
                
                //Check for login
                if (session.getAttribute("user") != null){
                    
                    //get the user's first & last name
                    model.Customers.StringData strData 
                        = (model.Customers.StringData) session.getAttribute("user");
                    loginMsg = strData.firstName + " " + strData.lastName;
                    System.out.println("USERNAME: " + loginMsg);
                    inputData.customerId = strData.customerId;  //set session customer id value if logged in
                    if(request.getParameter("transQuantityInput") != null) { // this is postback
                        // package up Purchase String data
                        inputData.transDescrip = request.getParameter("transDescripInput");
                        inputData.transQuantity = request.getParameter("transQuantityInput");
                        inputData.spaceshipId = userSelectedValue;
                        System.out.print("User selected value: " + userSelectedValue + " ssT " + spaceshipSelectTagName);

                        // Get db connection and make sure it worked.
                        //DbConn dbc = new DbConn();
                        errorMsgs.errorMsg = dbc.getErr();

                        if (errorMsgs.errorMsg.length() == 0) {
                            // DB connection is good
                            errorMsgs = DbPurMods.insert(inputData, dbc); // errorMsgs will hold all validation messags
                            if (errorMsgs.errorMsg.length() == 0) { // this is the form level error message
                                // replace empty string with successful message
                                errorMsgs.errorMsg = "Record successfully inserted !";
                            }
                        } // if db connection is good
                    } 
                } else {
                    loginMsg = "Please <b> <a href=\"logon.jsp\" "
                                + "class=\"linkElement\">Login</a> </b> to continue";
                    System.out.println("Denied" + loginMsg);
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
      out.write("            <h2 style=\"text-align: center; color: white; margin-top: 2%;\">Insert Purchase - <span class='headerLink'><a href=\"assoc.jsp\">List All</a></span></h2>\n");
      out.write("\n");
      out.write("            <form action =\"insertAssoc.jsp\" method=\"get\" class=\"insertTable\">\n");
      out.write("                <table class=\"insertTableCenter\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Customer Name </td>\n");
      out.write("                        \n");
      out.write("                        <td>");
 out.print(loginMsg);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Spaceship </td>\n");
      out.write("                        <td>");
      out.print(spaceshipSelectTag);
      out.write("</td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.spaceshipId);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Description</td>\n");
      out.write("                        <td><input type=\"text\" name=\"transDescripInput\" value=\"");
      out.print(inputData.transDescrip);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.transDescrip);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Quantity</td>\n");
      out.write("                        <td><input type=\"text\" name=\"transQuantityInput\" value=\"");
      out.print(inputData.transQuantity);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.transQuantity);
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
      out.write("</strong> </td>\n");
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
