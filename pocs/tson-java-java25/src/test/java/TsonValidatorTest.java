import io.ltr8.tson.compiler.Diagnostic;
import io.ltr8.tson.tree.TsonNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TsonValidatorTest {

    static TsonValidator validator;

    @BeforeAll
    static void compileSchema() {
        validator = new TsonValidator(Main.SCHEMA);
    }

    static List<Diagnostic.Code> codes(List<Diagnostic> diagnostics) {
        return diagnostics.stream().map(Diagnostic::code).toList();
    }

    @Test
    @DisplayName("a document matching the schema produces no diagnostics")
    void validDocumentHasNoDiagnostics() {
        assertEquals(List.of(), validator.validate("person", Main.VALID));
        assertTrue(validator.isValid("person", Main.VALID));
    }

    @Test
    @DisplayName("parsing keeps TSON types, so numbers stay numbers instead of strings")
    void parseKeepsTypedLeaves() {
        TsonNode person = validator.parse("person", Main.VALID);

        assertEquals("Ada Lovelace", person.get("name").asString().orElseThrow());
        assertEquals(30, person.at("/age").asNumber().orElseThrow().intValue());
        assertTrue(person.get("age").asString().isEmpty());
    }

    @Test
    @DisplayName("parsing keeps structure, so nested records and arrays stay navigable")
    void parseKeepsStructure() {
        TsonNode person = validator.parse("person", Main.VALID);

        assertTrue(person.isRecord());
        assertEquals("London", person.at("/address/city").asString().orElseThrow());
        assertEquals(3, person.get("skills").elements().size());
        assertEquals("mathematics", person.at("/skills/0").asString().orElseThrow());
    }

    @Test
    @DisplayName("an optional field left out is absent, not an error")
    void optionalFieldIsAbsent() {
        TsonNode person = validator.parse("person", Main.VALID);

        assertTrue(person.get("email").asString().isEmpty());
        assertTrue(validator.isValid("person", Main.VALID));
    }

    @Test
    @DisplayName("a value of the wrong type is rejected at its own path")
    void wrongTypeIsRejected() {
        String data = """
                {
                    id: 9f1c8e2a-4b7d-4e6f-9a3b-2c5d8e7f1a09
                    name: "Ada Lovelace"
                    age: "thirty"
                    role: member
                    address: { street: "12 Analytical Ave"  city: "London" }
                    skills: [ mathematics ]
                }""";

        List<Diagnostic> diagnostics = validator.validate("person", data);

        assertEquals(List.of(Diagnostic.Code.ATOM_CONSTRAINT_VIOLATION), codes(diagnostics));
        assertEquals("/age", diagnostics.getFirst().path());
    }

    @Test
    @DisplayName("a required field left out is reported as missing")
    void missingRequiredFieldIsReported() {
        String data = """
                {
                    id: 9f1c8e2a-4b7d-4e6f-9a3b-2c5d8e7f1a09
                    age: 30
                    role: member
                    address: { street: "12 Analytical Ave"  city: "London" }
                    skills: [ mathematics ]
                }""";

        List<Diagnostic> diagnostics = validator.validate("person", data);

        assertEquals(List.of(Diagnostic.Code.FIELD_REQUIRED), codes(diagnostics));
        assertEquals("/name", diagnostics.getFirst().path());
    }

    @Test
    @DisplayName("a value outside the enum is rejected")
    void valueOutsideEnumIsRejected() {
        String data = """
                {
                    id: 9f1c8e2a-4b7d-4e6f-9a3b-2c5d8e7f1a09
                    name: "Ada Lovelace"
                    age: 30
                    role: wizard
                    address: { street: "12 Analytical Ave"  city: "London" }
                    skills: [ mathematics ]
                }""";

        List<Diagnostic> diagnostics = validator.validate("person", data);

        assertEquals(List.of(Diagnostic.Code.ATOM_CONSTRAINT_VIOLATION), codes(diagnostics));
        assertEquals("/role", diagnostics.getFirst().path());
    }

    @Test
    @DisplayName("every problem is reported in one pass, not just the first")
    void allProblemsAreReportedInOnePass() {
        List<Diagnostic> diagnostics = validator.validate("person", Main.INVALID);

        assertFalse(validator.isValid("person", Main.INVALID));
        assertEquals(3, diagnostics.size());
        assertEquals(List.of("/age", "/role", "/name"), diagnostics.stream().map(Diagnostic::path).toList());
    }

    @Test
    @DisplayName("a type the schema does not declare fails loudly")
    void unknownTypeFails() {
        assertThrows(RuntimeException.class, () -> validator.parse("robot", Main.VALID));
    }

    @Test
    @DisplayName("a schema that does not resolve fails at construction, not at read time")
    void brokenSchemaFailsAtConstruction() {
        String schema = """
                !!id:"https://example.com/2026/32/poc/broken.tn"
                !!meta:"https://tson.io/2026/32/m/meta.tn"
                !!import:"https://tson.io/2026/32/m/core.tn"
                {
                    thing => { field: no_such_type }
                }""";

        assertThrows(RuntimeException.class, () -> new TsonValidator(schema));
    }
}
