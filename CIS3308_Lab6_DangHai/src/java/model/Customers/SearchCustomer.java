/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Customers;

import dbUtils.DbConn;
import dbUtils.FormatUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hai
 */
public class SearchCustomer {
    public static StringData logonFind(String userEmail, String pw, DbConn dbc) {
        StringData retrievedData = new StringData();
        if ((userEmail == null) || (pw == null)) {
            retrievedData.errorMsg = "Search.logonFind: email and pw must be both non-null.";
            return retrievedData;
        }
        try {
            // prepare (compiles) the SQL statement
            String sql = "select customer_id, firstName, lastName, cus_loginName, cus_password, cus_username, cus_DOB, user_role " 
                    + "from sp17_3308_tug25055.customer, sp17_3308_tug25055.user_role " 
                    + "where sp17_3308_tug25055.user_role.user_role_id = sp17_3308_tug25055.customer.user_role_id "
                    + "and cus_loginName = ? and cus_password = ?";
           
            // PrepStatement is Sally's wrapper class for java.sql.PreparedStatement
            // Only difference is that Sally's class takes care of encoding null 
            // when necessary. And it also System.out.prints exception error messages.
            PreparedStatement pStatement = dbc.getConn().prepareStatement(sql);

            // Encode string values into the prepared statement (wrapper class).
            pStatement.setString(1, userEmail);
            pStatement.setString(2, pw);

            ResultSet results = pStatement.executeQuery();
            if (results.next()) {
                retrievedData.customerId = FormatUtils.formatInteger(results.getObject("customer_id"));
                retrievedData.customerEmail = userEmail;
                retrievedData.firstName = FormatUtils.formatString(results.getObject("firstName"));
                retrievedData.lastName = FormatUtils.formatString(results.getObject("lastName"));                
                return retrievedData;
            } else {
                return null;
            }
        } catch (Exception e) {
            retrievedData.errorMsg = "Exception in Search.logonFind: " + e.getMessage();
            System.out.println("******" + retrievedData.errorMsg);
            return retrievedData;
        }
    } // logonFind
}
