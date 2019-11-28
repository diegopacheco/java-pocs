import java.io.IOException;

import com.amazon.ion.IonReader;
import com.amazon.ion.IonWriter;
import com.amazon.ion.system.IonReaderBuilder;
import com.amazon.ion.system.IonTextWriterBuilder;

//
// docs: http://amzn.github.io/ion-docs/guides/cookbook.html
//
public class IonMain {

    private static void rewrite(String textIon, IonWriter writer) throws IOException {
        IonReader reader = IonReaderBuilder.standard().build(textIon);
        writer.writeValues(reader);
    }
    
    public static  void prettyPrint(String unformatted) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (IonWriter prettyWriter = IonTextWriterBuilder.pretty().build(stringBuilder)) {
            rewrite(unformatted, prettyWriter);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void downconvertToJson(String textIon) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (IonWriter jsonWriter = IonTextWriterBuilder.json().withPrettyPrinting().build(stringBuilder)) {
            rewrite(textIon, jsonWriter);
        }
        System.out.println(stringBuilder.toString());
    }
    
    public static void main(String[] args) throws Exception {
        String unformatted = "{level1: {level2: {level3: \"foo\"}, x: 2}, y: [a,b,c]}";
        prettyPrint(unformatted);
        
        String textIon = "{data: annot::{foo: null.string, bar: (2 + 2)}, time: 1969-07-20T20:18Z}";
        downconvertToJson(textIon);
    }
}