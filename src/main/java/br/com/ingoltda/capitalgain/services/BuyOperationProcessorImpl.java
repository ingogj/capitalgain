package br.com.ingoltda.capitalgain.services;

import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.models.StockContainer;

class BuyOperationProcessorImpl implements OperationProcessorService {

    public void walletCalculator(StockContainer stockContainer, Operation operation) {

        taxCalculator(stockContainer, operation);

        if (stockContainer.isEmpty()) {
            stockContainer.setAverangeUnitCost(operation.getUnitCost());
            stockContainer.setQuantity(operation.getQuantity());
        } else {
            double totalWalletInvested = stockContainer.totalSpent();
            double totalSpentOperation = operation.getOperationCost();

            stockContainer.setQuantity(stockContainer.getQuantity() + operation.getQuantity());
            stockContainer.setAverangeUnitCost((totalWalletInvested + totalSpentOperation) / stockContainer.getQuantity());
        }
    }

    public void taxCalculator(StockContainer stockContainer, Operation operation) {
        operation.setTax(0D);
    }
}
