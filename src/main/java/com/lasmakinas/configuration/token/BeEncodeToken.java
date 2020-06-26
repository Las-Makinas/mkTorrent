package com.lasmakinas.configuration.token;

public class BeEncodeToken extends NonLeafToken {

    public BeEncodeToken(String input) {
        super(input);
        Token token;
        if (input.charAt(0) == 'd') {
            token = new DictionaryToken(input);
        } else if (input.charAt(0) == 'l') {
            token = new ListToken(input);
        } else {
            token = new PrimitiveToken(input);
        }
        this.length = token.length;
        children.add(token);

    }
}
