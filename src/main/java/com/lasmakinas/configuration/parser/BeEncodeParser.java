package com.lasmakinas.configuration.parser;

import com.lasmakinas.configuration.datasource.DataSource;
import com.lasmakinas.configuration.token.BeEncodeToken;
import com.lasmakinas.configuration.token.Token;

public class BeEncodeParser implements Parser {

    @Override
    public Token parse(DataSource dataSource) {
        return new BeEncodeToken(dataSource.getData());
    }
}
