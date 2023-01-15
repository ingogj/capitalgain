package br.com.ingoltda.capitalgain.controllers;

import br.com.ingoltda.capitalgain.services.OperationLineProcessorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class CliControllerTest {

    @Mock
    OperationLineProcessorService operationLineProcessorService;

    @InjectMocks
    CliController cliController;

    @Test
    public void readContentFromStdInTest(){
        String output = "[{\"tax\": 0.00},{\"tax\": 10000.00},{\"tax\": 0.00}]";
        String userInput = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000},{\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 5000},{\"operation\":\"sell\", \"unit-cost\":5.00, \"quantity\": 5000}]" + System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        Mockito.when(operationLineProcessorService.process(any(List.class))).thenReturn(output);
        String result = cliController.readContentFromStdIn();

        Assert.assertEquals("[{\"tax\": 0.00},{\"tax\": 10000.00},{\"tax\": 0.00}]", result);
    }


}
