package br.com.ingoltda.capitalgain.services;

import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.models.StockContainer;
import br.com.ingoltda.capitalgain.utils.MathUtils;

public class SellOperationProcessorImpl implements OperationProcessorService{

    public void walletCalculator(StockContainer stockContainer, Operation operation) {

        taxCalculator(stockContainer, operation);

        stockContainer.setQuantity(stockContainer.getQuantity() - operation.getQuantity());
        if(stockContainer.isEmpty()) {
            stockContainer.setAverangeUnitCost(0D);
            stockContainer.setBalance(0D);
        }
    }

    public void taxCalculator(StockContainer stockContainer, Operation operation) {
        double operationBalance = (operation.getUnitCost() - stockContainer.getAverangeUnitCost()) * operation.getQuantity();
        stockContainer.setBalance(stockContainer.getBalance() + operationBalance);

        if(operation.getOperationCost() > 20000D && stockContainer.getBalance() > 0D && operationBalance > 0D){
            operation.setTax(MathUtils.round(stockContainer.getBalance() * 20D / 100D, 2));
        } else {
            operation.setTax(0D);
        }
    }
}