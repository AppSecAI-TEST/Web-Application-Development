package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dbUtils.*;

public final class searchStarter_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Simple Validation</title>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                background-color:#CCCCCC;\n");
      out.write("                font-size: 14px;\n");
      out.write("                font-family:arial;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    ");


        // Strings to specify how to make the email select tag 
        String emailSelectTagName = "email";
        String emailSelectSql = "select customer_id, cus_loginName from sp17_3308_tug25055.customer order by cus_loginName";
        String emailFirstOption = "<option value='0'>Select User</option>";
        
        // This string will hold the generated email select tag
        String emailSelectTag = ""; // empty string unless we can get a good db connection.
        
        // This string will hold the value picked by the user  
        String userSelectedValue = ""; 
  
        String strAmtSpentMin = "";
        
        DbConn dbc = new DbConn();
        String msg = dbc.getErr();
        if (msg.length() == 0) {
            
            // This will be the select tag for first rendering (nothing pre-selected) 
            emailSelectTag = MakeTags.makeSelectTag(dbc, emailSelectTagName, emailSelectSql,
                    emailFirstOption, userSelectedValue);

            // Postback - persist user entered values
            if (request.getParameter("amtSpentMin") != null) {
                strAmtSpentMin = request.getParameter("amtSpentMin");
                userSelectedValue = request.getParameter(emailSelectTagName);
                // Here you have to recreate the emailSelectTag, passsing in a new parameter 
                // that shows what the user has already selected -- so the select tag persists.
                emailSelectTag = MakeTags.makeSelectTag(dbc, emailSelectTagName, emailSelectSql,
                    emailFirstOption, userSelectedValue);
            }
        }
        
        
        // This string will hold the generated email select tag
        String emailSelectTag2 = ""; // empty string unless we can get a good db connection.
        
        // This string will hold the value picked by the user  
        String userSelectedValue2 = ""; 
        String emailSelectTagName2 = "spaceship";
        String emailSelectSql2 = "select spaceship_id, modelName from  sp17_3308_tug25055.spaceship order by modelName";
        String emailFirstOption2 = "<option value='0'>Select User</option>";
        
        if (msg.length() == 0) {
            // This will be the select tag for first rendering (nothing pre-selected) 
            emailSelectTag2 = MakeTags.makeSelectTag(dbc, emailSelectTagName2, emailSelectSql2,
                    emailFirstOption2, userSelectedValue2);

            // Postback - persist user entered values
            if (request.getParameter("amtSpentMin") != null) {
                strAmtSpentMin = request.getParameter("amtSpentMin");
                userSelectedValue2 = request.getParameter(emailSelectTagName2);
                // Here you have to recreate the emailSelectTag, passsing in a new parameter 
                // that shows what the user has already selected -- so the select tag persists.
                emailSelectTag2 = MakeTags.makeSelectTag(dbc, emailSelectTagName2, emailSelectSql2,
                    emailFirstOption2, userSelectedValue2);
            }
        }

    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <h2>Search Activity (Starter Concepts)</h2>\n");
      out.write("        <form action=\"searchStarter.jsp\" method=\"get\">\n");
      out.write("            Show purchases where amount spent was over  \n");
      out.write("            <input name=\"amtSpentMin\" value=\"");
      out.print(strAmtSpentMin);
      out.write("\"/> \n");
      out.write("            <br/><br/>\n");
      out.write("            Show purchases made by user\n");
      out.write("            ");
      out.print(emailSelectTag);
      out.write("\n");
      out.write("            <br/><br/>\n");
      out.write("            Show product\n");
      out.write("            ");
      out.print(emailSelectTag2);
      out.write("\n");
      out.write("            <br/><br/>\n");
      out.write("            <input type=\"submit\" value=\"click me\"/>\n");
      out.write("        </form>\n");
      out.write("        <br/><br/>\n");
      out.write("        ");
      out.print(msg);
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
