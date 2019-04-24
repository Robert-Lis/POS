package utilities;

import java.text.DecimalFormat;

public class MainUtility {

//    public void verifyInput(String scannedText, Receipt receipt, ProductService productService){
//
//        try {
//            Long barCode = Long.parseLong(scannedText);
//            Product productToAdd = productService.findById(barCode);
//
//            if (productToAdd.equals(null)){
//                System.out.println("Product with this bar-code does not exist");
//            } else {
//                System.out.println("Product: " + productToAdd.getName() + " added.");
//                receipt.addProduct(productToAdd);
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("Enter the correct format of bar-code");
//        } catch (EnitytNotFoundException e) {
//
//        }
//    }

    public boolean verifyInput(String scannedText) {
        try {
            Long barCode = Long.parseLong(scannedText);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Please enter the correct format of bar-code");
        }
        return false;
    }

    public static DecimalFormat df2 = new DecimalFormat("#.##");


}
