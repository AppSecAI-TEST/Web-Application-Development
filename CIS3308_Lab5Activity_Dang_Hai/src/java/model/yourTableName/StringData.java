package model.yourTableName;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author sallyk
 */
public class StringData {
    public String lastName = "";
    public String age = "";
    public String numClasses = "";
    
    @Override
    public String toString(){
        return lastName + ", " + age + ", and " + numClasses;
    }
}
