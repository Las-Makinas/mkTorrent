package com.lasmakinas.configuration.token;

public class IntegerToken extends LeafToken<Long> {
    public IntegerToken(String input) {
        super(input);
        int lastElementPosition = input.indexOf('e');
        this.length = lastElementPosition + 1;
        value = Long.parseLong(input.substring(1, lastElementPosition - 1));
    }
}
