package com.lasmakinas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

class DummyClass {

    private static final Logger logger = LoggerFactory.getLogger(DummyClass.class);

    int dummyMethod(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Size must be greater than or equal to 0");
        logger.info("Creating array of size = {}, filled with 1s", size);
        int[] arr = new int[size];
        Arrays.fill(arr, 1);
        logger.info("Some weird stuff");
        arr[0] = arr[size-1];
        arr[size-1] = 1;
        logger.info("Success");
        arr[0] = 1;
        return arr[size - 1];
    }
}
