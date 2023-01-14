package br.com.ingoltda.capitalgain.services;

import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.models.StockContainer;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OperationLineProcessorService {

    public String process(List<Operation> operationsLine){
        StockContainer stockContainer = new StockContainer();
        OperationProcessorFactory operationProcessorFactory = new OperationProcessorFactory();

        StringBuilder resultTaxes = new StringBuilder().append("[");
        operationsLine.forEach(operation -> {

            operationProcessorFactory.newOperationProcessor(operation.getOperationType()).walletCalculator(stockContainer, operation);
            resultTaxes.append(operation.getTaxToString()).append(",");
            //System.out.println(stockContainer.toString() + " WALLET: " + stockContainer.getAverangeUnitCost() * stockContainer.getQuantity() + " OP: " + operation.getOperationCost() + " TAX: " + operation.getTax()); //todo
        });
        resultTaxes.delete(resultTaxes.length()-1, resultTaxes.length()).append("]\n");
        return resultTaxes.toString();
    }
}
