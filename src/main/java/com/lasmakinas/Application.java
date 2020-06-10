package com.lasmakinas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Result = {}", new DummyClass().dummyMethod(new SecureRandom().nextInt(10)));
    }
}
