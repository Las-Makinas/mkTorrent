package com.lasmakinas.configuration.parser;

import com.lasmakinas.configuration.datasource.DataSource;
import com.lasmakinas.configuration.token.Token;

public interface Parser {

    Token parse(DataSource dataSource);

}
