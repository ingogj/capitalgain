package br.com.ingoltda.capitalgain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Operation {

    private String operationType;
    private double unitCost;
    private double quantity;
    private double tax;
}
