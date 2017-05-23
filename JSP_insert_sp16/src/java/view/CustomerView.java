package view;

// classes imported from java.sql.*
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// classes in my project
import dbUtils.DbConn;
import dbUtils.FormatUtils;

public class CustomerView {

    /* This method returns a HTML table displaying all the records of the web_user table. 
     * cssClassForResultSetTable: the name of a CSS style that will be applied to the HTML table.
     *   (This style should be defined in the JSP page (header or style sheet referenced by the page).
     * dbc: an open database connection.
     */
    
    
    /*
    public static String customerListDeleteUpdate(String deleteIcon, String deleteFn,
            String updateIcon, String updateURL, String cssClassForTable, DbConn dbc) {
        return customersByNameView(deleteIcon, deleteFn, updateIcon, updateURL, cssClassForTable, dbc);
    }

    public static String customerListUpdate(String updateIcon, String updateURL,
            String cssClassForTable, DbConn dbc) {
        return customersByNameView("", "", updateIcon, updateURL, cssClassForTable, dbc);
    }
    */

    public static String customersByName(String cssClassForTable, DbConn dbc) {
        return customersByNameView("", "", "", "", cssClassForTable, dbc);
    }

    /* This method returns a HTML table displaying all the records of the web_user table. 
     * cssClassForResultSetTable: the name of a CSS style that will be applied to the HTML table.
     *   (This style should be defined in the JSP page (header or style sheet referenced by the page).
     * dbc: an open database connection.
     */
    private static String customersByNameView(String deleteIcon, String deleteFn,
        String updateIcon, String updateURL, String cssClassForTable, DbConn dbc) {
        
        StringBuilder sb = new StringBuilder("");
        PreparedStatement stmt = null;
        ResultSet results = null;
        try {

            String sql = "select customer_id, first_name, last_name, email_address, pwd, credit_limit "
                    + " from customer order by last_name, first_name, email_address";

            stmt = dbc.getConn().prepareStatement(sql);
            results = stmt.executeQuery();

            sb.append("<table class='");
            sb.append(cssClassForTable);
            sb.append("'>\n");
            sb.append("<tr>");
            if (deleteFn.length() > 0) {
                sb.append("<th style='background-color:transparent;border:none;'> </th>");
            }
            if (updateURL.length() > 0) {
                sb.append("<th style='background-color:transparent;border:none;'> </th>");
            }
            sb.append("<th>Id</th><th>Last Name</th><th>First Name</th>"
                    + "<th>Email</th><th>Password</th><th>Credit Limit</th></tr>\n");

            while (results.next()) {
                sb.append("<tr>");
                String custId = results.getString("customer_id");
                if (deleteFn.length() > 0) {
                    sb.append("<td style='background-color:transparent;border:none;'><a href='javascript:" + deleteFn +
                            "("+ custId + ")'><img src='" + deleteIcon + "'></a> </td>");
                }
                if (updateURL.length() > 0) {
                    sb.append("<td style='background-color:transparent;border:none;'><a href='" + updateURL + "=" +
                            custId + "'><img src='" + updateIcon + "'></a> </td>");
                }
                sb.append("<td style='text-align:right'>" + custId + "</td>");
                sb.append("<td>" + results.getString("last_name") + "</td>");
                sb.append("<td>" + results.getString("first_name") + "</td>");
                sb.append("<td>" + results.getString("email_address") + "</td>");
                sb.append("<td>" + results.getString("pwd") + "</td>");
                sb.append(FormatUtils.formatDollarTd(results.getObject("credit_limit")));
                sb.append("</tr>\n");
            }
            sb.append("</table>\n");
            results.close();
            stmt.close();
            return sb.toString();
        } catch (Exception e) {
            return "Exception thrown in CustomerView.CustomersByName(): " + e.getMessage()
                    + "<br/> partial output: <br/>" + sb.toString();
        }
    }
}
