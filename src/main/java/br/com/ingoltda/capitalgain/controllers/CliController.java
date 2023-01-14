package br.com.ingoltda.capitalgain.controllers;

import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.services.OperationLineProcessorService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;

import java.util.List;


//@CommandLine.Command(name = "CapitalGain ", mixinStandardHelpOptions = true, version = "0.1", description = "CapitalGain project")
public class CliController {//implements Callable<Integer> {

//    @CommandLine.Option(names = { "-a",
//            "--address" }, paramLabel = "API_ADDRESS", description = "The address you want to connect to")
//    String option;

    //@Override
    public void call(){
        List<List<Operation>> jsons = readContentFromStdIn();
        StringBuilder resultTax = new StringBuilder();
        jsons.forEach(operationsLine -> {
            OperationLineProcessorService operationLineProcessorService = new OperationLineProcessorService();
            resultTax.append(operationLineProcessorService.process(operationsLine));
        });
        System.out.println(resultTax);
    }
    private List<List<Operation>> readContentFromStdIn()
    {
        Scanner in = new Scanner(System.in);
        String input;
        List<List<Operation>> jsons = new ArrayList<>();
        do{
            input = in.nextLine();
            if(!input.isEmpty()){
                jsons.add(parseLine(input));
            } else break;
        } while(!input.isEmpty());

        return jsons;
    }

    private List<Operation> parseLine(String line){
        Gson gson = new Gson();
        return gson.fromJson(line, new TypeToken<ArrayList<Operation>>(){}.getType());
    }
}