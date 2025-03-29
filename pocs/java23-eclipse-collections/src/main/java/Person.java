public class Person {
    private String name;
    private PetType pet;

    public Person(String name, PetType pet) {
        this.name = name;
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public PetType getPet() {
        return pet;
    }

    public boolean hasPet(PetType petType) {
        return this.pet == petType;
    }
}