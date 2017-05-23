/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Purchase;

/**
 *
 * @author Hai
 */
public class StringData {
    public String purchaseId = "";
    public String customerId = "";
    public String spaceshipId= "";
    public String transCost ="";
    public String transDate ="";
    public String transDescrip="";
    public String transQuantity="";
    public String errorMsg ="";
    
        public int getCharacterCount() {
        String s = this.purchaseId + this.customerId + this.spaceshipId 
                + this.transCost + this.transDate 
                + this.transDescrip + this.transQuantity;
        return s.length();
    }
    public String toString() {
        return  " Purchase id: " + this.purchaseId +
                " Customer id: " + this.customerId +
                " Spaceship id: " + this.spaceshipId +
                " Transaction Cost: " + this.transCost +
                " Transaction Date: " + this.transDate +
                " Transaction Description: " + this.transDescrip +
                " Transaction Quantity: " + this.transQuantity;
    }
}
