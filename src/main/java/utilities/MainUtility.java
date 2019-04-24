package utilities;

import java.text.DecimalFormat;

public class MainUtility {

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
