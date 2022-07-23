package com.imersaojava;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.imersaojava.TheMovieDbContent.Result;

public class TheMovieDbExtractor implements Extractor {

    @Override
    public void extract(String json) throws IOException, MalformedURLException, Exception {
        TheMovieDbContent atribute = new Gson().fromJson(json, TheMovieDbContent.class);

        List<Result> films = atribute.getResults();
        StickersGenerator generator = new StickersGenerator();

        for (Result result : films) {

            String formatName = ".png";
            String fileName = result.getOriginal_title() + formatName;
            String image = "https://image.tmdb.org/t/p/w500" + result.getPoster_path();
            String rating = Double.toString(result.getVote_average());

            System.out.println(
                    "Titulo: " + TERMINALFORMAT.BRIGHT_GREEN + result.getOriginal_title() + TERMINALFORMAT.RESET);
            System.out.println("Imagem - Url: " + TERMINALFORMAT.BRIGHT_AZUL + image + TERMINALFORMAT.RESET);
            System.out.println(
                    "Nota: " + TERMINALFORMAT.BRIGHT_YELLOW + rating + ratingStars(rating) + TERMINALFORMAT.RESET);
            System.out.println();

            InputStream inputStream = new URL(image).openStream();
            Path stickers = Paths.get("stickers");
            Files.createDirectories(stickers);
            generator.create(inputStream, fileName, formatName);

        }

    }

    public static String ratingStars(String rating) {

        String stars = "";
        for (int i = 0; i < Math.floor(Double.parseDouble(rating)); i++) {

            stars = stars + " " + TERMINALFORMAT.STAR;

        }

        return stars;

    }

}
