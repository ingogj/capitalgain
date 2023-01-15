package br.com.ingoltda.capitalgain.services;

import org.springframework.stereotype.Service;

import static br.com.ingoltda.capitalgain.enums.OperationType.BUY;

@Service
public class OperationProcessorFactory {

    public OperationProcessorService newOperationProcessor(String operationType){
        return BUY.getValue().equals(operationType) ? new BuyOperationProcessorImpl() : new SellOperationProcessorImpl();
    }
}
