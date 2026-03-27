import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====Weather====");
        System.out.println("Enter your city name: ");
        String city = scanner.nextLine().trim();

        if (city.isEmpty()) {
            System.out.println("The city name is empty, kindly recheck. Exiting.");
            return;
        }

        WeatherService service = new WeatherService();
        WeatherParser parser = new WeatherParser();

        try {
            String json = service.getWeather(city);
            WeatherData data = parser.parse(json);

            System.out.println("---------------------------");
            System.out.println("City        : " + data.getCity());
            System.out.println("Temperature : " + data.getTemperature() + "°C");
            System.out.println("Feels like  : " + data.getFeelslike() + "°C");
            System.out.println("Condition   : " + data.getDescription());
            System.out.println("Humidity    : " + data.getHumidity() + "%");
            System.out.println("---------------------------");

        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        scanner.close();
    }
}