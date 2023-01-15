package br.com.ingoltda.capitalgain.controllers;

import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.services.OperationLineProcessorService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;

@Controller
public class CliController {
    private OperationLineProcessorService operationLineProcessorService;

    public CliController() {
        this.operationLineProcessorService = new OperationLineProcessorService();
    }

    /**
     * Until pressing ENTER, the method will receive lines in json format, as shown below,
     * calls the appropriate services to parse, process and calculate the response rate.
     *
     * Example: [{"operation":"buy", "unit-cost":10.00, "quantity": 10000},{"operation":"sell", "unit-cost":20.00, "quantity": 5000},{"operation":"sell", "unit-cost":5.00, "quantity": 5000}]
     *
     * @return            String in json format with the TAX of processed operations
     */
    public String readContentFromStdIn(){
        Scanner in = new Scanner(System.in);
        StringBuilder resultTax = new StringBuilder();

        while(in.hasNextLine()) {
            String input = in.nextLine();
            if (!input.isEmpty()) {
                resultTax.append(operationLineProcessorService.process(parseLine(input)));
            } else {
                break;
            }
        }

        in.close();
        return resultTax.toString();
    }

    /**
     * This method will parse json for an OPERATION LIST
     *
     * Json example: [{"operation":"buy", "unit-cost":10.00, "quantity": 10000},{"operation":"sell", "unit-cost":20.00, "quantity": 5000},{"operation":"sell", "unit-cost":5.00, "quantity": 5000}]
     *
     * @param line          A json containing a list of Operation
     * @return              an operation list
     */
    private List<Operation> parseLine(String line){
        Gson gson = new Gson();
        return gson.fromJson(line, new TypeToken<ArrayList<Operation>>(){}.getType());
    }
}