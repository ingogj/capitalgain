package br.com.ingoltda.capitalgain.models;

import java.util.List;

public class JsonInputLine {

    private List<Operation> jsonLine;

    public String getLineTaxes(){
        StringBuilder linetaxes = new StringBuilder();
        linetaxes.append("[");
        for(int i=0; i < this.jsonLine.size(); i++) {
            linetaxes.append(this.jsonLine.get(i).getTaxToString());
            if (i == this.jsonLine.size()-1){
                linetaxes.append("]");
            } else linetaxes.append(";");
        }
        return linetaxes.toString();
    }
}
