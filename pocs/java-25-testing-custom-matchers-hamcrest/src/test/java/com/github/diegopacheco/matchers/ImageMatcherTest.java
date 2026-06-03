package com.github.diegopacheco.matchers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static com.github.diegopacheco.matchers.ImageMatcher.exist;
import static com.github.diegopacheco.matchers.ImageMatcher.hasFormat;
import static com.github.diegopacheco.matchers.ImageMatcher.hasSize;
import static com.github.diegopacheco.matchers.ImageMatcher.notEmpty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

class ImageMatcherTest {

    @TempDir
    static Path dir;

    static File jpg;
    static File png;

    @BeforeAll
    static void createImages() throws IOException {
        jpg = paint("sample.jpg", "jpg", 120, 80);
        png = paint("sample.png", "png", 64, 64);
    }

    static File paint(String name, String format, int width, int height) throws IOException {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0, 0, width, height);
        graphics.dispose();
        File file = dir.resolve(name).toFile();
        ImageIO.write(image, format, file);
        return file;
    }

    @Test
    void detectsJpgFormat() {
        assertThat(jpg, hasFormat("jpg"));
    }

    @Test
    void detectsPngFormat() {
        assertThat(png, hasFormat("png"));
    }

    @Test
    void rejectsWrongFormat() {
        assertThat(jpg, not(hasFormat("png")));
    }

    @Test
    void sizeIsNotEmpty() {
        assertThat(jpg, hasSize(notEmpty()));
    }

    @Test
    void existsInDirectory() {
        assertThat(dir.toFile(), exist("sample.png"));
    }

    @Test
    void missingFileDoesNotExist() {
        assertThat(dir.toFile(), not(exist("missing.png")));
    }
}
