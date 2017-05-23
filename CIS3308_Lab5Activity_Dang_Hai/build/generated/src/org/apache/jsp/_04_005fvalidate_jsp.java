package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _04_005fvalidate_jsp extends org.apache.jasper.runtime.HttpJspBase
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


        String strLastName = "";
        String strAge = "";
        String lastNameErrorMsg = ""; // be optimistic
        String ageErrorMsg = ""; // dont show an error upon 1st rendering
        String msg = ""; // this is an overall messsage (beyond field level validation)
        if (request.getParameter("lastName") != null) {
            strLastName = request.getParameter("lastName");
            if (strLastName.length() == 0) {
                lastNameErrorMsg = "Last Name is a required field";
            }
            strAge = request.getParameter("age");
            try {
                int i = Integer.parseInt(strAge);
            } catch (Exception e) {
                ageErrorMsg = "Please enter a numeric age.";
            }
            String allErrors = lastNameErrorMsg + ageErrorMsg;
            if (allErrors.length() == 0) {
                msg = "Congratulations for filling out the form sucessfully.";
            } else {
                msg = "Please try again.";
            }
        }

    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <h2>Simple Validation: last name is required, age must be a whole number</h2>\n");
      out.write("        <form action=\"04_validate.jsp\" method=\"get\">\n");
      out.write("            Please enter your last name \n");
      out.write("            <input name=\"lastName\" value=\"");
      out.print(strLastName);
      out.write("\"/> \n");
      out.write("            <span class=\"error\">");
      out.print(lastNameErrorMsg);
      out.write("</span> \n");
      out.write("            <br/>\n");
      out.write("            Please enter your age \n");
      out.write("            <input name =\"age\" value=\"");
      out.print(strAge);
      out.write("\"/>\n");
      out.write("            <span class=\"error\">");
      out.print(ageErrorMsg);
      out.write("</span>\n");
      out.write("            <br/><br/>\n");
      out.write("            <input type=\"submit\" value=\"click me\"/>\n");
      out.write("            <br/><br/>\n");
      out.write("            ");
      out.print(msg);
      out.write("\n");
      out.write("        </form>\n");
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
