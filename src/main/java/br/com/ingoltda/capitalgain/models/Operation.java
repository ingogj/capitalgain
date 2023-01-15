package br.com.ingoltda.capitalgain.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Operation {

    @SerializedName("operation")
    private String operationType;

    @SerializedName("unit-cost")
    private double unitCost;

    @SerializedName("quantity")
    private double quantity;

    private double tax;

    public double getOperationCost(){
        return this.unitCost * this.quantity;
    }

    public String getFormattedTax() {
        return new StringBuilder().append("{\"tax\": ")
                .append(String.format("%.2f",tax).replace(",","."))
                .append("}").toString();
    }
}
