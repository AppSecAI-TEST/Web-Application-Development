package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import view.metadataView;
import dbUtils.DbConn;
import dbUtils.*;

public final class listFields_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            // Declare all Strings and objects as they should be if it is first rendering
            //StringData inputData = new StringData(); // all properties empty string, good for first rendering
            //StringData errorMsgs = new StringData(); // all properties empty string, good for first rendering

            // This string will hold the generated email select tag
            String metaSelectTag = ""; // empty string unless we can get a good db connection.

            // Strings to specify how to make the email select tag 
            String metaSelectTagName = "meta";
            String metaSelectSql = "SELECT TABLE_NAME FROM information_schema.tables WHERE table_schema = 'sp17_3308_tug25055'";
            String metaFirstOption = "<option value='0'>Select User Type</option>";

            // This string will hold the value picked by the user  
            String userSelectedValue = ""; 

            //Create DBC connection
            DbConn dbc = new DbConn();
            String msg = dbc.getErr();
            if (msg.length() == 0) {

                // This will be the select tag for first rendering (nothing pre-selected) 
                metaSelectTag = MakeTags.makeMetaSelectTag(dbc, metaSelectTagName, metaSelectSql,
                        metaFirstOption, userSelectedValue);

                 // Postback - persist user entered values
                if (request.getParameter(metaSelectTagName) != null ) {

                    //Table
                    userSelectedValue = request.getParameter("meta");
                    System.out.println("Meta: " + userSelectedValue);
                    metaSelectTag = MakeTags.makeMetaSelectTag(dbc, metaSelectTagName, metaSelectSql,
                        metaFirstOption, userSelectedValue);
                    
                    //Make the table
                    msg = metadataView.listAllMetaData("resultSet", dbc, userSelectedValue);
                } else {
                    System.out.println("Null meta: " + userSelectedValue);
                }

            } //postback
            else {
                msg = "Error establishing database connection.";
            }  
            dbc.close(); // no database connection leaks !
            
        
      out.write("\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "toHead.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "headToContent.jsp", out, false);
      out.write("\n");
      out.write("            <h2 style=\"text-align: center; color: white\">Metadata - <span class='headerLink'><a href=\"users.jsp\">List All</a></span></h2>\n");
      out.write("\n");
      out.write("            <form action =\"listFields.jsp\" method=\"get\" class=\"insertTable\">\n");
      out.write("                <table class=\"insertTableCenter\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Meta Table List</td>\n");
      out.write("                        <td>");
      out.print(metaSelectTag);
      out.write("</td>\n");
      out.write("                        <td class=\"error\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td><input type=\"submit\" value=\"Submit\"/></td>\n");
      out.write("                        <td class=\"error\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("            <br/>\n");
      out.write("            ");
      out.print(msg);
      out.write('\n');
      out.write('\n');
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
