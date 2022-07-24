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
import com.imersaojava.MarvelContent.Result;

public class MarvelExtractor implements Extractor {

    @Override
    public void extract(String json) throws IOException, MalformedURLException, Exception {
        MarvelContent atribute = new Gson().fromJson(json, MarvelContent.class);

        List<Result> personagens = atribute.getData().getResults();
        StickersGenerator generator = new StickersGenerator();

        for (Result result : personagens) {

            String formatName = "." + result.thumbnail.getExtension();
            String fileName = result.getName().replaceAll("/", "-") + formatName;
            String image = result.getThumbnail().getPath() + formatName;

            System.out.println(
                    "Titulo: " + TERMINALFORMAT.BRIGHT_GREEN.getS() + result.getName() + TERMINALFORMAT.RESET.getS());
            System.out.println(
                    "Imagem - Url: " + TERMINALFORMAT.BRIGHT_AZUL.getS() + image + TERMINALFORMAT.RESET.getS());
            System.out.println();

            InputStream inputStream = new URL(image).openStream();
            Path stickers = Paths.get("stickers");
            Files.createDirectories(stickers);
            generator.create(inputStream, fileName, formatName);

        }

    }
    

}
