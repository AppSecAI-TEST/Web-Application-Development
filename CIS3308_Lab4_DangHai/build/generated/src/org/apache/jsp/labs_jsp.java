package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class labs_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "toHead.jsp", out, false);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "headToContent.jsp", out, false);
      out.write("\n");
      out.write("<div id=\"labPage\" style=\"padding: 5%\">\n");
      out.write("                <h2 class=\"labName\">Lab 1: Data Model (& Project Proposal)</h2>\n");
      out.write("                <p class=\"labDescrip\"> A project proposal was created and a database design was created. \n");
      out.write("                    <a href=CIS3308_Lab2_Dang_Hai.docx style=\"text-decoration: none;\">Click here</a> for the latest web application proposal.\n");
      out.write("                    <a href=\"datamodel.pdf\" style=\"text-decoration: none;\">Click here</a> for the data model.</p>\n");
      out.write("                \n");
      out.write("                <h2 class=\"labName\">Lab 2: Database (Populate & Extract Data)</h2>\n");
      out.write("                <p class=\"labDescrip\"> In this lab, the database was populated with values. Then values were extracted with \n");
      out.write("                    <a href=\"CIS3308_Lab2_Dang_Hai.docx\" style=\"text-decoration: none;\">SQL statements</a>.</p>\n");
      out.write("                \n");
      out.write("                <h2 class=\"labName\">Lab 3: JSP Home Page</h2>\n");
      out.write("                <p class=\"labDescrip\">For this lab, this website was created using html/css along with select JSP statements for code reuse. Click here to see my \n");
      out.write("                <a href=\"index.jsp\" style=\"text-decoration: none;\"> home page</a></p>\n");
      out.write("                \n");
      out.write("                <h2 class=\"labName\">Lab 4: Data Display Lab</h2>\n");
      out.write("                <p class=\"labDescrip\">In the lab, I learned how to write java & JSP code that connected to my database. \n");
      out.write("                One of the interesting aspects of this lab was setting up table in the code and formatting it appropriately.\n");
      out.write("                This was a little challenging because I had to create a few unique formatters in the FormatUtils class for \n");
      out.write("                parsing the result set specifically for datatypes of type doubles and one uniquely for images. \n");
      out.write("                Click the link to see my <a href=\"users.jsp\" style=\"text-decoration: none;\"> users page</a>,\n");
      out.write("                this link to see my <a href=\"other.jsp\" style=\"text-decoration: none;\"> others page</a>,\n");
      out.write("                or this link to see my <a href=\"assoc.jsp\" style=\"text-decoration: none;\"> associative page</a>.  \n");
      out.write("                </p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "postContent.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
