package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                <h2 style=\"text-align: center\">Intro</h2>\n");
      out.write("                <img src=\"pics/space-tourism.jpg\" id=\"homepageImg\"/>\n");
      out.write("                <p>\n");
      out.write("                    The year is 2217 and humankind have spread out through the stars. \n");
      out.write("                    Here at Named Space, we are building the future, the future you have in mind. \n");
      out.write("                    If you’ve ever wanted to find that home away from home then why not on settle on \n");
      out.write("                    another planet, or a comet, or a satellite, or a star? From the bustling metropolis \n");
      out.write("                    of Mars to the newly-built outposts in \n");
      out.write("                    <a href=\"https://en.wikipedia.org/wiki/Proxima_Centauri_b\"> Proxima Centauri b</a>, \n");
      out.write("                    the universe is your limit. \n");
      out.write("                    In our various interstellar spaceships, we outperform the competition in price, speed, \n");
      out.write("                    and comfortability. Cruise through the depths of space in our ships and explore the unknown. \n");
      out.write("                    What undreamt voyages will you pursue? What new wonders await your discovery? \n");
      out.write("                    The frontier is everywhere.\n");
      out.write("                </p> \n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "postContent.jsp", out, false);
      out.write('\n');
      out.write('\n');
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
