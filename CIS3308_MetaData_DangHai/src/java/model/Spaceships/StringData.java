/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Spaceships;

/**
 *
 * @author Hai
 */
public class StringData {
    public String spaceshipId = "";
    public String modelName = "";
    public String modelYear= "";
    public String modelType ="";
    public String maxCapacity ="";
    public String spaceshipPrice="";
    public String imageUrl="";
    public String fuelCapacity ="";
    public String errorMsg ="";
    
        public int getCharacterCount() {
        String s = this.spaceshipId + this.modelName + this.modelYear 
                + this.modelType + this.maxCapacity 
                + this.spaceshipPrice + this.imageUrl 
                + this.fuelCapacity;
        return s.length();
    }
    public String toString() {
        return "spaceship id: " + this.spaceshipId +
                " model name: " + this.modelName +
                " model year: " + this.modelYear +
                " model type: " + this.modelType +
                " max capacity: " + this.maxCapacity +
                " spaceship price: " + this.spaceshipPrice +
                " image url: " + this.imageUrl +
                " fuel capacity: " + this.fuelCapacity;
    }
}
