package output;

import output.console.ExitOutput;
import output.console.Output;
import output.console.PrintOutput;

import java.util.HashMap;
import java.util.Map;

public class TextOutputs {

    private static Map<String, Output> outputs = new HashMap<>();

    public static Output get(String input) {
        if (outputs.isEmpty()){
            fillMap();
        }
        return outputs.get(input);
    }

    public static void add(String key, Output value){
        outputs.put(key, value);
    }



    private static void fillMap() {
        add("exit", new ExitOutput());
        add("print", new PrintOutput());
    }

}
