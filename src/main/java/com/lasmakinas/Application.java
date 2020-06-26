package com.lasmakinas;

import com.lasmakinas.configuration.TorrentConfiguration;
import com.lasmakinas.configuration.configurator.TorrentConfigurator;
import com.lasmakinas.configuration.datasource.FileDataSource;
import com.lasmakinas.configuration.parser.BeEncodeParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private static final String DEBIAN_FILENAME = "debian-edu-10.4.0-amd64-netinst.iso.torrent";

    public static void main(String[] args) {
        BeEncodeParser parser = new BeEncodeParser();
        FileDataSource fileDataSource = new FileDataSource(DEBIAN_FILENAME, StandardCharsets.US_ASCII);
        TorrentConfigurator torrentConfigurator = new TorrentConfigurator();
        TorrentConfiguration configuration = torrentConfigurator.getConfiguration(parser, fileDataSource);
        logger.info("Configuration: {}", configuration);
    }
}
