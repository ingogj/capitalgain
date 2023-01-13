package br.com.ingoltda.capitalgain.services;

import org.junit.Assert;
import org.junit.Test;

public class OperationProcessFactoryTest {

    @Test
    public void factoryBuyTest(){
        OperationProcessorFactory operationProcessorFactory = new OperationProcessorFactory();
        OperationProcessorService result = operationProcessorFactory.newOperationProcessor("buy");
        Assert.assertSame("Operation with buy type must return BuyOperationProcessorImpl", BuyOperationProcessorImpl.class, result.getClass());
    }

    @Test
    public void factorySellTest(){
        OperationProcessorFactory operationProcessorFactory = new OperationProcessorFactory();
        OperationProcessorService result = operationProcessorFactory.newOperationProcessor("sell");
        Assert.assertSame("Operation with sell type must return SellOperationProcessorImpl", SellOperationProcessorImpl.class, result.getClass());
    }
}
