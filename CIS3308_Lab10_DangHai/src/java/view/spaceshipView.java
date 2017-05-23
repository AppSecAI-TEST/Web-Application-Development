/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dbUtils.DbConn;
import dbUtils.FormatUtils;
import dbUtils.SelectOption;
import dbUtils.SelectOptionList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Hai
 */
public class spaceshipView {
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
            

            String sql = "select modelName, modelYear, spaceship_id, modelType, price, maxCapacity, fuelCapacity, image_url from sp17_3308_tug25055.spaceship order by modelName";
            stmt = dbc.getConn().prepareStatement(sql);
            results = stmt.executeQuery();
            //sb.append("executed the query " + "<br/><br/>");
            sb.append("<table class='");
            sb.append(cssTableClass);
            sb.append("'>");
            sb.append("<tr>");
            sb.append("<th style='text-align:right'>Model Name</th>");
            sb.append("<th style='text-align:center'>Model Year</th>");
            sb.append("<th style='text-align:right'>Spaceship ID</th>");
            sb.append("<th style='text-align:left'>Model Type</th>");
            sb.append("<th style='text-align:right'>Price</th>");
            sb.append("<th style='text-align:right'>Max Capacity</th>");
            sb.append("<th style='text-align:right'>Fuel Capacity</th>");
            sb.append("<th style='text-align:center'>Image</th></tr>");
            while (results.next()) {
                sb.append("<tr>");
                sb.append(FormatUtils.formatStringTd(results.getObject("modelName")));             
                sb.append(FormatUtils.formatDateTd(results.getObject("modelYear")));
                sb.append(FormatUtils.formatIntegerTd(results.getObject("spaceship_id")));
                sb.append(FormatUtils.formatStringTd(results.getObject("modelType")));
                sb.append(FormatUtils.formatDoubleTd(results.getObject("price")));
                sb.append(FormatUtils.formatIntegerTd(results.getObject("maxCapacity")));
                sb.append(FormatUtils.formatDoubleTd(results.getObject("fuelCapacity")));
                sb.append(FormatUtils.formatImageTd(results.getObject("image_url")));
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
            

            String sql = "select modelName, modelYear, spaceship_id, modelType, price, maxCapacity, fuelCapacity, image_url from sp17_3308_tug25055.spaceship order by modelName";
            stmt = dbc.getConn().prepareStatement(sql);
            results = stmt.executeQuery();
            //sb.append("executed the query " + "<br/><br/>");
            sb.append("<table class='");
            sb.append(cssTableClass);
            sb.append("'>");
            sb.append("<tr>");
            sb.append("<th style='text-align:right'>Update</th>");
            sb.append("<th style='text-align:right'>Model Name</th>");
            sb.append("<th style='text-align:center'>Model Year</th>");
            sb.append("<th style='text-align:right'>Spaceship ID</th>");
            sb.append("<th style='text-align:left'>Model Type</th>");
            sb.append("<th style='text-align:right'>Price</th>");
            sb.append("<th style='text-align:right'>Max Capacity</th>");
            sb.append("<th style='text-align:right'>Fuel Capacity</th>");
            sb.append("<th style='text-align:center'>Image</th></tr>");
            while (results.next()) {
                sb.append("<tr>");
                String idVal = FormatUtils.formatInteger(results.getObject("spaceship_id"));
                String updateTag = "<td><a href='updateOther.jsp?id="+ idVal +"'><img src='pics/update.png'></a></td>";
                sb.append(updateTag);
                sb.append(FormatUtils.formatStringTd(results.getObject("modelName")));             
                sb.append(FormatUtils.formatDateTd(results.getObject("modelYear")));
                sb.append(FormatUtils.formatIntegerTd(results.getObject("spaceship_id")));
                sb.append(FormatUtils.formatStringTd(results.getObject("modelType")));
                sb.append(FormatUtils.formatDoubleTd(results.getObject("price")));
                sb.append(FormatUtils.formatIntegerTd(results.getObject("maxCapacity")));
                sb.append(FormatUtils.formatDoubleTd(results.getObject("fuelCapacity")));
                sb.append(FormatUtils.formatImageTd(results.getObject("image_url")));
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
    
    
    public static SelectOptionList getSpaceShipJson(DbConn dbc) {
        // String type could have been used, but StringBuilder is more efficient 
        // in this case where we are just appending
        SelectOptionList spaceshipList = new SelectOptionList();
        
        PreparedStatement stmt = null;
        ResultSet results = null;
        try {
            String sql = "select modelName, spaceship_id from sp17_3308_tug25055.spaceship order by modelName";

            stmt = dbc.getConn().prepareStatement(sql);
            results = stmt.executeQuery();
            
            spaceshipList.addOption(new SelectOption("0", "Select Spaceship"));
            while (results.next()) {
                String id = FormatUtils.formatInteger(results.getObject("spaceship_id"));
                String name = FormatUtils.formatString(results.getObject("modelName"));
                SelectOption spaceship = new SelectOption(id, name);
                spaceshipList.addOption(spaceship);
            }
            results.close();
            stmt.close();
        } catch (Exception e) {
            spaceshipList.dbError = e.getMessage();
        }
        
        return spaceshipList;
    }
    
    //has both delete and update
    public static String listWithDelete(String cssTableClass, DbConn dbc) {
        // String type could have been used, but StringBuilder is more efficient 
        // in this case where we are just appending
        StringBuilder sb = new StringBuilder("");

        PreparedStatement stmt = null;
        ResultSet results = null;
        try {
            //sb.append("ready to create the statement & execute query " + "<br/>");
            //String sql = "select web_user_id, user_email, user_password, membership_fee, birthday from web_user";
            

            String sql = "select modelName, modelYear, spaceship_id, modelType, price, maxCapacity, fuelCapacity, image_url from sp17_3308_tug25055.spaceship order by modelName";
            stmt = dbc.getConn().prepareStatement(sql);
            results = stmt.executeQuery();
            //sb.append("executed the query " + "<br/><br/>");
            sb.append("<table class='");
            sb.append(cssTableClass);
            sb.append("'>");
            sb.append("<tr>");
            sb.append("<th style='text-align:right'>Update</th>");
            sb.append("<th style='text-align:right'>Delete</th>");
            sb.append("<th style='text-align:right'>Model Name</th>");
            sb.append("<th style='text-align:center'>Model Year</th>");
            sb.append("<th style='text-align:right'>Spaceship ID</th>");
            sb.append("<th style='text-align:left'>Model Type</th>");
            sb.append("<th style='text-align:right'>Price</th>");
            sb.append("<th style='text-align:right'>Max Capacity</th>");
            sb.append("<th style='text-align:right'>Fuel Capacity</th>");
            sb.append("<th style='text-align:center'>Image</th></tr>");
            while (results.next()) {
                sb.append("<tr>");
                String idVal = FormatUtils.formatInteger(results.getObject("spaceship_id"));
                String updateTag = "<td><a href='updateOther.jsp?id="+ idVal +"'><img src='pics/update.png'></a></td>";
                sb.append(updateTag);
                String deleteTag = "<td><a href='other.jsp?deleteId="+ idVal +"'><img src='pics/delete.png'></a></td>";
                sb.append(deleteTag);
                sb.append(FormatUtils.formatStringTd(results.getObject("modelName")));             
                sb.append(FormatUtils.formatDateTd(results.getObject("modelYear")));
                sb.append(FormatUtils.formatIntegerTd(results.getObject("spaceship_id")));
                sb.append(FormatUtils.formatStringTd(results.getObject("modelType")));
                sb.append(FormatUtils.formatDoubleTd(results.getObject("price")));
                sb.append(FormatUtils.formatIntegerTd(results.getObject("maxCapacity")));
                sb.append(FormatUtils.formatDoubleTd(results.getObject("fuelCapacity")));
                sb.append(FormatUtils.formatImageTd(results.getObject("image_url")));
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
