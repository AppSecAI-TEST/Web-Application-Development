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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hai
 */
public class reportView {
    
     //This function creates the table that the user made. Simplified Version.
    public static String listAll(String cssTableClass, DbConn dbc, String sql) {
        
        // String type could have been used, but StringBuilder is more efficient 
        // in this case where we are just appending
        StringBuilder sb = new StringBuilder("");
        PreparedStatement stmt = null;
        ResultSet results = null;
        try {
            sb.append("<table class='");
            sb.append(cssTableClass);
            sb.append("'>");

            stmt = dbc.getConn().prepareStatement(sql);
            results = stmt.executeQuery();
            ResultSetMetaData rsMetaData = results.getMetaData();
            int numCol = rsMetaData.getColumnCount();
            
            sb.append("<tr>");
            //Write column names down and replace any underscores with a space
            for(int i = 1; i <= numCol; i++) {
                sb.append(FormatUtils.formatStringTh(rsMetaData.getColumnLabel(i).replace("_", " ")));
            }
            sb.append("</tr>\n");
            //Append the data 
            while(results.next()){
                sb.append("<tr>");
                for(int i = 1; i <= numCol; i++){
                    String type = FormatUtils.formatString(rsMetaData.getColumnTypeName(i)).toLowerCase();
                    String columnName = FormatUtils.formatString(rsMetaData.getColumnLabel(i));
                    System.out.println("type: " + type);
                    String cell = "";
                    System.out.println(i-1 + ": " + results.getObject(columnName));
                    if(type.equalsIgnoreCase("int")){
                        cell = FormatUtils.formatIntegerTd(results.getObject(columnName));
                    }else if(type.equalsIgnoreCase("double")){
                        cell = FormatUtils.formatDoubleTd(results.getObject(columnName));
                    }else if(type.equalsIgnoreCase("varchar")){
                        cell = FormatUtils.formatStringTd(results.getObject(columnName));
                    }else if(type.equalsIgnoreCase("date")){
                        if(results.wasNull()){
                            cell= FormatUtils.formatStringTd("");
                            System.out.println("Date result was null");
                        } else {
                            cell = FormatUtils.formatDateTd(results.getObject(columnName));
                        }
                    }
                    sb.append(cell);
                }
                sb.append("</tr>\n");
            }
            sb.append("</table>");
            results.close();
            stmt.close();
            return sb.toString();
            
        } catch (Exception e) {
            return "Exception thrown in reportView.listAll(): " + e.getMessage()
                    + "<br/> partial output: <br/>" + sb.toString();
        }
    }
}
