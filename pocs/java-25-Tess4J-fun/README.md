# java-25-tess4j-fun

Maven Java 25 project that reads text from generated PNG and PDF files with Tess4J and PDFBox.

## Requirements

Java 25, Maven, and the native Tesseract runtime are required.

On macOS with Homebrew:

```bash
brew install tesseract
```

If tessdata is not found automatically, set:

```bash
export TESSDATA_PREFIX=/opt/homebrew/share/tessdata
```

## Build

```bash
mvn package
```

## Run

```bash
./run.sh
```

The app creates:

```text
target/generated-input/ocr-input.png
target/generated-input/pdf-input.pdf
target/generated-input/pdf-page-1.png
```

It prints the PDF embedded text, the OCR result for the PNG, and the OCR result for the rendered PDF page.

## Test

```bash
./test.sh
```
