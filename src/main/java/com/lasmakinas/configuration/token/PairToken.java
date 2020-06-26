package com.lasmakinas.configuration.token;

public class PairToken extends NonLeafToken {

    public PairToken(String input) {
        super(input);
        StringToken keyToken = new StringToken(input);
        children.add(keyToken);
        this.length = keyToken.length;
        String newInput = input.substring(keyToken.length);
        Token token = new BeEncodeToken(newInput);
        children.add(token);
        this.length += token.length;
    }
}
