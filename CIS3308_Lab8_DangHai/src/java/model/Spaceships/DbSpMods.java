package model.Spaceships;

import dbUtils.PrepStatement;
import dbUtils.ValidationUtils;
import dbUtils.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbSpMods {

    /*
    Returns a "StringData" object that is full of field level validation
    error messages (or it is full of all empty strings if inputData
    totally passed validation.  
     */
    private static StringData validate(StringData inputData) {

        StringData errorMsgs = new StringData();

        // Validation
        errorMsgs.modelName = ValidationUtils.stringValidationMsg(inputData.modelName, 45, true);
        //errorMsgs.modelYear = ValidationUtils.dateValidationMsg(inputData.modelYear, true);
        errorMsgs.modelType = ValidationUtils.stringValidationMsg(inputData.modelType, 45, true);
        errorMsgs.maxCapacity = ValidationUtils.integerValidationMsg(inputData.maxCapacity, true);
        errorMsgs.spaceshipPrice = ValidationUtils.decimalValidationMsg(inputData.spaceshipPrice, true);
        //errorMsgs.imageUrl = ValidationUtils.stringValidationMsg(inputData.imageUrl, 300, true);
        //errorMsgs.fuelCapacity = ValidationUtils.decimalValidationMsg(inputData.fuelCapacity, true);

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
            String sql = "INSERT INTO spaceship (modelName, modelYear, modelType, maxCapacity, price, image_url, fuelCapacity) "
                    + "values (?,?,?,?,?,?,?)";

            // PrepStatement is Sally's wrapper class for java.sql.PreparedStatement
            // Only difference is that Sally's class takes care of encoding null 
            // when necessary. And it also System.out.prints exception error messages.
            PrepStatement pStatement = new PrepStatement(dbc, sql);

            // Encode string values into the prepared statement (wrapper class).
            pStatement.setString(1, inputData.modelName);
            pStatement.setDate(2, ValidationUtils.dateConversion(inputData.modelYear));
            pStatement.setString(3, inputData.modelType);
            pStatement.setInt(4, ValidationUtils.integerConversion(inputData.maxCapacity));
            pStatement.setBigDecimal(5, ValidationUtils.decimalConversion(inputData.spaceshipPrice));
            pStatement.setString(6, inputData.imageUrl);
            pStatement.setBigDecimal(7, ValidationUtils.decimalConversion(inputData.fuelCapacity));

            System.out.println("Date: " + ValidationUtils.dateConversion(inputData.modelYear));
            System.out.println("Max Cap: " + ValidationUtils.integerConversion(inputData.maxCapacity));
            System.out.println("Price: " +  ValidationUtils.decimalConversion(inputData.spaceshipPrice));
            System.out.println("Fuel Cap: " + ValidationUtils.decimalConversion(inputData.fuelCapacity));
            
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
    
    public static StringData update(StringData inputData, DbConn dbc) {
        System.out.println("Reached UPDATE!!!");

        StringData errorMsgs = new StringData();
        errorMsgs = validate(inputData);
        if (errorMsgs.getCharacterCount() > 0) {  // at least one field has an error, don't go any further.
            errorMsgs.errorMsg = "Please try again";
            return errorMsgs;
        } else { // all fields passed validation

            // Start preparing SQL statement
            String sql = "UPDATE spaceship set modelName = ?, modelYear = ?, modelType = ?, maxCapacity = ?, price = ?, image_url = ?, fuelCapacity = ? "
                    + "WHERE spaceship_id = ?";

            // PrepStatement is Sally's wrapper class for java.sql.PreparedStatement
            // Only difference is that Sally's class takes care of encoding null 
            // when necessary. And it also System.out.prints exception error messages.
            PrepStatement pStatement = new PrepStatement(dbc, sql);

            // Encode string values into the prepared statement (wrapper class).
            pStatement.setString(1, inputData.modelName);
            pStatement.setDate(2, ValidationUtils.dateConversion(inputData.modelYear));
            pStatement.setString(3, inputData.modelType);
            pStatement.setInt(4, ValidationUtils.integerConversion(inputData.maxCapacity));
            pStatement.setBigDecimal(5, ValidationUtils.decimalConversion(inputData.spaceshipPrice));
            pStatement.setString(6, inputData.imageUrl);
            pStatement.setBigDecimal(7, ValidationUtils.decimalConversion(inputData.fuelCapacity));
            pStatement.setInt(8, ValidationUtils.integerConversion(inputData.spaceshipId));

            System.out.println("Date: " + ValidationUtils.dateConversion(inputData.modelYear));
            System.out.println("Max Cap: " + ValidationUtils.integerConversion(inputData.maxCapacity));
            System.out.println("Price: " +  ValidationUtils.decimalConversion(inputData.spaceshipPrice));
            System.out.println("Fuel Cap: " + ValidationUtils.decimalConversion(inputData.fuelCapacity));
            
            // here the SQL statement is actually executed
            int numRows = pStatement.executeUpdate();
            // This will return empty string if all went well, else all error messages.
            errorMsgs.errorMsg = pStatement.getErrorMsg();
            if (errorMsgs.errorMsg.length() == 0) {
                if (numRows == 1) {
                    errorMsgs.errorMsg = ""; // This means SUCCESS. Let the JSP page decide how to tell this to the user.
                    System.out.println("SUCCESSFUL UPDATE!!!");
                } else {
                    // probably never get here unless you forgot your WHERE clause and did a bulk sql update.
                    errorMsgs.errorMsg = numRows + " records were inserted when exactly 1 was expected.";
                }
            }
        } // customerId is not null and not empty string.
        return errorMsgs;
    } // update

}