/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ut2u
 */
public class ImportedProduct extends Product{
    
    private Double customsFee;
    
    public ImportedProduct(){
        super();
    }

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }
    
    public Double totalPrice() {
        return super.getPrice() + this.customsFee;
    }
    
    @Override
    public String priceTag() {
        return super.getName() 
                + " - US$"
                + String.format("%.2f", totalPrice())
                + " (Customs fee: "
                + String.valueOf(String.format("%.2f", getCustomsFee())) //String.valueOf(variable_name) used to change a Double number to a String
                + ")";
    }
    
}
