package input;

public class VerifyInput {

    private static final String PRINT = "print";
    private static final String EXIT = "exit";


    public static boolean verify(String input) {
        return ifBarcodeInput(input) || ifExitOrPrintInput(input);
    }


    public static boolean ifExitOrPrintInput(String input) {
        return ifExitInput(input) || ifPrintInput(input);
    }

    public static boolean ifBarcodeInput(String input) {
        if (input.matches("\\d{9}")) {
            return true;
        }
        return false;
    }

    public static boolean ifExitInput(String input){
        return input.equals(EXIT);
    }

    public static boolean ifPrintInput(String input){
        return input.equals(PRINT);
    }
}
