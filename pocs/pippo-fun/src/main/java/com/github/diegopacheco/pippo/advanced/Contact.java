public class Contact {

    private Integer id;
    private String name;
    private String phone;
    private String address;

    public Contact(){}

    public Contact setId(Integer id) {
        this.id = id;
        return this;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
