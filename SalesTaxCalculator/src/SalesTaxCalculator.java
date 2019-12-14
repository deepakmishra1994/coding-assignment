import model.Item;
import util.CalculatorTax;
import util.RoundOffUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesTaxCalculator {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the number of shopping baskets: ");
        int n = scr.nextInt();
        scr.nextLine();
        List<String> shoppingBasket = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            shoppingBasket.add(scr.nextLine());
        }

        double totalSalesTax = 0.0;
        double totalAmount = 0.0;
        String itemDetails;
        StringBuilder itemDetailsBuilder = new StringBuilder();

        for(String itemBasket: shoppingBasket) {
            String name = itemBasket.substring(0, itemBasket.indexOf(" at"));
            int quantity = Integer.parseInt(itemBasket.substring(0, itemBasket.indexOf(" ")));
            double basePrice = Double.parseDouble(itemBasket.substring(itemBasket.lastIndexOf(" ") + 1));
            Item item = new Item(name, quantity, basePrice);

            CalculatorTax.applyTaxes(item);

            itemDetailsBuilder.append(item.toString()).append("\n");
            totalSalesTax += item.getTaxAmount();
            totalAmount += item.getFinalPrice();
        }

        totalAmount = RoundOffUtils.roundOffAmount(totalAmount);
        totalSalesTax = RoundOffUtils.roundOffAmount(totalSalesTax);
        itemDetails = itemDetailsBuilder.toString();

        System.out.println(
                    "Receipt details for shopping basket" + "\n"
                    + itemDetails
                    + "Sales Taxes: " + totalSalesTax + "\n"
                    + "Total: " + totalAmount
                );
    }
}
