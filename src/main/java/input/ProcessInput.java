package input;


import exceptions.EntityNotFoundByBarcodeException;
import output.ProcessBarcodeOutput;
import output.ProcessTextOutput;
import shoppingCart.ShoppingCart;

import java.util.Scanner;

public class ProcessInput {

    public void getInput(ShoppingCart cart) throws EntityNotFoundByBarcodeException {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            //TODO: zastanowić się, czy metoda nie ma dwóch odpowiedzialności pobieranie i przekazywanie (to chyba ok) oraz trim(?)
            processInput(input.trim().toLowerCase(), cart, scanner);
        }
    }



    private void processInput(String input, ShoppingCart cart, Scanner scanner) throws EntityNotFoundByBarcodeException {
        if(!VerifyInput.verify(input)){
            System.out.println("Sorry, wrong input");
        }
        if(VerifyInput.ifExitOrPrintInput(input)){
            ProcessTextOutput.getOutput(input, cart, scanner);

            //TODO:Ogarnąć nadawanie kolejnego numerka w ShoppingCart
        }
        if(VerifyInput.ifBarcodeInput(input)){
            ProcessBarcodeOutput.getOutput(input, cart);
        }
    }
}
