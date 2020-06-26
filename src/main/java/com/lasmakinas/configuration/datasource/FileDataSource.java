package com.lasmakinas.configuration.datasource;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileDataSource implements DataSource {

    private String filename;
    private Charset charset;

    public FileDataSource(String filename, Charset charset) {
        this.filename = filename;
        this.charset = charset;
    }

    @Override
    public String getData() {
        try (FileReader fileReader = new FileReader(filename, charset)) {
            final int BUFFER_SIZE = 1024;
            char[] buffer = new char[BUFFER_SIZE];
            StringBuilder sb = new StringBuilder();
            int size;
            while ((size = fileReader.read(buffer, 0, BUFFER_SIZE)) != -1) {
                sb.append(buffer, 0, size);
            }
            return sb.toString();
        } catch (IOException e) {
            // TODO do something in case of error
            return null;
        }
    }
}
