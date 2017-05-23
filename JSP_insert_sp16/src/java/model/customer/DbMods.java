package model.customer;

import dbUtils.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbMods {

    /*
    Returns a "StringData" object that is full of field level validation
    error messages (or it is full of all empty strings if inputData
    totally passed validation.  
     */
    private static StringData validate(StringData inputData) {

        StringData errorMsgs = new StringData();

        // Validation
        errorMsgs.emailAddress = ValidationUtils.stringValidationMsg(inputData.emailAddress, 45, true);
        errorMsgs.pwd = ValidationUtils.stringValidationMsg(inputData.pwd, 45, true);

        if (inputData.pwd.compareTo(inputData.pwd2) != 0) { // case sensative comparison
            errorMsgs.pwd2 = "Both passwords must match";
        }

        errorMsgs.firstName = ValidationUtils.stringValidationMsg(inputData.firstName, 15, true);
        errorMsgs.lastName = ValidationUtils.stringValidationMsg(inputData.lastName, 20, true);
        errorMsgs.creditLimit = ValidationUtils.decimalValidationMsg(inputData.creditLimit, false);

        return errorMsgs;
    } // validate 

    public static StringData insert(StringData inputData, DbConn dbc) {

        StringData errorMsgs = new StringData();
        errorMsgs = validate(inputData);
        if (errorMsgs.getCharacterCount() > 0) {  // at least one field has an error, don't go any further.
            errorMsgs.errorMsg = "Please try again";
            return errorMsgs;

        } else { // all fields passed validation

            // Start preparing SQL statement
            String sql = "INSERT INTO customer (email_address, pwd, first_name, last_name, credit_limit) "
                    + "values (?,?,?,?,?)";

            // PrepStatement is Sally's wrapper class for java.sql.PreparedStatement
            // Only difference is that Sally's class takes care of encoding null 
            // when necessary. And it also System.out.prints exception error messages.
            PrepStatement pStatement = new PrepStatement(dbc, sql);

            // Encode string values into the prepared statement (wrapper class).
            pStatement.setString(1, inputData.emailAddress);
            pStatement.setString(2, inputData.pwd);
            pStatement.setString(3, inputData.firstName);
            pStatement.setString(4, inputData.lastName);
            pStatement.setBigDecimal(5, ValidationUtils.decimalConversion(inputData.creditLimit));

            // here the SQL statement is actually executed
            int numRows = pStatement.executeUpdate();

            // This will return empty string if all went well, else all error messages.
            errorMsgs.errorMsg = pStatement.getErrorMsg();
            if (errorMsgs.errorMsg.length() == 0) {
                if (numRows == 1) {
                    errorMsgs.errorMsg = ""; // This means SUCCESS. Let the JSP page decide how to tell this to the user.
                } else {
                    // probably never get here unless you forgot your WHERE clause and did a bulk sql update.
                    errorMsgs.errorMsg = numRows + " records were inserted when exactly 1 was expected.";
                }
            }
        } // customerId is not null and not empty string.
        return errorMsgs;
    } // insert

}