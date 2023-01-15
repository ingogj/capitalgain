package br.com.doggoltda.capitalgain.services;

import br.com.doggoltda.capitalgain.models.Operation;
import br.com.doggoltda.capitalgain.models.StockContainer;
import br.com.doggoltda.capitalgain.utils.MathUtils;
import org.springframework.stereotype.Service;

@Service
public class SellOperationProcessorImpl implements OperationProcessorService{

    /**
     * This method calculates an operation, where the objective is to calculate the quantity and average unit cost of the stocks purchased
     *
     * @param stockContainer
     * @param operation
     */
    public void calculateWallet(StockContainer stockContainer, Operation operation) {
        calculateTax(stockContainer, operation);

        stockContainer.setQuantity(stockContainer.getQuantity() - operation.getQuantity());
        if(stockContainer.isEmpty()) {
            stockContainer.setAverangeUnitCost(0D);
            stockContainer.setBalance(0D);
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
        double operationBalance = (operation.getUnitCost() - stockContainer.getAverangeUnitCost()) * operation.getQuantity();
        stockContainer.setBalance(stockContainer.getBalance() + operationBalance);

        if(operation.getOperationCost() > 20000D && stockContainer.getBalance() > 0D && operationBalance > 0D){
            operation.setTax(MathUtils.round(stockContainer.getBalance() * 20D / 100D, 2));
        } else {
            operation.setTax(0D);
        }
    }
}