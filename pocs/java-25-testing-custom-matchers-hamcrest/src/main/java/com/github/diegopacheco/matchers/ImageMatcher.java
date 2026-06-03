package com.github.diegopacheco.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public final class ImageMatcher {

    private ImageMatcher() {
    }

    public static Matcher<File> hasFormat(String format) {
        return new TypeSafeMatcher<>() {
            @Override
            protected boolean matchesSafely(File file) {
                return normalize(format).equals(normalize(formatOf(file)));
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("an image with format ").appendValue(format);
            }

            @Override
            protected void describeMismatchSafely(File file, Description mismatch) {
                mismatch.appendText("format was ").appendValue(formatOf(file));
            }
        };
    }

    public static Matcher<File> hasSize(Matcher<? super Dimension> sizeMatcher) {
        return new TypeSafeMatcher<>() {
            @Override
            protected boolean matchesSafely(File file) {
                return sizeMatcher.matches(sizeOf(file));
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("an image whose size is ").appendDescriptionOf(sizeMatcher);
            }

            @Override
            protected void describeMismatchSafely(File file, Description mismatch) {
                Dimension size = sizeOf(file);
                mismatch.appendText("size was ").appendValue(size.width + "x" + size.height);
            }
        };
    }

    public static Matcher<File> exist(String name) {
        return new TypeSafeMatcher<>() {
            @Override
            protected boolean matchesSafely(File base) {
                return child(base, name).isFile();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("an existing image named ").appendValue(name);
            }

            @Override
            protected void describeMismatchSafely(File base, Description mismatch) {
                mismatch.appendText(child(base, name).getAbsolutePath()).appendText(" does not exist");
            }
        };
    }

    public static Matcher<Dimension> notEmpty() {
        return new TypeSafeMatcher<>() {
            @Override
            protected boolean matchesSafely(Dimension size) {
                return size.width > 0 && size.height > 0;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("a non-empty size");
            }

            @Override
            protected void describeMismatchSafely(Dimension size, Description mismatch) {
                mismatch.appendText("was ").appendValue(size.width + "x" + size.height);
            }
        };
    }

    private static File child(File base, String name) {
        return base.isDirectory() ? new File(base, name) : new File(name);
    }

    private static String normalize(String format) {
        if (format == null) {
            return "";
        }
        String lower = format.toLowerCase();
        return lower.equals("jpeg") ? "jpg" : lower;
    }

    private static String formatOf(File file) {
        try (ImageInputStream stream = ImageIO.createImageInputStream(file)) {
            if (stream == null) {
                return "";
            }
            Iterator<ImageReader> readers = ImageIO.getImageReaders(stream);
            if (!readers.hasNext()) {
                return "";
            }
            ImageReader reader = readers.next();
            try {
                return reader.getFormatName();
            } finally {
                reader.dispose();
            }
        } catch (IOException e) {
            return "";
        }
    }

    private static Dimension sizeOf(File file) {
        try (ImageInputStream stream = ImageIO.createImageInputStream(file)) {
            if (stream == null) {
                return new Dimension(0, 0);
            }
            Iterator<ImageReader> readers = ImageIO.getImageReaders(stream);
            if (!readers.hasNext()) {
                return new Dimension(0, 0);
            }
            ImageReader reader = readers.next();
            try {
                reader.setInput(stream);
                return new Dimension(reader.getWidth(0), reader.getHeight(0));
            } finally {
                reader.dispose();
            }
        } catch (IOException e) {
            return new Dimension(0, 0);
        }
    }
}
