public class Temperature {

    private Integer temperature;

    public Temperature(Integer celsius) {
        this.temperature = celsius;
    }

    public Integer toCelsius(){
        return temperature;
    }

    public static Temperature fromCelsiusString(String celsius){
        return new Temperature(Integer.parseInt(celsius));
    }

    public static Temperature fromCelsius(int celsius){
        return new Temperature(celsius);
    }

    public static Temperature fromFahrenheit(int fahrenheit){
        return new Temperature((fahrenheit - 32) * 5/9 );
    }

    public static Temperature fromKelvin(int kelvin){
        return new Temperature((int) (kelvin - 273.15));
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "temperature=" + temperature +
               '}';
    }
}
