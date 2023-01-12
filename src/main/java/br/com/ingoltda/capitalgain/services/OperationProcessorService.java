package br.com.ingoltda.capitalgain.services;

import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.models.StockContainer;

public interface OperationProcessorService {

    void walletCalculator(StockContainer stockContainer, Operation operation);

    void taxCalculator(StockContainer stockContainer, Operation operation);
}