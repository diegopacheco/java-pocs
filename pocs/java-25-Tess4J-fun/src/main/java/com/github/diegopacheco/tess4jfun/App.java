package com.github.diegopacheco.tess4jfun;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class App {

    private static final String TEXT = "HELLO JAVA OCR 25";

    public static void main(String[] args) throws Exception {
        Path workDir = Path.of("target", "generated-input");
        Files.createDirectories(workDir);

        Path image = workDir.resolve("ocr-input.png");
        Path pdf = workDir.resolve("pdf-input.pdf");
        Path renderedPdf = workDir.resolve("pdf-page-1.png");

        writeImage(image);
        writePdf(pdf);
        renderPdf(pdf, renderedPdf);

        System.out.println("Generated image: " + image.toAbsolutePath());
        System.out.println("Generated PDF: " + pdf.toAbsolutePath());
        System.out.println("PDF embedded text: " + extractPdfText(pdf).trim());

        try {
            ITesseract tesseract = tesseract();
            System.out.println("Image OCR text: " + clean(ocr(tesseract, image)));
            System.out.println("PDF OCR text: " + clean(ocr(tesseract, renderedPdf)));
        } catch (IllegalStateException error) {
            System.out.println("OCR error: " + error.getMessage());
            System.out.println("Install tesseract and run ./run.sh again.");
            System.exit(2);
        }
    }

    private static void writeImage(Path path) throws IOException {
        BufferedImage image = new BufferedImage(1200, 360, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 92));
        graphics.drawString(TEXT, 70, 205);
        graphics.dispose();
        ImageIO.write(image, "png", path.toFile());
    }

    private static void writePdf(Path path) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.LETTER);
            document.addPage(page);
            try (PDPageContentStream content = new PDPageContentStream(document, page)) {
                content.beginText();
                content.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 34);
                content.newLineAtOffset(72, 650);
                content.showText(TEXT);
                content.endText();
            }
            document.save(path.toFile());
        }
    }

    private static void renderPdf(Path pdf, Path image) throws IOException {
        try (PDDocument document = Loader.loadPDF(pdf.toFile())) {
            PDFRenderer renderer = new PDFRenderer(document);
            BufferedImage page = renderer.renderImageWithDPI(0, 300, ImageType.RGB);
            ImageIO.write(page, "png", image.toFile());
        }
    }

    private static String extractPdfText(Path pdf) throws IOException {
        try (PDDocument document = Loader.loadPDF(pdf.toFile())) {
            return new PDFTextStripper().getText(document);
        }
    }

    private static ITesseract tesseract() {
        nativeLibraryPath().ifPresent(path -> System.setProperty("jna.library.path", path));
        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("eng");
        tessDataPath().ifPresent(tesseract::setDatapath);
        return tesseract;
    }

    private static java.util.Optional<String> nativeLibraryPath() {
        return List.of(
                "/opt/homebrew/lib",
                "/usr/local/lib",
                "/usr/lib/x86_64-linux-gnu",
                "/usr/lib"
        ).stream().filter(path ->
                Files.exists(Path.of(path, "libtesseract.dylib")) ||
                Files.exists(Path.of(path, "libtesseract.so"))
        ).findFirst();
    }

    private static java.util.Optional<String> tessDataPath() {
        String env = System.getenv("TESSDATA_PREFIX");
        if (env != null && !env.isBlank()) {
            return java.util.Optional.of(env);
        }
        return List.of(
                "/opt/homebrew/share/tessdata",
                "/usr/local/share/tessdata",
                "/usr/share/tesseract-ocr/5/tessdata",
                "/usr/share/tessdata"
        ).stream().filter(path -> Files.isDirectory(Path.of(path))).findFirst();
    }

    private static String ocr(ITesseract tesseract, Path image) throws TesseractException {
        try {
            return tesseract.doOCR(image.toFile());
        } catch (UnsatisfiedLinkError error) {
            throw new IllegalStateException("Tesseract native library was not found. Install tesseract and make sure libtesseract is visible to the JVM.", error);
        }
    }

    private static String clean(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }
}
