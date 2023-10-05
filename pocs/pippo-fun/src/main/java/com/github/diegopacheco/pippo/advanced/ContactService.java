import java.util.Arrays;
import java.util.List;

public class ContactService {
    public List<Contact> getContacts() {
        return Arrays.asList(new Contact()
                .setName("x")
                .setPhone("124-777-888")
                .setAddress("bla st")
        );
    }

    public Contact getContact(int id) {
        return new Contact()
                .setName("x")
                .setPhone("124-777-888")
                .setAddress("bla st")
                .setId(id);
    }

}