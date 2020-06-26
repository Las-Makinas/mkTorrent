package com.lasmakinas.configuration.configurator;

import com.lasmakinas.configuration.datasource.DataSource;
import com.lasmakinas.configuration.parser.Parser;

public interface Configurator<T> {

    T getConfiguration(Parser parser, DataSource dataSource);
}
