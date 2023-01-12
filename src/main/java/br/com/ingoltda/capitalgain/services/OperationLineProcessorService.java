package br.com.ingoltda.capitalgain.services;

import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.models.StockContainer;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OperationLineProcessorService {

    public List<Operation> process(List<Operation> operationList){
        StockContainer stockContainer = new StockContainer();
        OperationProcessorFactory operationProcessorFactory = new OperationProcessorFactory();

        operationList.forEach(operation -> {

            operationProcessorFactory.newOperationProcessor(operation.getOperationType()).walletCalculator(stockContainer, operation);

            System.out.println(stockContainer.toString() + " WALLET: " + stockContainer.getAverangeUnitCost() * stockContainer.getQuantity() + " OP: " + operation.getOperationCost() + " TAX: " + operation.getTax()); //todo
        });
        return operationList;
    }
}
