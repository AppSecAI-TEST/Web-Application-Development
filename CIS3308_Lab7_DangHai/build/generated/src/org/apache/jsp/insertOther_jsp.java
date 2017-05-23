package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dbUtils.DbConn;
import model.Spaceships.*;
import dbUtils.*;

public final class insertOther_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            // Declare all Strings and objects as they should be if it is first rendering
            StringData inputData = new StringData(); // all properties empty string, good for first rendering
            StringData errorMsgs = new StringData(); // all properties empty string, good for first rendering


            //Create DBC connection
            DbConn dbc = new DbConn();
            String msg = dbc.getErr();
            if (msg.length() == 0) {
                if (request.getParameter("modelNameInput") != null) { // this is postback
                    // package up Customer String data
                    inputData.modelName = request.getParameter("modelNameInput");
                    inputData.modelYear = request.getParameter("modelYearInput");
                    inputData.modelType = request.getParameter("modelTypeInput");
                    inputData.maxCapacity = request.getParameter("maxCapacityInput");
                    inputData.spaceshipPrice = request.getParameter("spaceshipPriceInput");
                    inputData.imageUrl = request.getParameter("imageUrlInput");
                    inputData.fuelCapacity = request.getParameter("fuelCapacityInput");
                    
                    // Get db connection and make sure it worked.
                    //DbConn dbc = new DbConn();
                    errorMsgs.errorMsg = dbc.getErr();

                    if (errorMsgs.errorMsg.length() == 0) {
                        // DB connection is good
                        errorMsgs = DbCusMods.insert(inputData, dbc); // errorMsgs will hold all validation messags
                        if (errorMsgs.errorMsg.length() == 0) { // this is the form level error message
                            // replace empty string with successful message
                            errorMsgs.errorMsg = "Record successfully inserted !";
                        }
                    } // if db connection is good
                }
                dbc.close(); // no database connection leaks !
            } // postback
            
        
      out.write("\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "toHead.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "headToContent.jsp", out, false);
      out.write("\n");
      out.write("            <h3>Insert Spaceship - <span class='headerLink'><a href=\"other.jsp\">List All</a></span></h3>\n");
      out.write("\n");
      out.write("            <form action =\"insertOther.jsp\" method=\"get\">\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Model Name</td>\n");
      out.write("                        <td><input type=\"text\"  name=\"modelNameInput\" value=\"");
      out.print(inputData.modelName);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.modelName);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Model Year</td>\n");
      out.write("                        <td><input type=\"text\" name=\"modelYearInput\" value=\"");
      out.print(inputData.modelYear);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.modelYear);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Model Type</td>\n");
      out.write("                        <td><input type=\"text\" name=\"modelTypeInput\" value=\"");
      out.print(inputData.modelType);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.modelType);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Max Capacity</td>\n");
      out.write("                        <td><input type=\"text\" name=\"maxCapacityInput\" value=\"");
      out.print(inputData.maxCapacity);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.maxCapacity);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Price</td>\n");
      out.write("                        <td><input type=\"text\" name=\"spaceshipPriceInput\" value=\"");
      out.print(inputData.spaceshipPrice);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.spaceshipPrice);
      out.write("</td> \n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Image URL</td>\n");
      out.write("                        <td><input type=\"text\" name=\"imageUrlInput\" value=\"");
      out.print(inputData.imageUrl);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.imageUrl);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Fuel Capacity</td>\n");
      out.write("                        <td><input type=\"text\" name=\"fuelCapacityInput\" value=\"");
      out.print(inputData.fuelCapacity);
      out.write("\"/></td>\n");
      out.write("                        <td class=\"error\">");
      out.print(errorMsgs.fuelCapacity);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td style=\"text-align:center;\"><input type=\"submit\" value=\"Submit\"/></td>\n");
      out.write("                        <td class=\"error\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("            <br/>\n");
      out.write("            <strong>");
      out.print(errorMsgs.errorMsg);
      out.write("</strong>  \n");
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
