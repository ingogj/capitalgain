package br.com.doggoltda.capitalgain.services;

import br.com.doggoltda.capitalgain.models.Operation;
import br.com.doggoltda.capitalgain.models.StockContainer;
import org.junit.Assert;
import org.junit.Test;

public class BuyOperationProcessorImplTest {

    BuyOperationProcessorImpl buyOperationProcessor = new BuyOperationProcessorImpl();

    @Test
    public void calculateBuyWithEmptyStockContainerTest(){
        StockContainer empty = StockContainer.builder().build();
        Operation buyOperation = Operation.builder()
                .operationType("buy")
                .unitCost(10.00D)
                .quantity(10000D).build();

        buyOperationProcessor.calculateWallet(empty,buyOperation);

        Assert.assertEquals(10D, empty.getAverangeUnitCost(),0D);
        Assert.assertEquals(10000D, empty.getQuantity(), 0D);
        Assert.assertEquals(0D, empty.getBalance(), 0D);

        Assert.assertEquals(10D, buyOperation.getUnitCost(), 0D);
        Assert.assertEquals(10000D, buyOperation.getQuantity(), 0D);
        Assert.assertEquals(0D, buyOperation.getTax(), 0D);
        Assert.assertEquals("{\"tax\": 0.00}", buyOperation.getFormattedTax());
    }

    @Test
    public void calculateBuyWithStockContainerNotEmptyTest(){
        StockContainer stockContainer = StockContainer.builder()
                .averangeUnitCost(10D)
                .quantity(10000D)
                .balance(0D).build();
        Operation buyOperation = Operation.builder()
                .operationType("buy")
                .unitCost(20.00D)
                .quantity(10000D).build();

        buyOperationProcessor.calculateWallet(stockContainer,buyOperation);

        Assert.assertEquals(15D, stockContainer.getAverangeUnitCost(),0D);
        Assert.assertEquals(20000D, stockContainer.getQuantity(), 0D);
        Assert.assertEquals(0D, stockContainer.getBalance(), 0D);

        Assert.assertEquals(20D, buyOperation.getUnitCost(), 0D);
        Assert.assertEquals(10000D, buyOperation.getQuantity(), 0D);
        Assert.assertEquals(0D, buyOperation.getTax(), 0D);
        Assert.assertEquals("{\"tax\": 0.00}", buyOperation.getFormattedTax());
    }
}
