public class WeatherData
{
    private String city;
    private double temperature;
    private double feelslike;
    private String description;
    private int humidity;

    public WeatherData(String city, double temperature, double feelslike,String description, int humidity)
    {
        this.city = city;
        this.temperature = temperature;
        this.feelslike = feelslike;
        this.description = description;
        this.humidity = humidity;
    }

    public String getCity() {
        return city; }

    public double getFeelslike() {
        return feelslike;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    public int getHumidity() {
        return humidity;
    }
}



