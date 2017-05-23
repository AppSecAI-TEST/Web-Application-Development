/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Purchase;

import java.util.ArrayList;

/**
 *
 * @author Hai
 */
public class StringDataList {
    public String dbError = "";
    public ArrayList<StringData> purchaseList = new ArrayList();

    public StringDataList(int listSize) {
    }

    public void addPurchase(StringData purchase) {
        this.purchaseList.add(purchase);
    }
}
