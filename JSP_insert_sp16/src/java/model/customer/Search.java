package model.customer;

import dbUtils.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbUtils.FormatUtils;

public class Search {

    public static StringData findById(DbConn dbc, String id) {

        StringData foundCust = new StringData(); // default constructor sets all fields to "" (empty string)
        if (id == null) {
            foundCust.errorMsg = "cannot search for customer with null customer id";
            System.out.println("**** Error in modelCustomer.Search.FindById: " + foundCust.errorMsg);
            return foundCust;
        }

        PreparedStatement stmt = null;
        ResultSet results = null;
        try {
            //System.out.println("*** before preparing statement");

            String sql = "select email_address, pwd, first_name, "
                    + " last_name, credit_limit from customer WHERE customer_id=?";

            stmt = dbc.getConn().prepareStatement(sql);
            //System.out.println("*** statement prepared- no sql compile errors");

            // this puts the user's input (from variable emailAddress)
            // into the 1st question mark of the sql statement above.
            stmt.setString(1, id);

            results = stmt.executeQuery();
            //System.out.println("*** query executed");

            // since the email address is required (in database) to be unique, 
            // we don't need a while loop like we did for the display data lab - just if statement
            if (results.next()) {
                //System.out.println("*** record selected");
                foundCust.customerId = id; // id is the customer id we searched for
                foundCust.emailAddress = FormatUtils.objectToString(results.getObject("email_address"));
                foundCust.pwd = FormatUtils.objectToString(results.getObject("pwd"));
                foundCust.pwd2 = FormatUtils.objectToString(results.getObject("pwd"));
                foundCust.firstName = FormatUtils.objectToString(results.getObject("first_name"));
                foundCust.lastName = FormatUtils.objectToString(results.getObject("last_name"));
                foundCust.creditLimit = FormatUtils.objectToString(results.getObject("credit_limit"));
                //System.out.println("*** fields extracted from result set");
                results.close();
                stmt.close();
                return foundCust;
            } else {
                return null; // means customer not found with given credentials.
            }
        } catch (Exception e) {
            foundCust.errorMsg = "Exception thrown in modelCustomer.Search.findById(): " + e.getMessage();
            System.out.println("**** " + foundCust.errorMsg);
            return foundCust;
        }
    }

    public static StringData logonFind(String email, String pw, DbConn dbc) {
        StringData foundData = new StringData();
        if ((email == null) || (pw == null)) {
            foundData.errorMsg = "TableMods.logonFind: email and pw must be both non-null.";
            return foundData;
        }
        try {

            // prepare the statement
            String sql = "SELECT customer_id, email_address, pwd, first_name, last_name, "
                    + " credit_limit FROM customer WHERE email_address = ? and pwd = ?";

            // PrepStatement is Sally's wrapper class for java.sql.PreparedStatement
            // Only difference is that Sally's class takes care of encoding null 
            // when necessary. And it also System.out.prints exception error messages.
            PreparedStatement pStatement = dbc.getConn().prepareStatement(sql);

            // Encode string values into the prepared statement (wrapper class).
            pStatement.setString(1, email);
            pStatement.setString(2, pw);

            ResultSet results = pStatement.executeQuery();
            if (results.next()) {
                foundData.customerId = results.getString("customer_id");
                foundData.emailAddress = email;
                foundData.pwd = pw;
                foundData.firstName = results.getString("first_name");
                foundData.lastName = results.getString("last_name");
                foundData.creditLimit = FormatUtils.formatDollar(results.getObject("credit_limit"));
                return foundData;
            } else {
                return null;
            }
        } catch (Exception e) {
            foundData.errorMsg = "Exception in TableMods.logonFind: " + e.getMessage();
            System.out.println("******" + foundData.errorMsg);
            return foundData;
        }
    } // logonFind

} // class