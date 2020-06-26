package com.lasmakinas;

import com.lasmakinas.configuration.TorrentConfiguration;
import com.lasmakinas.configuration.configurator.TorrentConfigurator;
import com.lasmakinas.configuration.datasource.FileDataSource;
import com.lasmakinas.configuration.parser.BeEncodeParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

@SuppressWarnings("unused")
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private static final String DEBIAN_FILENAME = "debian-edu-10.4.0-amd64-netinst.iso.torrent";
    private static final String UBUNTU_FILENAME = "ubuntu-18.04.4-desktop-amd64.iso.torrent";

    public static void main(String[] args) {
        BeEncodeParser parser = new BeEncodeParser();
        FileDataSource fileDataSource = new FileDataSource(UBUNTU_FILENAME, StandardCharsets.US_ASCII);
        TorrentConfigurator torrentConfigurator = new TorrentConfigurator();
        TorrentConfiguration configuration = torrentConfigurator.getConfiguration(parser, fileDataSource);
        logger.info("Configuration: {}", configuration);
    }
}
