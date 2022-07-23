package com.imersaojava;

import java.util.List;

public class MarvelContent {

    public Data data;

    public MarvelContent(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Thumbnail {

        public String path;
        public String extension;

        public Thumbnail(String path, String extension) {
            this.path = path;
            this.extension = extension;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

    }

    public class Result {

        public String name;
        public Thumbnail thumbnail;

        public Result(String name, Thumbnail thumbnail) {
            this.name = name;
            this.thumbnail = thumbnail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
        }

    }

    public class Data {

        public List<Result> results;

        public Data(List<Result> results) {
            this.results = results;
        }

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }

    }

}
