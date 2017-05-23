package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.yourTableName.StringData;

public final class _20_005fsession_005fset_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Simple Validation</title>\n");
      out.write("        <style>\n");
      out.write("            .error {\n");
      out.write("                color:red;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    ");

        /* replace this...
            String strLastName = "";
            String strAge = "";
            String lastNameErrorMsg = ""; // be optimistic
            String ageErrorMsg = ""; // dont show an error upon 1st rendering

        with this: */
        
        // last name & age (inside of userData) are both now ""
        StringData userData = new StringData(); 
        
        // last name error msg and age error msg (inside of userErrors) are both now ""
        StringData userErrors = new StringData();  

        // Still have a "form message" 
        String msg = ""; // this is an overall messsage (beyond field level validation)
        
        // still need to check for postback 
        if (request.getParameter("lastNameInputTag") != null) { 
            
            // persist data from the URL
            userData.lastName= request.getParameter("lastNameInputTag");
            userData.age = request.getParameter("ageInputTag");
            userData.numClasses = request.getParameter("numClassInputTag");
            // validate the name
            if (userData.lastName.length() == 0) {
                userErrors.lastName = "Last Name is required.";
            }
                        
            // validate the age
            try {
                int i = Integer.parseInt(userData.age);
            } catch (Exception e) {
                userErrors.age = "Please enter a whole number for age.";
            }
            
            //validate number of classes
            if(userData.numClasses.length() != 0){
                try {
                    int i = Integer.parseInt(userData.numClasses);
                } catch (Exception e) {
                    userErrors.numClasses = "Please enter a whole number for number of classes.";
                }
            }

            
            // set the form message
            String allErrors = userErrors.lastName + userErrors.age + userErrors.numClasses;
            if (allErrors.length() == 0) {
                msg = "Congratulations for filling out the form sucessfully.";
                session.setAttribute("userDataStuff", userData);
                msg = userData.toString() + " has been written to the JSP session object";
            } else {
                msg = "Please try again.";
            }
        }

    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <h2>Simple Validation: last name is required, age & CIS classes must be a whole number</h2>\n");
      out.write("         <h4 style=\"text-align: right; margin-top: -32px;\">\n");
      out.write("            <a href=\"20_session_set.jsp\">Set</a>\n");
      out.write("            | \n");
      out.write("            <a href=\"21_session_get.jsp\">Get</a>\n");
      out.write("        </h4>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <form action=\"20_session_set.jsp\" method=\"get\">\n");
      out.write("            Please enter your last name \n");
      out.write("            <input name=\"lastNameInputTag\" value=\"");
      out.print(userData.lastName);
      out.write("\"/> \n");
      out.write("            <span class=\"error\">");
      out.print(userErrors.lastName);
      out.write("</span> \n");
      out.write("            <br/><br/>\n");
      out.write("            Please enter your age \n");
      out.write("            <input name =\"ageInputTag\" value=\"");
      out.print(userData.age);
      out.write("\"/>\n");
      out.write("            <span class=\"error\">");
      out.print(userErrors.age);
      out.write("</span>\n");
      out.write("            <br/><br/>\n");
      out.write("            Please enter the number of CIS classes you've taken \n");
      out.write("            <input name =\"numClassInputTag\" value=\"");
      out.print(userData.numClasses);
      out.write("\"/>\n");
      out.write("            <span class=\"error\">");
      out.print(userErrors.numClasses);
      out.write("</span>\n");
      out.write("            <br/><br/>\n");
      out.write("            <input type=\"submit\" value=\"click me\"/>\n");
      out.write("            <br/><br/>\n");
      out.write("            ");
      out.print(msg);
      out.write("\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
