package com.lasmakinas.configuration.token;

public class BeEncodeToken extends NonLeafToken {

    public BeEncodeToken(String input) {
        super(input);
        Token token = null;
        switch (input.charAt(0)) {
            case 'd':
                token = new DictionaryToken(input);
                break;
            case 'l':
                token = new ListToken(input);
                break;
            default:
                token = new PrimitiveToken(input);
        }
        this.length = token.length;
        children.add(token);

    }
}
