
public class Main {
    public static void main(String args[]) {
        Temperature temperature1 = Temperature.fromCelsius(32);
        Temperature temperature2 = Temperature.fromFahrenheit(32);
        Temperature temperature3 = Temperature.fromKelvin(32);

        System.out.println(Temperature.fromCelsiusString("45").toCelsius());
        System.out.println(temperature1.toCelsius());
        System.out.println(temperature2.toCelsius());
        System.out.println(temperature3.toCelsius());
    }
}
