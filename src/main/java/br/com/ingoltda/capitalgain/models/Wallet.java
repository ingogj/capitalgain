package br.com.ingoltda.capitalgain.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Wallet {

    private double averangeUnitCost;
    private double quantity;

    public boolean isEmpty(){
        return this.getQuantity() == 0D;
    }
}
