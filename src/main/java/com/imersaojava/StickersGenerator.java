package com.imersaojava;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickersGenerator {

    public void create(InputStream inputStream, String fileName, String formatName) throws Exception {

        BufferedImage originalImage = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int width = 400;
        int height = (originalImage.getHeight() * width) / originalImage.getWidth();
        int newHeight = height + 50;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, width, height, null);

        // configurar a fonte e escrever uma frase na nova imagem
        String text = "TOPZERA";
        Font font = new Font("Impact", Font.BOLD, 37);

        TextLayout textLayout = new TextLayout(text, font, graphics.getFontRenderContext());
        Shape shape = textLayout.getOutline(null);

        graphics.setColor(Color.BLACK);
        graphics.setFont(font);

        FontMetrics phraseSize = graphics.getFontMetrics(font);

        float x = ((float) (newImage.getWidth() / 2) - ((float) phraseSize.stringWidth(text)) / 2);
        int y = newImage.getHeight() - 10;

        graphics.translate(x, y);
        graphics.setStroke(new BasicStroke(4));
        graphics.setColor(Color.BLACK);
        graphics.draw(shape);
        graphics.setColor(Color.GREEN);
        graphics.fill(shape);

        // escrever a nova imagem em um arquivo

        ImageIO.write(newImage, "png", new File("stickers/" + fileName));

    }

}
