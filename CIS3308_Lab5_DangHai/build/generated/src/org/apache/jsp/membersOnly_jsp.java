package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Customers.StringData;

public final class membersOnly_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String msg = "";
    if(session.getAttribute("user") != null){
        StringData strData = (StringData) session.getAttribute("user");
        System.out.print("Successful member page login.");
            msg = "Welcome " + strData.firstName + ", you're logged in. <br/>"
                    + "<img src=\"http://www.pngmart.com/files/3/Spaceship-Transparent-Background-279x279.png\" alt=\"rocket\"";
    } else {
        msg = "<b> Sorry you are not a member. You are not permitted to be here.</b> <br/>"
                + "To enter, please <b> <a href=\"logon.jsp\" "
                + "class=\"linkElement\">Login</a> </b>.";
        System.out.print("Successful member page login.");
    }

      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "toHead.jsp", out, false);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "headToContent.jsp", out, false);
      out.write("\n");
      out.write("                <div class=\"formTable\">\n");
      out.write("                    ");
      out.print(msg);
      out.write("\n");
      out.write("                </div>\n");
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
