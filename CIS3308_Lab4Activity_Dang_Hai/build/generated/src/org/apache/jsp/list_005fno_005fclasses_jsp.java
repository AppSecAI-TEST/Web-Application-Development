package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class list_005fno_005fclasses_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                background-color: khaki;\n");
      out.write("                font-family: verdana, sans-serif;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            table {\n");
      out.write("                background-color: chocolate; \n");
      out.write("            }\n");
      out.write("            th {\n");
      out.write("                background-color: brown;\n");
      out.write("                color: white;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            td {\n");
      out.write("                background-color: beige; \n");
      out.write("            }\n");
      out.write("            th, td {\n");
      out.write("                padding: 3px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Connection con = null; // "telephone call" between web app and the db mgt system
            PreparedStatement stmt = null; // holds the SQL statement the web app wants to run
            ResultSet results = null;  // holds the data that results from executing the SQL SELECT statement.

            out.println("<br/>ready to get the driver... <br/>");
            try { // to find the driver

                String DRIVER = "com.mysql.jdbc.Driver";
                Class.forName(DRIVER).newInstance();
                out.println("got the driver... <br/>");

                try { // to get the connection

                    // Use this URL if you are working from the CIS dept (no tunnelling).                      
                    //String url = "jdbc:mysql://cis-linux2.temple.edu:3306/SP11_2308_sallyk?user=sallyk&password=Vaca1415";  
                    // Use this URL if you are working from home, but you must be "tunnelled in" to the CIS network
                    String url = "jdbc:mysql://localhost:3307/SP11_2308_sallyk?user=sallyk&password=Vaca1415";

                    con = DriverManager.getConnection(url);
                    out.println("got the connection with the db..." + "<br/>");

                    try {
                        String sql = "select user_email, user_password from web_user order by user_email";
                        stmt = con.prepareStatement(sql);
                        results = stmt.executeQuery();

                        out.println("executed the query <br/><br/>");
                        out.println("<table>");
                        out.println("<tr><th>User Email</th><th>User Password</th></tr>");
                        while (results.next()) {
                            out.print("<tr>");
                            out.print("<td>" + results.getString("user_email") + "</td>");
                            out.print("<td>" + results.getString("user_password") + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</table>");
                        out.println("<br/>All Done !! ");
                        results.close();  // close the result set
                        stmt.close(); // close the statement
                    } catch (Exception e) {
                        out.println("problem creating statement & running query:" + e.getMessage() + "<br/>");
                        results.close();  // close the result set
                        stmt.close(); // close the statement (this is only important if you wanted to reuse the connection)
                    }
                } catch (Exception e) {
                    out.println("problem getting connection:" + e.getMessage() + "<br/>");
                }
            } catch (Exception e) {
                out.println("problem getting driver:" + e.getMessage() + "<br/>");
            }

// close database connection -- NO DATABASE CONNECTION LEAKS !!!
            if (con != null) {
                try {
                    con.close();
                    out.println("Database connection was closed.");
                } catch (Exception e) {
                    out.println("Exception trying to close the database connection: " + e.getMessage());
                }
            } else {
                out.println("Database connection was never opened.");
            }
        
      out.write("\n");
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
