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
import java.sql.ResultSetMetaData;

/**
 *
 * @author Hai
 */
public class metadataView {
    public static String listAllMetaData(String cssTableClass, DbConn dbc, String tableName) {

        // String type could have been used, but StringBuilder is more efficient 
        // in this case where we are just appending
        StringBuilder sb = new StringBuilder("");

        PreparedStatement stmt = null;
        ResultSet results = null;
        try {
            //sb.append("ready to create the statement & execute query " + "<br/>");
            //String sql = "select web_user_id, user_email, user_password, membership_fee, birthday from web_user";
            String sql = "SELECT * FROM " + tableName + " WHERE 0=1";
            stmt = dbc.getConn().prepareStatement(sql);
            results = stmt.executeQuery();
            ResultSetMetaData rsMetaData = results.getMetaData();
            int numCol = rsMetaData.getColumnCount();
            //sb.append("executed the query " + "<br/><br/>");
            sb.append("<table class='");
            sb.append(cssTableClass);
            sb.append("'>");
            sb.append("<tr>");
            sb.append("<th style='text-align:right'>Column Name</th>");
            sb.append("<th style='text-align:left'>Type</th>");
            sb.append("<th style='text-align:left'>Display Size</th>");
            sb.append("<th style='text-align:left'>Precision</th>");
            sb.append("<th style='text-align:left'>Scale</th>");
            sb.append("<th style='text-align:left'>Autoincrement</th>");
            for(int i = 1; i <= numCol; i++) {
                sb.append("<tr>");
                sb.append(FormatUtils.formatStringTd(rsMetaData.getColumnName(i)));
                sb.append(FormatUtils.formatStringTd(rsMetaData.getColumnTypeName(i)));
                sb.append(FormatUtils.formatIntegerTd(rsMetaData.getColumnDisplaySize(i)));
                sb.append(FormatUtils.formatIntegerTd(rsMetaData.getPrecision(i)));
                sb.append(FormatUtils.formatIntegerTd(rsMetaData.getScale(i)));
                sb.append(FormatUtils.formatBooleanTd(rsMetaData.isAutoIncrement(i)));
                sb.append("</tr>\n");
            }
            sb.append("</table>");
            results.close();
            stmt.close();
            return sb.toString();
        } catch (Exception e) {
            return "Exception thrown in metadataView.listAllMetaData(): " + e.getMessage()
                    + "<br/> partial output: <br/>" + sb.toString();
        }
    }
}
