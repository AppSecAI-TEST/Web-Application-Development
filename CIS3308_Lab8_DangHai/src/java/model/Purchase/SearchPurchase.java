/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Purchase;

import dbUtils.DbConn;
import dbUtils.FormatUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hai
 */
public class SearchPurchase {
    public static StringData findPurchase(String purchaseId, DbConn dbc) {
        StringData retrievedData = new StringData();
        if (purchaseId == null) {
            retrievedData.errorMsg = "Search.findUser: spaceshipId must be non-null.";
            return retrievedData;
        }
        try {
            // prepare (compiles) the SQL statement
            String sql = "SELECT buys_id, customer_id, spaceship_id, trans_cost, trans_date, "
                    + "trans_descrip, trans_quantity FROM sp17_3308_tug25055.purchase WHERE buys_id = ?";

           
            // PrepStatement is Sally's wrapper class for java.sql.PreparedStatement
            // Only difference is that Sally's class takes care of encoding null 
            // when necessary. And it also System.out.prints exception error messages.
            PreparedStatement pStatement = dbc.getConn().prepareStatement(sql);

            // Encode string values into the prepared statement (wrapper class).
            pStatement.setString(1, purchaseId);

            ResultSet results = pStatement.executeQuery();
            if (results.next()) {
                retrievedData.purchaseId = purchaseId;
                retrievedData.customerId = FormatUtils.formatInteger(results.getObject("customer_id"));
                retrievedData.spaceshipId = FormatUtils.formatInteger(results.getObject("spaceship_id"));
                retrievedData.transCost = FormatUtils.formatDouble2(results.getObject("trans_cost"));
                retrievedData.transDate = FormatUtils.formatDate(results.getObject("trans_date"));
                retrievedData.transDescrip = FormatUtils.formatString(results.getObject("trans_descrip"));
                retrievedData.transQuantity = FormatUtils.formatInteger2(results.getObject("trans_quantity"));  
                return retrievedData;
            } else {
                return null;
            }
        } catch (Exception e) {
            retrievedData.errorMsg = "Exception in Search.findSpaceship: " + e.getMessage();
            System.out.println("******" + retrievedData.errorMsg);
            return retrievedData;
        }
    } // logonFind
}
