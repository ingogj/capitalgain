package br.com.ingoltda.capitalgain.enums;

public enum OperationType {
        BUY("buy"),
        SELL("sell");

        private final String value;

        OperationType(String value) {
                this.value = value;
        }
        public String getValue() {
                return value;
        }
}
