package model.customer;

/* The purpose of this class is just to "bundle together" all the 
 * character data that the user might type in when they want to 
 * add a new Customer or edit an existing customer.  This String
 * data is "pre-validated" data, meaning they might have typed 
 * in a character string where a number was expected.
 * 
 * There are no getter or setter methods since we are not trying to
 * protect this data in any way.  We want to let the JSP page have
 * free access to put data in or take it out. */
public class StringData {

    public String customerId = "";
    public String emailAddress = "";
    public String pwd = "";
    public String pwd2 = ""; // On the JSP page, we ask the user to type in their password twice...
    public String firstName = "";
    public String lastName = "";

    public String creditLimit = "";
    
    public String errorMsg = "";

    public int getCharacterCount() {
        String s = this.customerId + this.emailAddress + this.pwd + this.pwd2 + this.firstName +
                this.lastName + this.creditLimit;
        return s.length();
    }
    public String toString() {
        return "Customer id:" + this.customerId+
                " email Address:" + this.emailAddress+
                " password:" + this.pwd+
                " password2:" + this.pwd2+
                " firstName:" + this.firstName+
                " lastName:" + this.lastName+
                " creditLimit:"+this.creditLimit;
    }
}