package com.lasmakinas.configuration.datasource;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class FileDataSource implements DataSource {

    private final String filename;
    private final Charset charset;

    public FileDataSource(String filename, Charset charset) {
        this.filename = filename;
        this.charset = charset;
    }

    @Override
    public String getData() {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filename), charset))) {
            final int BUFFER_SIZE = 1024;
            char[] buffer = new char[BUFFER_SIZE];
            StringBuilder sb = new StringBuilder();
            int size;
            while ((size = bufferedReader.read(buffer, 0, BUFFER_SIZE)) != -1) {
                sb.append(buffer, 0, size);
            }
            return sb.toString();
        } catch (IOException e) {
            return null;
        }
    }
}
