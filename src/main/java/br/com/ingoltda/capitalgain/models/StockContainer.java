package br.com.ingoltda.capitalgain.models;

import br.com.ingoltda.capitalgain.utils.MathUtils;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StockContainer {

    private double averangeUnitCost;
    private double quantity;
    private double balance;

    public boolean isEmpty(){
        return this.getQuantity() == 0D;
    }

    public double totalSpent() {
        return this.averangeUnitCost * this.quantity;
    }
}
