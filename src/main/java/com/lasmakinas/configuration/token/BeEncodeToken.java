package com.lasmakinas.configuration.token;


public class BeEncodeToken extends NonLeafToken {

    public BeEncodeToken(String input) {
        super(input);
        Token token = switch (input.charAt(0)) {
            case 'd' -> new DictionaryToken(input);
            case 'l' -> new ListToken(input);
            default -> new PrimitiveToken(input);
        };
        this.length = token.length;
        children.add(token);

    }
}
