package com.lasmakinas.configuration.configurator;

import com.lasmakinas.configuration.TorrentConfiguration;
import com.lasmakinas.configuration.datasource.DataSource;
import com.lasmakinas.configuration.parser.Parser;
import com.lasmakinas.configuration.token.IntegerToken;
import com.lasmakinas.configuration.token.NonLeafToken;
import com.lasmakinas.configuration.token.PairToken;
import com.lasmakinas.configuration.token.StringToken;
import com.lasmakinas.configuration.token.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TorrentConfigurator implements Configurator<TorrentConfiguration> {
    @Override
    public TorrentConfiguration getConfiguration(Parser parser, DataSource dataSource) {
        Token token = parser.parse(dataSource);
        Map<String, Token> pairs = new HashMap<>();
        extractPairs(token, pairs);

        long length = getInteger(pairs.get("length"));
        String name = getString(pairs.get("name"));
        long pieceLength = getInteger(pairs.get("piece length"));
        String pieces = getString(pairs.get("pieces"));

        TorrentConfiguration.Info info = new TorrentConfiguration.Info.Builder().length(length).name(name)
                .pieceLength(pieceLength).pieces(pieces).build();

        String announce = getString(pairs.get("announce"));
        String comment = getString(pairs.get("comment"));
        long creationTime = getInteger(pairs.get("creation date"));

        return new TorrentConfiguration.Builder().announce(announce).comment(comment).creationTime(creationTime)
                .info(info).build();
    }

    private long getInteger(Token token) {
        if (token instanceof IntegerToken) {
            return ((IntegerToken) token).getValue();
        } else {
            return getInteger(((NonLeafToken) token).getChildren().get(0));
        }
    }

    private String getString(Token token) {
        if (token instanceof StringToken) {
            return ((StringToken) token).getValue();
        } else {
            return getString(((NonLeafToken) token).getChildren().get(0));
        }
    }

    private void extractPairs(Token token, Map<String, Token> pairs) {
        if (token instanceof NonLeafToken) {
            if (token instanceof PairToken) {
                PairToken pairToken = (PairToken) token;
                StringToken stringToken = (StringToken) pairToken.getChildren().get(0);
                pairs.put(stringToken.getValue(), pairToken.getChildren().get(1));
            }
            List<Token> children = ((NonLeafToken) token).getChildren();
            for (Token child : children) {
                extractPairs(child, pairs);
            }
        }
    }
}
