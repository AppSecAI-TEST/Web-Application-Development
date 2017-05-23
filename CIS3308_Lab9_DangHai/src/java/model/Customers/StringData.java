/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Customers;

/**
 *
 * @author Hai
 */
public class StringData {
    public String customerId = "";
    public String customerEmail = "";
    public String customerUsername= "";
    public String customerPassword ="";
    public String customerPassword2 ="";
    public String firstName="";
    public String lastName="";
    public String customerDOB ="";
    public String role="";
    public String roleId="";
    public String errorMsg ="";
    
        public int getCharacterCount() {
        String s = this.customerId + this.customerEmail + this.customerUsername 
                + this.customerPassword + this.customerPassword2 
                + this.customerDOB + this.firstName 
                + this.lastName + this.role + this.roleId;
        return s.length();
    }
    public String toString() {
        return "Customer id: " + this.customerId +
                " email Address: " + this.customerEmail +
                " username: " + this.customerUsername +
                " password: " + this.customerPassword +
                " password2: " + this.customerPassword2 +
                " DOB: " + this.customerDOB +
                " role: " + this.role +
                " role id: " + this.roleId + 
                " firstName: " + this.firstName +
                " lastName: " + this.lastName;
    }
}

