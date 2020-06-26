package com.lasmakinas.configuration.token;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class NonLeafToken extends Token {
    protected List<Token> children;

    public NonLeafToken(String input) {
        super(input);
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + children.stream().map(Object::toString)
                .collect(Collectors.joining(",")) + ")";
    }

    public List<Token> getChildren() {
        return children;
    }
}
