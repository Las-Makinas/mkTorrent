package com.lasmakinas.configuration.token;

public abstract class LeafToken<T> extends Token {

    protected T value;

    public LeafToken(String input) {
        super(input);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + value + ')';
    }

    public T getValue() {
        return value;
    }

}
