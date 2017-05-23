package model.CountryFlag;

import java.util.ArrayList;

public class StringDataList {

    public String dbError = "";
    public ArrayList<StringData> countryFlagList = new ArrayList();

    public StringDataList(int listSize) {
    }

    public void addCountry(StringData country) {
        this.countryFlagList.add(country);
    }
}
