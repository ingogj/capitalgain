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

    private List<Operation> parseLine(String line){
        Gson gson = new Gson();
        return gson.fromJson(line, new TypeToken<ArrayList<Operation>>(){}.getType());
    }
}