package br.com.ingoltda.capitalgain.services;

import br.com.ingoltda.capitalgain.enums.OperationType;
import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.models.Wallet;

import java.util.List;

public class WalletCalculatorService {

    public List<Operation> addToWallet(List<Operation> operationList){
        Wallet wallet = new Wallet();
        operationList.forEach(ol -> {
            if (wallet.isEmpty()) {
                wallet.setAverangeUnitCost(ol.getUnitCost());
                wallet.setQuantity(ol.getQuantity());
                ol.setTax(0D);
            } else {
                calculateOperation(wallet, ol);
                //taxCalculatorService.
            }
            //System.out.println(wallet.toString()); //todo
        });
        return operationList;
    }

    private void calculateOperation(Wallet wallet, Operation operation){

        double totalWalletInvested = (wallet.getAverangeUnitCost() * wallet.getQuantity());
        double totalSpentOperation = (operation.getUnitCost() * operation.getQuantity());

        if(OperationType.BUY.getType().equals(operation.getOperationType())){
            wallet.setQuantity(wallet.getQuantity() + operation.getQuantity());
            wallet.setAverangeUnitCost((totalWalletInvested + totalSpentOperation) / wallet.getQuantity());
        } else {
            wallet.setQuantity(wallet.getQuantity() - operation.getQuantity());
            if(wallet.isEmpty()) {
                wallet.setAverangeUnitCost(0D);
            } else {
                wallet.setAverangeUnitCost((totalWalletInvested - totalSpentOperation) / wallet.getQuantity());
            }
        }
    }
}
