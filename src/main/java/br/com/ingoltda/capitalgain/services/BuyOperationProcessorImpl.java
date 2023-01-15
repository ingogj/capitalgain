package br.com.ingoltda.capitalgain.services;

import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.models.StockContainer;
import org.springframework.stereotype.Service;

@Service
class BuyOperationProcessorImpl implements OperationProcessorService {

    public void calculateWallet(StockContainer stockContainer, Operation operation) {

        calculateTax(stockContainer, operation);

        if (stockContainer.isEmpty()) {
            stockContainer.setAverangeUnitCost(operation.getUnitCost());
            stockContainer.setQuantity(operation.getQuantity());
        } else {
            double stockTotalAmount = stockContainer.getTotalAmount();
            double operationCost = operation.getOperationCost();

            stockContainer.setQuantity(stockContainer.getQuantity() + operation.getQuantity());
            stockContainer.setAverangeUnitCost((stockTotalAmount + operationCost) / stockContainer.getQuantity());
        }
    }

    public void calculateTax(StockContainer stockContainer, Operation operation) {
        operation.setTax(0D);
    }
}
