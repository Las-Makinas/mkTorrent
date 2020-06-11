package com.lasmakinas;

import java.security.SecureRandom;

public class Application {

    public static void main(String[] args) {
        new DummyClass().dummyMethod(new SecureRandom().nextInt(10));
    }
}
