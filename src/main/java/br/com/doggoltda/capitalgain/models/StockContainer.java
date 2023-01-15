package br.com.doggoltda.capitalgain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockContainer {

    private double averangeUnitCost;
    private double quantity;
    private double balance;

    public boolean isEmpty(){
        return this.getQuantity() == 0D;
    }

    public double getTotalAmount() {
        return this.averangeUnitCost * this.quantity;
    }
}
