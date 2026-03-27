import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

    public class WeatherParser {
        public WeatherData parse(String json) {
            JsonObject root = JsonParser.parseString(json).getAsJsonObject();

            String city = root.get("name").getAsString();

            JsonObject main = root.getAsJsonObject("main");
            double temperature = main.get("temp").getAsDouble();
            double feelsLike = main.get("feels_like").getAsDouble();
            int humidity = main.get("humidity").getAsInt();

            JsonArray weatherArray = root.getAsJsonArray("weather");
            String description = weatherArray.get(0).getAsJsonObject()
                    .get("description").getAsString();

            return new WeatherData(city, temperature, feelsLike, description, humidity);
        }
    }


