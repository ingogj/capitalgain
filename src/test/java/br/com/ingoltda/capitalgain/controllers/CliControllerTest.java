package br.com.ingoltda.capitalgain.controllers;

import br.com.ingoltda.capitalgain.models.Operation;
import br.com.ingoltda.capitalgain.services.OperationLineProcessorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CliControllerTest {

    @Mock
    OperationLineProcessorService operationLineProcessorService;

    @InjectMocks
    CliController cliController;

    @Captor
    ArgumentCaptor<List<Operation>> operationList;

    @Test
    public void readContentFromStdInTest(){
        String output = "[{\"tax\": 0.00},{\"tax\": 10000.00},{\"tax\": 0.00}]";
        String userInput = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000},{\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 5000},{\"operation\":\"sell\", \"unit-cost\":5.00, \"quantity\": 5000}]" + System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Mockito.when(operationLineProcessorService.process(any(List.class))).thenReturn(output);
        String result = cliController.readContentFromStdIn();

        verify(operationLineProcessorService).process(operationList.capture());
        Assert.assertEquals(3, operationList.getValue().size());

        Assert.assertEquals("buy", operationList.getValue().get(0).getOperationType());
        Assert.assertEquals(10.0D, operationList.getValue().get(0).getUnitCost(), 0D);
        Assert.assertEquals(10000.0D, operationList.getValue().get(0).getQuantity(), 0D);

        Assert.assertEquals("sell", operationList.getValue().get(1).getOperationType());
        Assert.assertEquals(20.0D, operationList.getValue().get(1).getUnitCost(), 0D);
        Assert.assertEquals(5000.0D, operationList.getValue().get(1).getQuantity(), 0D);

        Assert.assertEquals("sell", operationList.getValue().get(2).getOperationType());
        Assert.assertEquals(5.0D, operationList.getValue().get(2).getUnitCost(), 0D);
        Assert.assertEquals(5000.0D, operationList.getValue().get(2).getQuantity(), 0D);

        Assert.assertEquals("[{\"tax\": 0.00},{\"tax\": 10000.00},{\"tax\": 0.00}]", result);
    }
}
