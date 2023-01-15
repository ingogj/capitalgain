package br.com.doggoltda.capitalgain.services;

import org.springframework.stereotype.Service;

import static br.com.doggoltda.capitalgain.enums.OperationType.BUY;

@Service
public class OperationProcessorFactory {

    /**
     * This method will return the correct implementation to the operations processor, depending on the type of operation.
     *
     * @param operationType     It will receive the type of operation "buy" or "sell"
     * @return                  A Operation processor implementation
     */
    public OperationProcessorService newOperationProcessor(String operationType){
        return BUY.getValue().equals(operationType) ? new BuyOperationProcessorImpl() : new SellOperationProcessorImpl();
    }
}
