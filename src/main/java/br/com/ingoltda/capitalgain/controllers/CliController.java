package br.com.ingoltda.capitalgain.controllers;

import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.services.OperationLineProcessorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.List;

//@Component
//public class CliController implements CommandLineRunner, ExitCodeGenerator {
@Controller
public class CliController {

    public static void main(String[] args) {

        OperationLineProcessorService operationLineProcessorService = new OperationLineProcessorService();

        List<Operation> line = new ArrayList<>();

        System.out.println("CASO #1");//todo
        line.add(Operation.builder().operationType("buy").unitCost(10.00D).quantity(100D).build());
        line.add(Operation.builder().operationType("sell").unitCost(15.00D).quantity(50D).build());
        line.add(Operation.builder().operationType("sell").unitCost(15.00D).quantity(50D).build());

        operationLineProcessorService.process(line);

        System.out.println("CASO #2");//todo
        line = new ArrayList<>();

        line.add(Operation.builder().operationType("buy").unitCost(10.00D).quantity(10000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(20.00D).quantity(5000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(5.00D).quantity(5000D).build());

        operationLineProcessorService.process(line);

        System.out.println("CASO #3");//todo
        line = new ArrayList<>();

        line.add(Operation.builder().operationType("buy").unitCost(10.00D).quantity(10000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(5.00D).quantity(5000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(20.00D).quantity(3000D).build());

        operationLineProcessorService.process(line);

        System.out.println("CASO #4");//todo
        line = new ArrayList<>();

        line.add(Operation.builder().operationType("buy").unitCost(10.00D).quantity(10000D).build());
        line.add(Operation.builder().operationType("buy").unitCost(25.00D).quantity(5000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(15.00D).quantity(1000D).build());

        operationLineProcessorService.process(line);

        System.out.println("CASO #5");//todo
        line = new ArrayList<>();

        line.add(Operation.builder().operationType("buy").unitCost(10.00D).quantity(10000D).build());
        line.add(Operation.builder().operationType("buy").unitCost(25.00D).quantity(5000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(15.00D).quantity(10000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(25.00D).quantity(5000D).build());

        operationLineProcessorService.process(line);

        System.out.println("CASO #6");//todo
        line = new ArrayList<>();

        line.add(Operation.builder().operationType("buy").unitCost(10.00D).quantity(10000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(2.00D).quantity(5000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(20.00D).quantity(2000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(20.00D).quantity(2000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(25.00D).quantity(1000D).build());

        operationLineProcessorService.process(line);

        System.out.println("CASO #7");//todo
        line = new ArrayList<>();

        line.add(Operation.builder().operationType("buy").unitCost(10.00D).quantity(10000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(2.00D).quantity(5000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(20.00D).quantity(2000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(20.00D).quantity(2000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(25.00D).quantity(1000D).build());

        line.add(Operation.builder().operationType("buy").unitCost(20.00D).quantity(10000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(15.00D).quantity(5000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(30.00D).quantity(4350D).build());
        line.add(Operation.builder().operationType("sell").unitCost(30.00D).quantity(650D).build());

        operationLineProcessorService.process(line);

        System.out.println("CASO #8");//todo
        line = new ArrayList<>();

        line.add(Operation.builder().operationType("buy").unitCost(10.00D).quantity(10000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(50.00D).quantity(10000D).build());
        line.add(Operation.builder().operationType("buy").unitCost(20.00D).quantity(10000D).build());
        line.add(Operation.builder().operationType("sell").unitCost(50.00D).quantity(10000D).build());

        operationLineProcessorService.process(line);

        System.out.println("\nArredondando Decimais\n");//todo
        line = new ArrayList<>();

        line.add(Operation.builder().operationType("buy").unitCost(20.00D).quantity(10D).build());
        line.add(Operation.builder().operationType("buy").unitCost(10.00D).quantity(5D).build());

        double result = ((20D * 10D) + (10D * 5D)) / (10D + 5D);
        double scale = Math.pow(10, 2);
        System.out.println("Math.pow(10, 2) " + Math.pow(10, 2)); //todo
        System.out.println("Math.round(result * scale) / scale " + Math.round(result * scale) / scale);//todo
        System.out.println("result: " + Math.round(result));//todo
        operationLineProcessorService.process(line);
    }
}
