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
      out.write("            <div style=\"padding: 5%\">\n");
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
      out.write("                parsing the result set specifically for datatypes of type double and one uniquely for images. \n");
      out.write("                Click this link to see my <a href=\"users.jsp\" style=\"text-decoration: none;\"> users page</a>,\n");
      out.write("                this link to see my <a href=\"other.jsp\" style=\"text-decoration: none;\"> others page</a>,\n");
      out.write("                or this link to see my <a href=\"assoc.jsp\" style=\"text-decoration: none;\"> associative page</a>.  \n");
      out.write("                </p>\n");
      out.write("                \n");
      out.write("                <h2 class=\"labName\">Lab 5: Logon Lab</h2>\n");
      out.write("                <p class=\"labDescrip\">This topic of this lab involved the understanding of the REST design philosophy and \n");
      out.write("                    implementing data persistence among pages. The easy part of this lab was more of the backend where \n");
      out.write("                    it wasn't that hard to write the prepared statement and retrieve the result set given the sample code \n");
      out.write("                    and similarity to the last lab. However I found that one problem was with debugging where the errors \n");
      out.write("                    displayed on the webpage were somewhat useful but still a challenge to approach. Overall, I really had fun \n");
      out.write("                    designing the dynamic ui based on stored session and understanding how this all comes together. \n");
      out.write("                </p>\n");
      out.write("                \n");
      out.write("                <h2 class=\"labName\">Lab 6: JSP Search</h2>\n");
      out.write("                <p class=\"labDescrip\">For this lab I learned how to persist data on a form and how to perform a search along \n");
      out.write("                    with using prepared statements. Writing the jsp servlet file wasn't too bad considering that it was done \n");
      out.write("                    during the lab activity. However an error that I approached was with the order I wrote the prepared \n");
      out.write("                    statements before inputting user values which was an easy fix. Another challenging aspect was getting \n");
      out.write("                    the user selected value passed from the jsp page to the server since the form only returned the value \n");
      out.write("                    in the request so I had to use the form value and match that with the table id on the server side. \n");
      out.write("                    Overall, I really had fun this was a very interesting lab. \n");
      out.write("                    Click here to see my <a href = \"search.jsp\" style=\"text-decoration: none;\">search page</a>.\n");
      out.write("                </p>\n");
      out.write("                \n");
      out.write("                <h2 class=\"labName\">Lab 7: Insert Lab</h2>\n");
      out.write("                <p class=\"labDescrip\">In this lab, I learned how to create an insert into my database and utilized the techniques \n");
      out.write("                    I learned from previous weeks to persist my data and pass in selected values. The challenging part for \n");
      out.write("                    me was with the associative table. The problem was I wanted to timestamp each transaction at time of\n");
      out.write("                    submission. Even more difficult was that I also wanted to calculate the total cost of the transaction as \n");
      out.write("                    a function of product price multiplied with the quantity ordered. Eventually I figured it out by doing \n");
      out.write("                    another call in the backend and returning back the individual price from the other table to be used \n");
      out.write("                    for computation. Another difficulty was trying to figure out how to incorporate login into the \n");
      out.write("                    associative table and figuring out how to get back that session data. In conclusion, I managed to\n");
      out.write("                    get all of this to work and I learned a lot.\n");
      out.write("                    Click this link to see my <a href=\"insertUser.jsp\" style=\"text-decoration: none;\">insertUser.jsp</a>,\n");
      out.write("                    this link to see my <a href=\"insertOther.jsp\" style=\"text-decoration: none;\">insertOther.jsp</a>,\n");
      out.write("                    or this link to see my <a href=\"insertAssoc.jsp\" style=\"text-decoration: none;\">insertAssoc.jsp</a>.  \n");
      out.write("                </p>\n");
      out.write("                \n");
      out.write("                <h2 class=\"labName\">Lab 8: Update Lab</h2>\n");
      out.write("                <p class=\"labDescrip\">For the lab, I made an update feature to my project which was very similar to the last lab. \n");
      out.write("                    The challenging part for me was manipulating the the select tag to persist the respective value from the \n");
      out.write("                    database. Another part that was hard was getting the double value back as a string value without \n");
      out.write("                    the commas. This was actually an easy fix where I just made another formatter which excluded these \n");
      out.write("                    commas. Overall the lab was easy considering that the majority of it was done for the lab activity.\n");
      out.write("                    The frontend work for this lab can be seen in the links below. In order to apply the update, navigate to \n");
      out.write("                    the Customer, Spaceship, or Buys tab and click on the update icon.\n");
      out.write("                </p>\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"updateUser.jsp\" style=\"text-decoration: none;\">updateUser.jsp</a></li>\n");
      out.write("                    <li><a href=\"updateOther.jsp\" style=\"text-decoration: none;\">updateOther.jsp</a></li>\n");
      out.write("                    <li><a href=\"updateAssoc.jsp\" style=\"text-decoration: none;\">updateAssoc.jsp</a></li> \n");
      out.write("                </ul>\n");
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
