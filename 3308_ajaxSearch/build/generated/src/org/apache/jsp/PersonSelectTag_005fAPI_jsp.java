package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.google.gson.*;
import dbUtils.*;

public final class PersonSelectTag_005fAPI_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("application/json; charset=UTF-8");
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
      out.write("\n");

    /* 
    Note (in the 1st line of this file) that Web API JSP pages have a different contentType 
    (application/json). A JSP page would have contentType "text/html"

    The com.google.gson import line (line 3 above) references the GSON that should 
    have been added as a jar file to your project Libraries. 
    */
    
    SelectOptionList personList = new SelectOptionList();
    personList.addOption(new SelectOption("0", "Select Person"));
    personList.addOption(new SelectOption("3", "Bamm Bamm"));
    personList.addOption(new SelectOption("9", "Barney Rubble"));
    personList.addOption(new SelectOption("4", "Betty Rubble"));
    personList.addOption(new SelectOption("2", "Fred Flintstone"));
    personList.addOption(new SelectOption("7", "Pebbles"));
    personList.addOption(new SelectOption("1", "Wilma Flintstone"));

    Gson gson = new Gson();
    out.print(gson.toJson(personList).trim());

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
