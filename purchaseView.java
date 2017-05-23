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
            return "Exception thrown in purchaseView.listAllUsers(): " + e.getMessage()
                    + "<br/> partial output: <br/>" + sb.toString();
        }
    }
    
    
    
    //Lab 6: Search implementation 
    public static String search(String cssTableClass, DbConn dbc, String cusID, String spaceshipID, String startDate, String endDate){
         // String type could have been used, but StringBuilder is more efficient 
        // in this case where we are just appending
        StringBuilder sb = new StringBuilder("");
        
        PreparedStatement pStatement = null;
        ResultSet results = null;
        int customer_id = 1;
        int spaceship_id = 1;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM sp17_3308_tug25055.customer, "
                    + "sp17_3308_tug25055.spaceship, sp17_3308_tug25055.purchase "
                    + "WHERE customer.customer_id = purchase.customer_id "
                    + "AND spaceship.spaceship_id = purchase.spaceship_id ";
            System.out.println("----> Sql is generated");
                       
            
            //Check fields aren't empty, if not, add query
            /*
            if(cusEmail.length() != 0){
                sql += "AND cus_loginName = ? ";
                System.out.println("Customer Email.length = " + cusEmail.length() + " " + cusEmail);
            } 
            if(spaceshipName.length() != 0){
                sql += "AND modelName = ? ";
                System.out.println("spaceship.length = " + spaceshipName.length() + " " + spaceshipName);
            }
            */
            if(cusID != null && cusID.length() == 0  && spaceshipID != null && spaceshipID.length()== 0){
                customer_id = Integer.parseInt(cusID);
                spaceship_id = Integer.parseInt(spaceshipID);
                flag = false;
            } else {
                flag = true;
            }
            //Add the query statements
            if(flag && customer_id != 0){
                sql += "AND customer.customer_id = ? ";
                System.out.println("Customer ID = " + customer_id);
            } 
            if(flag && spaceshipID.length() != 0){
                sql += "AND spaceship.spaceship_id = ? ";
                System.out.println("spaceship ID = " + spaceship_id);
            }
            
            if(startDate.length() != 0){
                sql += "AND trans_date > ? ";
                System.out.println("startDate.length = " + startDate.length() + " " + startDate);
            }
            if(endDate.length() != 0){
                sql += "AND trans_date < ? ";
                System.out.println("endDate.length = " + endDate.length() + " " + endDate);
            }   
                    
            pStatement = dbc.getConn().prepareStatement(sql);
            System.out.println("----> Statement is prepared");
            
            //Input fields into select statement
            int count = 1;            
            /*
            if(cusEmail.length() != 0){
                pStatement.setString(count, cusEmail);
                System.out.print("--------> cusEmail sql ");
                count++;
            } 
            if(spaceshipName.length() != 0){
                pStatement.setString(count, spaceshipName);                
                System.out.print("--------> spaceshipName sql ");
                count++;
            }
            */
            if(flag && customer_id != 0){
                pStatement.setInt(count, customer_id);
                System.out.print("--------> cus id sql ");
                count++;
            } 
            if(flag && spaceshipID.length() != 0){
                pStatement.setInt(count, spaceship_id);
                System.out.print("--------> spaceship id sql ");
                count++;
            }
            if(startDate.length() != 0){
                pStatement.setString(count, startDate);
                System.out.print("--------> startDate sql ");
                count++;
            }
            if(endDate.length() != 0){
                pStatement.setString(count, endDate);
                System.out.print("--------> endDate sql ");
                count++;
            }
            
            System.out.println("----> Statement: " + sql);
            
            results = pStatement.executeQuery();
            
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
            pStatement.close();
            return sb.toString();
        } catch (Exception e) {
            return "Exception thrown in purchaseView.search(): " + e.getMessage()
                    + "<br/> partial output: <br/>" + sb.toString();
        }
    }
}
