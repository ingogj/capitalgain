package br.com.ingoltda.capitalgain.services;

import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.models.StockContainer;
import org.springframework.stereotype.Component;

@Component
public interface OperationProcessorService {

    void calculateWallet(StockContainer stockContainer, Operation operation);

    void calculateTax(StockContainer stockContainer, Operation operation);
}