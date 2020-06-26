package com.lasmakinas.configuration.token;

public class PrimitiveToken extends NonLeafToken {

    public PrimitiveToken(String input) {
        super(input);
        LeafToken<?> token = input.charAt(0) == 'i' ? new IntegerToken(input) : new StringToken(input);
        children.add(token);
        this.length = token.length;
    }

}