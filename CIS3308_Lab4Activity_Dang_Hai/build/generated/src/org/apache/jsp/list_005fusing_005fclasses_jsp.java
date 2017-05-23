package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import view.*;
import dbUtils.DbConn;

public final class list_005fusing_005fclasses_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>List All Users</title>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                background-color: #F4F4F4; /* light gray */\n");
      out.write("                font-family: verdana, sans-serif;\n");
      out.write("            }\n");
      out.write("            .resultSet {\n");
      out.write("                background-color: #888888; /* dark grey shows thru between th and td */\n");
      out.write("                margin: auto; /* center table within its container */\n");
      out.write("            }\n");
      out.write("            .resultSet th {\n");
      out.write("                background-color: #608890;  /* dark green/blue */\n");
      out.write("                color: white;\n");
      out.write("                font-weight: bold;\n");
      out.write("                padding: 4px 6px;  /* top/bottom then left/right */\n");
      out.write("            }\n");
      out.write("            .resultSet td {\n");
      out.write("                background-color: #F0F8FF; /* light green/blue */\n");
      out.write("                padding: 2px 6px;  /* top/bottom then left/right */\n");
      out.write("            }\n");
      out.write("            h1, h2 {\n");
      out.write("                text-align:center;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            DbConn dbc = new DbConn();
            String msg = dbc.getErr(); // returns "" if connection is good, else error msg.
            if (msg.length() == 0) { // got open connection

                // returns a string that contains a HTML table with the db data in it
                // pass in the name of the CSS style that you want applied to the HTML 
                // table ("dependency injection") and pass in an open DbConn object.
                msg = customerView.listAllUsers("resultSet", dbc);
            }
            // PREVENT DB CONNECTION LEAKS (every code path that opens a db connection 
            // also must close it).
            dbc.close();            
        
      out.write("\n");
      out.write("\n");
      out.write("        <h2>User List</h2>\n");
      out.write("        ");
 out.print(msg);
      out.write("\n");
      out.write("\n");
      out.write("        ");
System.out.print("This is test message to the server!!!");
      out.write("\n");
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
