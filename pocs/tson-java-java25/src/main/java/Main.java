import io.ltr8.tson.compiler.Diagnostic;
import io.ltr8.tson.tree.TsonNode;

public class Main {

    static final String SCHEMA = """
            !!id:"https://example.com/2026/32/poc/person.tn"
            !!meta:"https://tson.io/2026/32/m/meta.tn"
            !!import:"https://tson.io/2026/32/m/core.tn"
            {
                role => !enum [admin member guest]

                address => {
                    street: text
                    city: text
                }

                person => {
                    id: uuid
                    name: text
                    age: int32
                    role: role
                    email: text?
                    address: address
                    skills: [text]
                }
            }""";

    static final String VALID = """
            {
                id: 9f1c8e2a-4b7d-4e6f-9a3b-2c5d8e7f1a09
                name: "Ada Lovelace"
                age: 30
                role: member
                address: { street: "12 Analytical Ave"  city: "London" }
                skills: [ mathematics analysis "computing" ]
            }""";

    static final String INVALID = """
            {
                id: 9f1c8e2a-4b7d-4e6f-9a3b-2c5d8e7f1a09
                age: "thirty"
                role: wizard
                address: { street: "12 Analytical Ave"  city: "London" }
                skills: [ mathematics ]
            }""";

    public static void main(String[] args) {
        TsonValidator validator = new TsonValidator(SCHEMA);

        TsonNode person = validator.parse("person", VALID);
        System.out.println("name:   " + person.get("name").asString().orElseThrow());
        System.out.println("age:    " + person.at("/age").asNumber().orElseThrow());
        System.out.println("city:   " + person.at("/address/city").asString().orElseThrow());
        System.out.println("skills: " + person.get("skills").elements().size());
        System.out.println("email:  " + person.get("email").asString().orElse("<absent>"));

        System.out.println("valid:   " + validator.isValid("person", VALID));
        System.out.println("invalid: " + validator.isValid("person", INVALID));
        for (Diagnostic d : validator.validate("person", INVALID)) {
            System.out.println("  [" + d.code() + "] " + d.path() + " -> " + d.message());
        }
    }
}
