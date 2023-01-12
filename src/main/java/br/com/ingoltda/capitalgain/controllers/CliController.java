package br.com.ingoltda.capitalgain.controllers;

import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.services.WalletCalculatorService;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CliController {


    public static void main(String[] args) {

        WalletCalculatorService walletCalculatorService = new WalletCalculatorService();

        List<Operation> line = new ArrayList<>();
        line.add(Operation.builder().operationType("buy").unitCost(10.00D).quantity(100D).build());
        line.add(Operation.builder().operationType("buy").unitCost(10.00D).quantity(1D).build());
        line.add(Operation.builder().operationType("sell").unitCost(15.00D).quantity(50D).build());
        line.add(Operation.builder().operationType("sell").unitCost(15.00D).quantity(50D).build());

        walletCalculatorService.addToWallet(line);


    }
}
