package com.lasmakinas.configuration.token;

public class DictionaryToken extends NonLeafToken {
    public DictionaryToken(String input) {
        super(input);
        int len = input.length();
        String dictionaryInput = input.substring(1, len - 1);
        while (dictionaryInput.length() > 0 && dictionaryInput.charAt(0) != 'e') {
            PairToken token = new PairToken(dictionaryInput);
            dictionaryInput = dictionaryInput.substring(token.length);
            children.add(token);
            this.length += token.length;
        }
        this.length += 2;
    }
}
