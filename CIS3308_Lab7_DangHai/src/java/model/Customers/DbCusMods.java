package model.Customers;

import dbUtils.PrepStatement;
import dbUtils.ValidationUtils;
import dbUtils.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbCusMods {

    /*
    Returns a "StringData" object that is full of field level validation
    error messages (or it is full of all empty strings if inputData
    totally passed validation.  
     */
    private static StringData validate(StringData inputData) {

        StringData errorMsgs = new StringData();

        // Validation
        errorMsgs.customerEmail = ValidationUtils.stringValidationMsg(inputData.customerEmail, 45, true);
        errorMsgs.customerPassword = ValidationUtils.stringValidationMsg(inputData.customerPassword, 45, true);

        if (inputData.customerPassword.compareTo(inputData.customerPassword2) != 0) { // case sensative comparison
            errorMsgs.customerPassword2 = "Both passwords must match";
        }

        errorMsgs.firstName = ValidationUtils.stringValidationMsg(inputData.firstName, 15, true);
        errorMsgs.lastName = ValidationUtils.stringValidationMsg(inputData.lastName, 20, true);

        return errorMsgs;
    } // validate 

    
    public static StringData insert(StringData inputData, DbConn dbc) {
        System.out.println("Reached INSERT!!!");

        StringData errorMsgs = new StringData();
        errorMsgs = validate(inputData);
        if (errorMsgs.getCharacterCount() > 0) {  // at least one field has an error, don't go any further.
            errorMsgs.errorMsg = "Please try again";
            return errorMsgs;
        } else { // all fields passed validation

            // Start preparing SQL statement
            String sql = "INSERT INTO customer (cus_loginName, cus_password, cus_username, firstName, lastName, user_role_id, cus_DOB) "
                    + "values (?,?,?,?,?,?,?)";

            // PrepStatement is Sally's wrapper class for java.sql.PreparedStatement
            // Only difference is that Sally's class takes care of encoding null 
            // when necessary. And it also System.out.prints exception error messages.
            PrepStatement pStatement = new PrepStatement(dbc, sql);

            // Encode string values into the prepared statement (wrapper class).
            pStatement.setString(1, inputData.customerEmail);
            pStatement.setString(2, inputData.customerPassword);
            pStatement.setString(3, inputData.customerUsername);
            pStatement.setString(4, inputData.firstName);
            pStatement.setString(5, inputData.lastName);
            pStatement.setInt(6, ValidationUtils.integerConversion(inputData.role));
            pStatement.setDate(7, ValidationUtils.dateConversion(inputData.customerDOB));

            System.out.println("USER ROLE ID: " + inputData.role);
            System.out.println("USER ROLE ID Converted: " + ValidationUtils.integerConversion(inputData.role));
            System.out.println("Date: " + ValidationUtils.dateConversion(inputData.customerDOB));
            
            // here the SQL statement is actually executed
            int numRows = pStatement.executeUpdate();
            // This will return empty string if all went well, else all error messages.
            errorMsgs.errorMsg = pStatement.getErrorMsg();
            if (errorMsgs.errorMsg.length() == 0) {
                if (numRows == 1) {
                    errorMsgs.errorMsg = ""; // This means SUCCESS. Let the JSP page decide how to tell this to the user.
                    System.out.println("SUCCESSFUL INSERT!!!");
                } else {
                    // probably never get here unless you forgot your WHERE clause and did a bulk sql update.
                    errorMsgs.errorMsg = numRows + " records were inserted when exactly 1 was expected.";
                }
            }
        } // customerId is not null and not empty string.
        return errorMsgs;
    } // insert

}