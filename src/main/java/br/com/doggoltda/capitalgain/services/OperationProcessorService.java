package br.com.doggoltda.capitalgain.services;

import br.com.doggoltda.capitalgain.models.Operation;
import br.com.doggoltda.capitalgain.models.StockContainer;
import org.springframework.stereotype.Component;

@Component
public interface OperationProcessorService {

    void calculateWallet(StockContainer stockContainer, Operation operation);

    void calculateTax(StockContainer stockContainer, Operation operation);
}