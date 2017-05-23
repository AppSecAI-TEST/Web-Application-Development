/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dbUtils.DbConn;
import dbUtils.FormatUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hai
 */
public class purchaseView {
    /* This method returns a HTML table displaying all the records of the web_user table. 
     * cssClassForResultSetTable: the name of a CSS style that will be applied to the HTML table.
     *   (This style should be defined in the JSP page (header or style sheet referenced by the page).
     * dbc: an open database connection.
     */
    public static String listAllUsers(String cssTableClass, DbConn dbc) {
        // String type could have been used, but StringBuilder is more efficient 
        // in this case where we are just appending
        StringBuilder sb = new StringBuilder("");

        PreparedStatement stmt = null;
        ResultSet results = null;
        try {
            //sb.append("ready to create the statement & execute query " + "<br/>");
            //String sql = "select web_user_id, user_email, user_password, membership_fee, birthday from web_user";
            

            String sql = "SELECT buys_id, customer_id, spaceship_id, trans_cost, trans_date, trans_descrip, trans_quantity FROM sp17_3308_tug25055.purchase order by buys_id";
            stmt = dbc.getConn().prepareStatement(sql);
            results = stmt.executeQuery();
            //sb.append("executed the query " + "<br/><br/>");
            sb.append("<table class='");
            sb.append(cssTableClass);
            sb.append("'>");
            sb.append("<tr>");
            sb.append("<th style='text-align:right'>Purchase Id</th>");
            sb.append("<th style='text-align:right'>Customer ID</th>");
            sb.append("<th style='text-align:right'>Spaceship ID</th>");
            sb.append("<th style='text-align:right'>Cost</th>");
            sb.append("<th style='text-align:center'>Date</th>");
            sb.append("<th style='text-align:center'>Description</th>");
            sb.append("<th style='text-align:right'>Quantity</th></tr>");
            while (results.next()) {
                sb.append("<tr>");
                sb.append(FormatUtils.formatIntegerTd(results.getObject("buys_id")));             
                sb.append(FormatUtils.formatIntegerTd(results.getObject("customer_id")));
                sb.append(FormatUtils.formatIntegerTd(results.getObject("spaceship_id")));
                sb.append(FormatUtils.formatDoubleTd(results.getObject("trans_cost")));
                sb.append(FormatUtils.formatDateTd(results.getObject("trans_date")));
                sb.append(FormatUtils.formatStringTd(results.getObject("trans_descrip")));
                sb.append(FormatUtils.formatIntegerTd(results.getObject("trans_quantity")));
                sb.append("</tr>\n");
            }
            sb.append("</table>");
            results.close();
            stmt.close();
            return sb.toString();
        } catch (Exception e) {
            return "Exception thrown in WebUserSql.listAllUsers(): " + e.getMessage()
                    + "<br/> partial output: <br/>" + sb.toString();
        }
    }
}
