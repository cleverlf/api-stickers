package com.imersaojava;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class NasaExtractor implements Extractor{

    @Override
    public void extract(String json) throws IOException, MalformedURLException, Exception {
        NasaContent[] atribute = new Gson().fromJson(json, NasaContent[].class);        
                
        StickersGenerator generator = new StickersGenerator();

        
        for (NasaContent result : atribute) {
            String formatName = ".png";
            String fileName = result.getTitle() + formatName;
            String image = result.getHdurl();
            

            System.out.println("Titulo: " + TERMINALFORMAT.BRIGHT_GREEN + result.getTitle() + TERMINALFORMAT.RESET);
            System.out.println("Imagem - Url: " + TERMINALFORMAT.BRIGHT_AZUL + image + TERMINALFORMAT.RESET); 
            System.out.println();
            
            
            InputStream inputStream = new URL(image).openStream();
            Path stickers = Paths.get("stickers");
            Files.createDirectories(stickers);
            generator.create(inputStream, fileName, formatName);

        }
        
    }
    
}
