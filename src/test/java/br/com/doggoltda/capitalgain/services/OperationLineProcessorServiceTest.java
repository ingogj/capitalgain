package br.com.doggoltda.capitalgain.services;

import br.com.doggoltda.capitalgain.models.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

public class OperationLineProcessorServiceTest {

    @Mock
    BuyOperationProcessorImpl buyOperationProcessor;

    @Mock
    OperationProcessorFactory operationProcessorFactory;

    @InjectMocks
    OperationLineProcessorService operationLineProcessorService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void processTest(){
        Mockito.when(operationProcessorFactory.newOperationProcessor(anyString()))
                .thenReturn(buyOperationProcessor);

        List<Operation> operationLine = new ArrayList<>();
        operationLine.add(Operation.builder()
                .operationType("buy")
                .unitCost(10.00D)
                .quantity(10000D)
                .tax(0D).build());

        operationLine.add(Operation.builder()
                .operationType("sell")
                .unitCost(20.00D)
                .quantity(5000D)
                .tax(10000D).build());

        operationLine.add(Operation.builder()
                .operationType("sell")
                .unitCost(20.00D)
                .quantity(5000D)
                .tax(0D).build());

        String result = operationLineProcessorService.process(operationLine);
        Assert.assertEquals("[{\"tax\": 0.00},{\"tax\": 10000.00},{\"tax\": 0.00}]\n", result);

    }
}
