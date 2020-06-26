package com.lasmakinas.configuration.token;

public class ListToken extends NonLeafToken {
    public ListToken(String input) {
        super(input);
        int len = input.length();
        String listInput = input.substring(1, len - 1);
        while (listInput.length() > 0 && listInput.charAt(0) != 'e') {
            BeEncodeToken token = new BeEncodeToken(listInput);
            listInput = listInput.substring(token.length);
            children.add(token);
            this.length += token.length;
        }
        this.length += 2;
    }

}
