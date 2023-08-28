public class Bear {
    public String color;
    private int age;

    public Bear() {}

    public Bear(String color, int age) {
        this.color = color;
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Bear{" +
                "color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
