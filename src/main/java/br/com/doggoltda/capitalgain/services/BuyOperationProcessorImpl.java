package br.com.doggoltda.capitalgain.services;

import br.com.doggoltda.capitalgain.models.Operation;
import br.com.doggoltda.capitalgain.models.StockContainer;
import org.springframework.stereotype.Service;

@Service
class BuyOperationProcessorImpl implements OperationProcessorService {

    /**
     * This method calculates an operation, where the objective is to calculate the quantity and average unit cost of the stocks purchased
     *
     * @param stockContainer
     * @param operation
     */
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

    /**
     * This method calculates the TAX of an operation
     * To receive a tax, an operation must be:
     *  - a sell operation with total value above 20000,00
     *  - covering past losses
     *  - a profitable operation ( selling for a higher unit price than purchased one )
     *
     * @param stockContainer    Object that contains information about purchased stocks and balance
     * @param operation         Object containing operation values
     */
    public void calculateTax(StockContainer stockContainer, Operation operation) {
        operation.setTax(0D);
    }
}
