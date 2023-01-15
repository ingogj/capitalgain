package br.com.ingoltda.capitalgain.services;

import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.models.StockContainer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationLineProcessorService {

    private OperationProcessorFactory operationProcessorFactory;

    public OperationLineProcessorService() {
        this.operationProcessorFactory = new OperationProcessorFactory();
    }

    public String process(List<Operation> operationsLine){
        StockContainer stockContainer = StockContainer.builder().build();
        StringBuilder resultTaxes = new StringBuilder().append("[");

        operationsLine.forEach(operation -> {
            operationProcessorFactory
                    .newOperationProcessor(operation.getOperationType())
                    .calculateWallet(stockContainer, operation);

            resultTaxes.append(operation.getFormattedTax()).append(",");
        });
        resultTaxes.delete(resultTaxes.length()-1, resultTaxes.length()).append("]\n");
        return resultTaxes.toString();
    }
}
