package br.com.ingoltda.capitalgain.enums;

public enum OperationType {
        BUY("buy"),
        SELL("sell");

        private String type;

        public String getType() {
                return this.type;
        }

        private OperationType(String type) {
                this.type = type;
        }
}
