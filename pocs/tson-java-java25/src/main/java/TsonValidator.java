import io.ltr8.tson.Tson;
import io.ltr8.tson.compiler.Diagnostic;
import io.ltr8.tson.compiler.TsonCompiledSchema;
import io.ltr8.tson.compiler.TsonReadContext;
import io.ltr8.tson.tree.TsonNode;

import java.util.List;

public final class TsonValidator {

    private final TsonCompiledSchema schema;

    public TsonValidator(String schemaText) {
        Tson tson = Tson.builder().build();
        this.schema = tson.treeRegistry().compile(tson.resolve(schemaText));
    }

    public TsonNode parse(String type, String data) {
        return (TsonNode) schema.get(type).read(data);
    }

    public List<Diagnostic> validate(String type, String data) {
        TsonReadContext context = TsonReadContext.collecting(data);
        schema.get(type).read(context);
        return context.diagnostics();
    }

    public boolean isValid(String type, String data) {
        return validate(type, data).isEmpty();
    }
}
