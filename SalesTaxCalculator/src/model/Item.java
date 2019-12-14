package model;

import util.RoundOffUtils;

public class Item {

    private String name;
    private int quantity;
    private double basePrice;
    private double basicSalesTaxAmount;
    private double additionalSalesTaxAmount;

    public Item(String name, int quantity, double basePrice) {
        this.name = name;
        this.quantity = quantity;
        this.basePrice = basePrice;
    }

    public double getFinalPrice() {
        return RoundOffUtils.roundOffAmount(quantity * basePrice + getTaxAmount());
    }

    public double getTaxAmount() {
        return quantity * (basicSalesTaxAmount + additionalSalesTaxAmount);
    }

    public boolean isImported() {
        return name.contains("imported");
    }

    public boolean isExempted() {
        if(this.name.indexOf("book") != -1 || this.name.indexOf("chocolate") != -1 || this.name.indexOf("pills") != -1)
            return true;
        else
            return false;
    }

    public void setBasicSalesTaxAmount(double factor) {
        basicSalesTaxAmount = basePrice * factor;
    }

    public void setAdditionalSalesTax(double additionalSalesTaxPercent) {
        additionalSalesTaxAmount = RoundOffUtils.roundOffTax(basePrice * additionalSalesTaxPercent);
    }

    public String toString() {
        return name + " : " + getFinalPrice();
    }
}
