package com.imersaojava;

import java.util.Scanner;

public enum API {

    // docs
    // https://developer.marvel.com/docs#!/public/getCreatorCollection_get_0
    // https://api.nasa.gov/
    // https://developers.themoviedb.org/4/getting-started/authorization

    TMDB("https://api.themoviedb.org/3/trending/all/week?api_key=" + new ApiKey().getTmdbKey()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=" + new ApiKey().getNasaKey()
            + "&start_date=2022-06-01&end_date=2022-06-30"),
    MARVEL("https://gateway.marvel.com/v1/public/characters?ts=" + new ApiKey().getTimeStamp() + "&apikey="
            + new ApiKey().getMarvelPublicKey() + "&hash=" + new ApiKey().md5() + "&limit=100"),
    MARVEL_NAME("https://gateway.marvel.com/v1/public/characters?ts=" + new ApiKey().getTimeStamp() + "&apikey="
            + new ApiKey().getMarvelPublicKey() + "&hash=" + new ApiKey().md5() + "&nameStartsWith=" + inputName());

    private String url;

    API(String url) {
        this.url = url;

    }

    public String url() {
        return url;
    }

    public static String inputName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Type a Marvel character name: ");
        String characterName = in.next();

        return characterName;

    }

}
