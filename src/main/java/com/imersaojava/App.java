package com.imersaojava;

public class App {
    // chcp 65001 ATIVAR EMOJI NO TERMINAL
    // https://jsonutils.com/
    public static void main(String[] args) throws Exception {

        API myApi = API.NASA;

        ClienteHttp http = new ClienteHttp();

        String json = http.searchData(myApi.url());

        new NasaExtractor().extract(json);
        // new TheMovieDbExtractor().extract(json);
        // new MarvelExtractor().extract(json);

    }
}
