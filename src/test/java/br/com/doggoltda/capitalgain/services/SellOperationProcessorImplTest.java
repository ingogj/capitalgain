package br.com.doggoltda.capitalgain.services;

import br.com.doggoltda.capitalgain.models.Operation;
import br.com.doggoltda.capitalgain.models.StockContainer;
import org.junit.Assert;
import org.junit.Test;

public class SellOperationProcessorImplTest {

    SellOperationProcessorImpl buyOperationProcessor = new SellOperationProcessorImpl();

    @Test
    public void calculateSellThatEndsWithEmptyStockContainerAndProfitTest(){
        StockContainer stockContainer = StockContainer.builder()
                .averangeUnitCost(10.00D)
                .quantity(10000D)
                .balance(0D).build();
        Operation sellOperation = Operation.builder()
                .operationType("sell")
                .unitCost(30.00D)
                .quantity(10000D).build();

        buyOperationProcessor.calculateWallet(stockContainer,sellOperation);

        Assert.assertEquals(0.0D, stockContainer.getAverangeUnitCost(),0D);
        Assert.assertEquals(0.0D, stockContainer.getQuantity(), 0D);
        Assert.assertEquals(0.0D, stockContainer.getBalance(), 0D);

        Assert.assertEquals(30.0D, sellOperation.getUnitCost(), 0D);
        Assert.assertEquals(10000.0D, sellOperation.getQuantity(), 0D);
        Assert.assertEquals(40000.0D, sellOperation.getTax(), 0D);
        Assert.assertEquals("{\"tax\": 40000.00}", sellOperation.getFormattedTax());
    }

    @Test
    public void calculateSellWithPreviousLossAndProfitTest(){
        StockContainer stockContainer = StockContainer.builder()
                .averangeUnitCost(10.00D)
                .quantity(10000.0D)
                .balance(-90000.0D).build();
        Operation sellOperation = Operation.builder()
                .operationType("sell")
                .unitCost(30.00D)
                .quantity(1000.0D).build();

        buyOperationProcessor.calculateWallet(stockContainer,sellOperation);

        Assert.assertEquals(10.0D, stockContainer.getAverangeUnitCost(),0D);
        Assert.assertEquals(9000.0D, stockContainer.getQuantity(), 0D);
        Assert.assertEquals(-70000.0D, stockContainer.getBalance(), 0D);

        Assert.assertEquals(30.0D, sellOperation.getUnitCost(), 0D);
        Assert.assertEquals(1000.0D, sellOperation.getQuantity(), 0D);
        Assert.assertEquals(0.0D, sellOperation.getTax(), 0D);
        Assert.assertEquals("{\"tax\": 0.00}", sellOperation.getFormattedTax());
    }
}
