package br.com.ingoltda.capitalgain.services;

import static br.com.ingoltda.capitalgain.enums.OperationType.BUY;

public class OperationProcessorFactory {

    public OperationProcessorService newOperationProcessor(String operationType){
        return BUY.getValue().equals(operationType) ? new BuyOperationProcessorImpl() : new SellOperationProcessorImpl();
    }
}
