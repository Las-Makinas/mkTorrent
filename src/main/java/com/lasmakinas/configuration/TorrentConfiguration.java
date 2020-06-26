package com.lasmakinas.configuration;

public class TorrentConfiguration {
    private final String announce;
    private final String comment;
    private final long creationDate;
    private final Info info;

    public static class Info {
        private final String name;
        private final long length;
        private final long pieceLength;
        private final String pieces;

        private Info(String name, long length, long pieceLength, String pieces) {
            this.name = name;
            this.length = length;
            this.pieceLength = pieceLength;
            this.pieces = pieces;
        }

        public static class Builder {
            private String name;
            private long length;
            private long pieceLength;
            private String pieces;

            public Builder name(String name) {
                this.name = name;
                return this;
            }

            public Builder length(long length) {
                this.length = length;
                return this;
            }

            public Builder pieceLength(long pieceLength) {
                this.pieceLength = pieceLength;
                return this;
            }

            public Builder pieces(String pieces) {
                this.pieces = pieces;
                return this;
            }

            public Info build() {
                return new Info(name, length, pieceLength, pieces);
            }
        }

        public String getName() {
            return name;
        }

        public long getLength() {
            return length;
        }

        public long getPieceLength() {
            return pieceLength;
        }

        public String getPieces() {
            return pieces;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "name='" + name + '\'' +
                    ", length=" + length +
                    ", pieceLength=" + pieceLength +
                    ", pieces='" + "BINARY_DATA" + '\'' +
                    '}';
        }
    }

    private TorrentConfiguration(String announce, String comment, long creationDate,
            Info info) {
        this.announce = announce;
        this.comment = comment;
        this.creationDate = creationDate;
        this.info = info;
    }

    public static class Builder {
        private String announce;
        private String comment;
        private long creationDate;
        private Info info;

        public Builder announce(String announce) {
            this.announce = announce;
            return this;
        }

        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder creationTime(long creationTime) {
            this.creationDate = creationTime;
            return this;
        }

        public Builder info(Info info) {
            this.info = info;
            return this;
        }

        public TorrentConfiguration build() {
            return new TorrentConfiguration(announce, comment, creationDate, info);
        }
    }

    public String getAnnounce() {
        return announce;
    }

    public String getComment() {
        return comment;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public Info getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "TorrentConfiguration{" +
                "announce='" + announce + '\'' +
                ", comment='" + comment + '\'' +
                ", creationDate=" + creationDate +
                ", info=" + info +
                '}';
    }
}
