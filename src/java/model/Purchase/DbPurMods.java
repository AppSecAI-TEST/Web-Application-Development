package model.Purchase;

import dbUtils.PrepStatement;
import dbUtils.ValidationUtils;
import dbUtils.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DbPurMods {
      
     /*
    Returns a "StringData" object that is full of field level validation
    error messages (or it is full of all empty strings if inputData
    totally passed validation.  
     */
    private static StringData validate(StringData inputData) {

        StringData errorMsgs = new StringData();

        // Validation
        errorMsgs.customerId = ValidationUtils.integerValidationMsg(inputData.customerId, true);
        if(inputData.customerId.compareToIgnoreCase("0") == 0){
            System.out.println("DbPurMods Validate: Select Customer id is: " + inputData.customerId);
            errorMsgs.customerId = "Please choose an option";
        }
        if(inputData.spaceshipId.compareToIgnoreCase("0") == 0){
            System.out.println("DbPurMods Validate: Select Spaceship id is: " + inputData.spaceshipId);
            errorMsgs.spaceshipId = "Please choose an option";
        }
        errorMsgs.transQuantity = ValidationUtils.integerValidationMsg(inputData.transQuantity, true);
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
            String sql = "INSERT INTO purchase (customer_id, spaceship_id, trans_cost, trans_date, trans_descrip, trans_quantity) "
                    + "values (?,?,?,?,?,?)";
            
            // PrepStatement is Sally's wrapper class for java.sql.PreparedStatement
            // Only difference is that Sally's class takes care of encoding null 
            // when necessary. And it also System.out.prints exception error messages.
            PrepStatement pStatement = new PrepStatement(dbc, sql);

            // Encode string values into the prepared statement (wrapper class).
            pStatement.setInt(1, ValidationUtils.integerConversion(inputData.customerId));
            pStatement.setInt(2, ValidationUtils.integerConversion(inputData.spaceshipId));
            
            //cost should be quantity * spaceship price 
            String newPrice = getPrice(inputData, dbc);
            //get rid of commas or BigDecimal will throw exception
            java.math.BigDecimal spaceshipPrice = ValidationUtils.decimalConversion(newPrice);  
            //convert quantity to BigDecimal
            java.math.BigDecimal spaceshipQuantity =  ValidationUtils.decimalConversion(inputData.transQuantity);
            pStatement.setBigDecimal(3, spaceshipPrice.multiply(spaceshipQuantity));
            
            //set current date for transaction
            pStatement.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
            pStatement.setString(5, inputData.transDescrip);
            pStatement.setInt(6, ValidationUtils.integerConversion(inputData.transQuantity));

            
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

    
    //Get price data for spaceship
    public static String getPrice(StringData inputData, DbConn dbc){
        String price;
        StringData errorMsgs = new StringData();
        try {
            //Query for spaceship cost of chosen id
            String sql = "SELECT price FROM spaceship where spaceship_id = ?";       

            // PrepStatement is Sally's wrapper class for java.sql.PreparedStatement
            // Only difference is that Sally's class takes care of encoding null 
            // when necessary. And it also System.out.prints exception error messages.
            PreparedStatement pStatement = dbc.getConn().prepareStatement(sql);
            pStatement.setInt(1, ValidationUtils.integerConversion(inputData.spaceshipId));
            ResultSet results = pStatement.executeQuery();
            if (results.next()) {
                price = FormatUtils.formatDouble2(results.getObject("price"));
                System.out.println("Price retrieved: " + price);
                return price;
            } 
        } catch(Exception e){
            errorMsgs.errorMsg = "Error in DbPurMods.getPrice():" + e.getMessage();
        }
        return null;
    }
    
    
    public static StringData update(StringData inputData, DbConn dbc) {
        System.out.println("Reached INSERT!!!");

        StringData errorMsgs = new StringData();
        errorMsgs = validate(inputData);
        if (errorMsgs.getCharacterCount() > 0) {  // at least one field has an error, don't go any further.
            errorMsgs.errorMsg = "Please try again";
            return errorMsgs;
        } else { // all fields passed validation
            
            // Start preparing SQL statement
            String sql = "UPDATE purchase set customer_id = ?, spaceship_id = ?, trans_cost = ?, trans_date = ?, trans_descrip = ?, trans_quantity = ? "
                    + "WHERE buys_id = ?";
            
            // PrepStatement is Sally's wrapper class for java.sql.PreparedStatement
            // Only difference is that Sally's class takes care of encoding null 
            // when necessary. And it also System.out.prints exception error messages.
            PrepStatement pStatement = new PrepStatement(dbc, sql);

            // Encode string values into the prepared statement (wrapper class).
            pStatement.setInt(1, ValidationUtils.integerConversion(inputData.customerId));
            pStatement.setInt(2, ValidationUtils.integerConversion(inputData.spaceshipId));
            pStatement.setBigDecimal(3, ValidationUtils.decimalConversion(inputData.transCost));
            pStatement.setDate(4, ValidationUtils.dateConversion(inputData.transDate));
            pStatement.setString(5, inputData.transDescrip);
            pStatement.setInt(6, ValidationUtils.integerConversion(inputData.transQuantity));
            pStatement.setInt(7, ValidationUtils.integerConversion(inputData.purchaseId));
            
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
    } // update
    
    
    
    
    public static StringData delete(StringData inputData, DbConn dbc) {
        System.out.println("Reached DELETE!!!");

        StringData errorMsgs = new StringData();
        //errorMsgs = validate(inputData);
        errorMsgs.purchaseId = ValidationUtils.integerValidationMsg(inputData.purchaseId, true);

        if (errorMsgs.getCharacterCount() > 0) {  // at least one field has an error, don't go any further.
            errorMsgs.errorMsg = "Please try again";    //Either have if statement or make errorMsgs.errorMsg = "";
            //for first rendering but really for when never clicked so no id gets passed
            if(inputData.purchaseId.compareTo("") == 0 || inputData.purchaseId == null){
                errorMsgs.errorMsg = " ";  
                System.out.println("First render");
            }
            return errorMsgs;
        } else { // all fields passed validation
            
            // Start preparing SQL statement
            String sql = "DELETE FROM sp17_3308_tug25055.purchase WHERE buys_id = ?";
            
            // PrepStatement is Sally's wrapper class for java.sql.PreparedStatement
            // Only difference is that Sally's class takes care of encoding null 
            // when necessary. And it also System.out.prints exception error messages.
            PrepStatement pStatement = new PrepStatement(dbc, sql);

            // Encode string values into the prepared statement (wrapper class).
            pStatement.setString(1, inputData.purchaseId);
            
            // here the SQL statement is actually executed
            int numRows = pStatement.executeUpdate();
            // This will return empty string if all went well, else all error messages.
            errorMsgs.errorMsg = pStatement.getErrorMsg();
            if (errorMsgs.errorMsg.length() == 0) {
                if (numRows == 1) {
                    errorMsgs.errorMsg = ""; // This means SUCCESS. Let the JSP page decide how to tell this to the user.
                    System.out.println("SUCCESSFUL DELETE!!!");
                } else {
                    // probably never get here unless you forgot your WHERE clause and did a bulk sql update.
                    errorMsgs.errorMsg = numRows + " records were deleted when exactly 1 was expected.";
                }
            }
        } // customerId is not null and not empty string.
        return errorMsgs;
    } // delete
    
}
