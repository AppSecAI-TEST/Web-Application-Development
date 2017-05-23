package view;

// classes imported from java.sql.*
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// classes in my project
import dbUtils.*;
import model.CountryFlag.*;

public class CountryFlagView {

    private static StringData dbRowToStringData(ResultSet results) {

        StringData sd = new StringData();

        try {  //country_id, country_name, flag_abbrev, flag_URL
            sd.countryId = FormatUtils.formatInteger(results.getObject("country_id"));
            sd.countryName = FormatUtils.formatString(results.getObject("country_name"));
            sd.flagAbbrev = FormatUtils.formatString(results.getObject("flag_abbrev"));
            sd.flagURL = FormatUtils.formatString(results.getObject("flag_URL"));
        } catch (Exception e) {
            sd.errorMsg = "Error in CountryFlagView.dbRowToStringData: " + e.getMessage();
        }
        return sd;
    }

    public static StringDataList getCountryFlagList(String countryNameStartsWith, DbConn dbc) {

        StringDataList countryList = new StringDataList(0);
        System.out.println("getCountryFlagList searching for countries that start with "+countryNameStartsWith);

        try {

            // Now add each country to the list of countries
            String sql = "SELECT country_id, country_name, flag_abbrev, flag_URL FROM country_flag "
                    + " WHERE country_name LIKE ? ORDER BY country_name";
            PreparedStatement stmt = dbc.getConn().prepareStatement(sql);
            stmt.setString(1, countryNameStartsWith + "%");
            ResultSet results = stmt.executeQuery();

            StringData country = null;
            while (results.next()) {
                country = dbRowToStringData(results);
                countryList.addCountry(country);
            }

        } catch (Exception e) {
            countryList.dbError = e.getMessage();
        }
        return countryList;
    } // method allFlagsJson 
} // class
