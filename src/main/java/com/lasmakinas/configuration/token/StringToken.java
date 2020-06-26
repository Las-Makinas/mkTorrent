package com.lasmakinas.configuration.token;

public class StringToken extends LeafToken<String> {
    public StringToken(String input) {
        super(input);
        int separatorPosition = input.indexOf(":");
        int size = Integer.parseInt(input.substring(0, separatorPosition));
        this.length = separatorPosition + size + 1;
        value = input.substring(separatorPosition + 1, separatorPosition + size + 1);
    }
}
