/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Spaceships;

import dbUtils.DbConn;
import dbUtils.FormatUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hai
 */
public class SearchSpaceship {
    public static StringData findSpaceship(String spaceshipId, DbConn dbc) {
        StringData retrievedData = new model.Spaceships.StringData();
        if (spaceshipId == null) {
            retrievedData.errorMsg = "Search.findUser: spaceshipId must be non-null.";
            return retrievedData;
        }
        try {
            // prepare (compiles) the SQL statement
            String sql = "select modelName, modelYear, spaceship_id, modelType, price, maxCapacity, "
                    + "fuelCapacity, image_url from sp17_3308_tug25055.spaceship "
                    + "where spaceship_id = ?";
           
            // PrepStatement is Sally's wrapper class for java.sql.PreparedStatement
            // Only difference is that Sally's class takes care of encoding null 
            // when necessary. And it also System.out.prints exception error messages.
            PreparedStatement pStatement = dbc.getConn().prepareStatement(sql);

            // Encode string values into the prepared statement (wrapper class).
            pStatement.setString(1, spaceshipId);

            ResultSet results = pStatement.executeQuery();
            if (results.next()) {
                retrievedData.spaceshipId = spaceshipId;
                retrievedData.modelName = FormatUtils.formatString(results.getObject("modelName"));
                retrievedData.modelYear = FormatUtils.formatDate(results.getObject("modelYear"));
                retrievedData.modelType = FormatUtils.formatString(results.getObject("modelType"));
                retrievedData.maxCapacity = FormatUtils.formatInteger2(results.getObject("maxCapacity"));
                retrievedData.spaceshipPrice = FormatUtils.formatDouble2(results.getObject("price"));
                retrievedData.imageUrl = FormatUtils.formatString(results.getObject("image_url"));  
                retrievedData.fuelCapacity = FormatUtils.formatDouble2(results.getObject("fuelCapacity"));
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
