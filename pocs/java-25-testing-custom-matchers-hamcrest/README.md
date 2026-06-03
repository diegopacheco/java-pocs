# Custom Hamcrest Matchers — Images, JSON & XML

Hand-rolled [Hamcrest](https://hamcrest.org/) `3.0` matchers that read like English and assert on real artifacts: image files, JSON documents and XML documents.

```
Java 25  •  Hamcrest 3.0  •  JUnit 6.1.0
```

## The Matchers

| Matcher | Subject | Asserts |
| --- | --- | --- |
| `ImageMatcher.hasFormat("jpg")` | `File` | image is encoded as the given format (`jpg`/`jpeg` are equal) |
| `ImageMatcher.hasSize(notEmpty())` | `File` | image dimensions satisfy a nested `Dimension` matcher |
| `ImageMatcher.exist("name.png")` | `File` directory | a file with that name exists inside the directory |
| `JsonMatcher.hasElement("person")` | `String` | JSON contains a key named `person` (top-level or nested) |
| `XMLMatcher.hasElement("people")` | `String` | XML contains an element tagged `people` (root or nested) |

Zero parsing libraries: images go through the JDK `ImageIO`, XML through the JDK DOM parser, and JSON through a tiny key scanner that respects string escaping and never mistakes a value for a key.

## Matcher Reference

### `ImageMatcher`

`import static com.github.diegopacheco.matchers.ImageMatcher.*;`

#### `Matcher<File> hasFormat(String format)`
Reads the file with `ImageIO` and compares the decoded format name against `format`, case-insensitively. `jpg` and `jpeg` are normalized to the same value, so a real JPEG passes `hasFormat("jpg")` and `hasFormat("jpeg")` alike.

- Passes: the file decodes and its format equals the requested one.
- Fails: wrong format, unreadable file, or not an image (mismatch reports `format was "JPEG"`).

```java
assertThat(picture, hasFormat("png"));
```

#### `Matcher<File> hasSize(Matcher<? super Dimension> sizeMatcher)`
Reads the pixel dimensions of the image into a `java.awt.Dimension` (`width` × `height`) and hands it to the nested matcher. Any `Dimension` matcher composes here, including the bundled `notEmpty()`.

- Passes: the nested matcher accepts the image's `Dimension`.
- Fails: the nested matcher rejects it (mismatch reports `size was "120x80"`).

```java
assertThat(picture, hasSize(notEmpty()));
```

#### `Matcher<Dimension> notEmpty()`
A `Dimension` matcher that passes when both `width > 0` and `height > 0`. Built to feed `hasSize(...)`, but usable on any `Dimension`.

```java
assertThat(picture, hasSize(notEmpty()));
```

#### `Matcher<File> exist(String name)`
Treats the subject `File` as a directory and checks that a child file called `name` exists inside it. If the subject is not a directory, `name` is resolved as a path on its own.

- Passes: `new File(dir, name)` is an existing file.
- Fails: the named file is absent (mismatch reports the absolute path that was missing).

```java
assertThat(folder, exist("sample.png"));
assertThat(folder, not(exist("missing.png")));
```

### `JsonMatcher`

`import static com.github.diegopacheco.matchers.JsonMatcher.hasElement;`

#### `Matcher<String> hasElement(String name)`
Scans a raw JSON `String` and passes when a key named `name` is present anywhere in the document — top-level or nested at any depth. The scanner only treats a string as a key when it is immediately followed by `:`, so JSON values are never matched as elements, and backslash escapes inside strings are honored.

- Passes: `name` appears as an object key.
- Fails: `name` is absent or only appears as a value (mismatch lists the keys that were found).

```java
String json = """
    { "person": { "name": "Diego" } }
    """;

assertThat(json, hasElement("person"));
assertThat(json, hasElement("name"));
assertThat(json, not(hasElement("Diego")));
```

### `XMLMatcher`

`import static com.github.diegopacheco.matchers.XMLMatcher.hasElement;`

#### `Matcher<String> hasElement(String name)`
Parses a raw XML `String` with the JDK DOM parser and passes when at least one element tagged `name` exists — root element or nested at any depth. Malformed XML never throws out of the matcher; it simply fails the assertion.

- Passes: an element with tag `name` is found.
- Fails: no such element, or the XML does not parse.

```java
String xml = """
    <people><person><name>Diego</name></person></people>
    """;

assertThat(xml, hasElement("people"));
assertThat(xml, hasElement("person"));
assertThat(xml, not(hasElement("address")));
```

## In Action

```java
import static com.github.diegopacheco.matchers.ImageMatcher.exist;
import static com.github.diegopacheco.matchers.ImageMatcher.hasFormat;
import static com.github.diegopacheco.matchers.ImageMatcher.hasSize;
import static com.github.diegopacheco.matchers.ImageMatcher.notEmpty;
import static com.github.diegopacheco.matchers.JsonMatcher.hasElement;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

assertThat(picture, hasFormat("jpg"));
assertThat(picture, hasSize(notEmpty()));
assertThat(folder,  exist("sample.png"));

assertThat(json, hasElement("person"));
assertThat(json, not(hasElement("address")));
```

Because they are real Hamcrest matchers, they compose with the whole standard library — `not(...)`, `allOf(...)`, `is(...)` — and produce readable mismatch messages:

```
Expected: an image with format "png"
     but: format was "JPEG"
```

## Layout

```
src/main/java/com/github/diegopacheco/matchers/
  ImageMatcher.java   hasFormat · hasSize · exist · notEmpty
  JsonMatcher.java    hasElement
  XMLMatcher.java     hasElement
src/test/java/com/github/diegopacheco/matchers/
  ImageMatcherTest.java   JPG/PNG painted on the fly into a @TempDir
  JsonMatcherTest.java    keys vs values, nested keys, missing keys
  XMLMatcherTest.java     root, nested and missing elements
```

## Build & Test

```bash
./tests.sh
```

which runs:

```bash
./mvnw clean test
```

### Result

```
[INFO]  T E S T S
[INFO] Running com.github.diegopacheco.matchers.ImageMatcherTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.269 s
[INFO] Running com.github.diegopacheco.matchers.JsonMatcherTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.004 s
[INFO] Running com.github.diegopacheco.matchers.XMLMatcherTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.017 s
[INFO]
[INFO] Tests run: 13, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```
