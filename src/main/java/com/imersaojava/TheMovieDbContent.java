package com.imersaojava;

import java.util.List;

public class TheMovieDbContent {

    public List<Result> results;

    public TheMovieDbContent(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public class Result {

        public String original_title;
        public String poster_path;
        public double vote_average;
        public int vote_count;

        public Result(String original_title, String poster_path, double vote_average, int vote_count) {
            this.original_title = original_title;
            this.poster_path = poster_path;
            this.vote_average = vote_average;
            this.vote_count = vote_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

    }

}
