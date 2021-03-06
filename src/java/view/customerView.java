/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dbUtils.DbConn;
import dbUtils.FormatUtils;
import dbUtils.SelectOptionList;
import dbUtils.SelectOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Customers.StringData;

/**
 *
 * @author tug25055
 */
public class customerView {
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
            String sql = "select customer_id, firstName, lastName, cus_loginName, cus_password, cus_username, cus_DOB, user_role " 
                    + "from sp17_3308_tug25055.customer, sp17_3308_tug25055.user_role " 
                    + "where customer.user_role_id = user_role.user_role_id order by lastName, firstName";
            stmt = dbc.getConn().prepareStatement(sql);
            results = stmt.executeQuery();
            //sb.append("executed the query " + "<br/><br/>");
            sb.append("<table class='");
            sb.append(cssTableClass);
            sb.append("'>");
            sb.append("<tr>");
            sb.append("<th style='text-align:right'>Customer ID</th>");
            sb.append("<th style='text-align:left'>First Name</th>");
            sb.append("<th style='text-align:left'>Last Name</th>");
            sb.append("<th style='text-align:left'>Login Name</th>");
            sb.append("<th style='text-align:left'>Password</th>");
            sb.append("<th style='text-align:left'>Username</th>");
            sb.append("<th style='text-align:center'>DOB</th>");
            sb.append("<th style='text-align:center'>User Role</th></tr>");
            while (results.next()) {
                sb.append("<tr>");
                sb.append(FormatUtils.formatIntegerTd(results.getObject("customer_id")));
                sb.append(FormatUtils.formatStringTd(results.getObject("firstName")));
                sb.append(FormatUtils.formatStringTd(results.getObject("lastName")));
                sb.append(FormatUtils.formatStringTd(results.getObject("cus_loginName")));
                sb.append(FormatUtils.formatStringTd(results.getObject("cus_password")));
                sb.append(FormatUtils.formatStringTd(results.getObject("cus_username")));
                sb.append(FormatUtils.formatDateTd(results.getObject("cus_DOB")));
                sb.append(FormatUtils.formatStringTd(results.getObject("user_role")));
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
    
    
    public static String listWithUpdate(String cssTableClass, DbConn dbc) {

        // String type could have been used, but StringBuilder is more efficient 
        // in this case where we are just appending
        StringBuilder sb = new StringBuilder("");

        PreparedStatement stmt = null;
        ResultSet results = null;
        try {
            //sb.append("ready to create the statement & execute query " + "<br/>");
            //String sql = "select web_user_id, user_email, user_password, membership_fee, birthday from web_user";
            String sql = "select customer_id, firstName, lastName, cus_loginName, cus_password, cus_username, cus_DOB, user_role " 
                    + "from sp17_3308_tug25055.customer, sp17_3308_tug25055.user_role " 
                    + "where customer.user_role_id = user_role.user_role_id order by lastName, firstName";
            stmt = dbc.getConn().prepareStatement(sql);
            results = stmt.executeQuery();
            //sb.append("executed the query " + "<br/><br/>");
            sb.append("<table class='");
            sb.append(cssTableClass);
            sb.append("'>");
            sb.append("<tr>");
            sb.append("<th style='text-align:right'>Update</th>");
            sb.append("<th style='text-align:right'>Customer ID</th>");
            sb.append("<th style='text-align:left'>First Name</th>");
            sb.append("<th style='text-align:left'>Last Name</th>");
            sb.append("<th style='text-align:left'>Login Name</th>");
            sb.append("<th style='text-align:left'>Password</th>");
            sb.append("<th style='text-align:left'>Username</th>");
            sb.append("<th style='text-align:center'>DOB</th>");
            sb.append("<th style='text-align:center'>User Role</th></tr>");
            while (results.next()) {
                sb.append("<tr>");
                String idVal = FormatUtils.formatInteger(results.getObject("customer_id"));
                String updateTag = "<td><a href='updateUser.jsp?id="+ idVal +"'><img src='pics/update.png'></a></td>";
                sb.append(updateTag);
                sb.append(FormatUtils.formatIntegerTd(results.getObject("customer_id")));
                sb.append(FormatUtils.formatStringTd(results.getObject("firstName")));
                sb.append(FormatUtils.formatStringTd(results.getObject("lastName")));
                sb.append(FormatUtils.formatStringTd(results.getObject("cus_loginName")));
                sb.append(FormatUtils.formatStringTd(results.getObject("cus_password")));
                sb.append(FormatUtils.formatStringTd(results.getObject("cus_username")));
                sb.append(FormatUtils.formatDateTd(results.getObject("cus_DOB")));
                sb.append(FormatUtils.formatStringTd(results.getObject("user_role")));
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
    
    
    public static SelectOptionList getCustomerJson(DbConn dbc) {
        // String type could have been used, but StringBuilder is more efficient 
        // in this case where we are just appending
        SelectOptionList customerList = new SelectOptionList();
        
        PreparedStatement stmt = null;
        ResultSet results = null;
        try {
            String sql = "select customer_id, firstName, lastName, cus_loginName, cus_password, cus_username, cus_DOB, user_role " 
                    + "from sp17_3308_tug25055.customer, sp17_3308_tug25055.user_role " 
                    + "where customer.user_role_id = user_role.user_role_id order by lastName, firstName";
            stmt = dbc.getConn().prepareStatement(sql);
            results = stmt.executeQuery();
            
            customerList.addOption(new SelectOption("0", "Select Customer"));
            while (results.next()) {
                String id = FormatUtils.formatInteger(results.getObject("customer_id"));
                String email = FormatUtils.formatString(results.getObject("cus_loginName"));
                SelectOption customer = new SelectOption(id, email);
                customerList.addOption(customer);
            }
            results.close();
            stmt.close();
        } catch (Exception e) {
            customerList.dbError = e.getMessage();
        }
        
        return customerList;
    }
    
    
    public static String listWithDelete(String cssTableClass, DbConn dbc) {

        // String type could have been used, but StringBuilder is more efficient 
        // in this case where we are just appending
        StringBuilder sb = new StringBuilder("");

        PreparedStatement stmt = null;
        ResultSet results = null;
        try {
            //sb.append("ready to create the statement & execute query " + "<br/>");
            //String sql = "select web_user_id, user_email, user_password, membership_fee, birthday from web_user";
            String sql = "select customer_id, firstName, lastName, cus_loginName, cus_password, cus_username, cus_DOB, user_role " 
                    + "from sp17_3308_tug25055.customer, sp17_3308_tug25055.user_role " 
                    + "where customer.user_role_id = user_role.user_role_id order by lastName, firstName";
            stmt = dbc.getConn().prepareStatement(sql);
            results = stmt.executeQuery();
            //sb.append("executed the query " + "<br/><br/>");
            sb.append("<table class='");
            sb.append(cssTableClass);
            sb.append("'>");
            sb.append("<tr>");
            sb.append("<th style='text-align:right'>Update</th>");
            sb.append("<th style='text-align:right'>Delete</th>");
            sb.append("<th style='text-align:right'>Customer ID</th>");
            sb.append("<th style='text-align:left'>First Name</th>");
            sb.append("<th style='text-align:left'>Last Name</th>");
            sb.append("<th style='text-align:left'>Login Name</th>");
            sb.append("<th style='text-align:left'>Password</th>");
            sb.append("<th style='text-align:left'>Username</th>");
            sb.append("<th style='text-align:center'>DOB</th>");
            sb.append("<th style='text-align:center'>User Role</th></tr>");
            while (results.next()) {
                sb.append("<tr>");
                String idVal = FormatUtils.formatInteger(results.getObject("customer_id"));
                String updateTag = "<td><a href='updateUser.jsp?id="+ idVal +"'><img src='pics/update.png'></a></td>";
                sb.append(updateTag);
                String deleteTag = "<td><a href='users.jsp?deleteId="+ idVal +"'><img src='pics/delete.png'></a></td>";
                sb.append(deleteTag);
                sb.append(FormatUtils.formatIntegerTd(results.getObject("customer_id")));
                sb.append(FormatUtils.formatStringTd(results.getObject("firstName")));
                sb.append(FormatUtils.formatStringTd(results.getObject("lastName")));
                sb.append(FormatUtils.formatStringTd(results.getObject("cus_loginName")));
                sb.append(FormatUtils.formatStringTd(results.getObject("cus_password")));
                sb.append(FormatUtils.formatStringTd(results.getObject("cus_username")));
                sb.append(FormatUtils.formatDateTd(results.getObject("cus_DOB")));
                sb.append(FormatUtils.formatStringTd(results.getObject("user_role")));
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
