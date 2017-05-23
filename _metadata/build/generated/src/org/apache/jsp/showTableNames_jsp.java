package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import dbUtils.DbConn;

public final class showTableNames_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Metadata: Tablename Hard Coded</title>\n");
      out.write("        <style type=\"text/CSS\">\n");
      out.write("            body {\n");
      out.write("                background-color:#DDDDDD;\n");
      out.write("                font-family: Verdana, Geneva, Sans-Serif; \n");
      out.write("            }\n");
      out.write("            .resultSetFormat {    background-color:#AAAAAA;}\n");
      out.write("            .resultSetFormat th { background-color:powderblue; padding:5px;}\n");
      out.write("            .resultSetFormat td { background-color:aliceblue; padding:5px;}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");


            DbConn dbc = new DbConn();
            String msg = dbc.getErr();
            if (msg.length() == 0) { // db connection is good

                try { // to create and execute sql
                    
                    //String sql = "SELECT * FROM information_schema.tables WHERE table_schema != 'information_schema'";
                    String sql = "SELECT * FROM information_schema.tables WHERE table_schema = ?";
                    PreparedStatement st = dbc.getConn().prepareStatement(sql);
                    st.setString(1, dbc.getDbName());
                    ResultSet results = st.executeQuery();
                    ResultSetMetaData rsMetaData = results.getMetaData();
                    int numColumns = rsMetaData.getColumnCount();

                    // create an HTML table that shows the most important metadata attributes
                    // of each column from the specified table.
                    msg += ("<table  class='resultSetFormat'><tr>");

                    // NOTE: iterates from 1 .. numberOfColumns.
                    for (int i = 1; i <= numColumns; i++) {
                        msg += "<th>" + rsMetaData.getColumnName(i).toLowerCase() + "</th>";
                    }

                    Object objColVal="";  
                    String strColVal;
                    while (results.next()) {
                        msg += "<tr>";
                        for (int i = 1; i <= numColumns; i++) {
                            objColVal = results.getObject(i);
                            if (objColVal == null) {
                                strColVal="null";
                            } else {
                                strColVal = objColVal.toString();
                            }
                            msg += ("<td>" + strColVal + "</td>");
                        }
                        msg += "</tr>";
                    }
                    msg += ("</table>");
                }// try to create and execute sql
                catch (Exception e) {
                    msg += ("problem creating statement or running query:" + e.getMessage() + "<br/>");

                }
            }
            dbc.close();
        
      out.write("\n");
      out.write("        <h2>List of Tables (Meta Data)</h2>\n");
      out.write("\n");
      out.write("        ");
      out.print(msg);
      out.write(" \n");
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
