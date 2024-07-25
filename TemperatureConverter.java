import java.util.Scanner;

public class TemperatureConverter 
{

    // Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius)
    {
        return (celsius * 9 / 5) + 32;
    }

    // Celsius to Kelvin
    public static double celsiusToKelvin(double celsius) 
    {
        return celsius + 273.15;
    }

    // Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) 
    {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Fahrenheit to Kelvin
    public static double fahrenheitToKelvin(double fahrenheit)
    {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }

    // Kelvin to Celsius
    public static double kelvinToCelsius(double kelvin) 
    {
        return kelvin - 273.15;
    }

    // Kelvin to Fahrenheit
    public static double kelvinToFahrenheit(double kelvin) 
    {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }

    public static void main(String[] args)
  {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the temperature value:");
        double temperature;
        try
        {
            temperature = Double.parseDouble(scanner.nextLine());
        } 
        catch (NumberFormatException e)
        {
            System.out.println("Invalid temperature value. Please enter a numeric value.");
            return;
        }

        System.out.println("Enter the source scale (Celsius, Fahrenheit, Kelvin):");
        String sourceScale = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter the target scale (Celsius, Fahrenheit, Kelvin):");
        String targetScale = scanner.nextLine().trim().toLowerCase();

        double convertedTemperature = convertTemperature(temperature, sourceScale, targetScale);
        if (Double.isNaN(convertedTemperature)) 
        {
            System.out.println("Invalid scale input. Please enter valid scales.");
        } else
        {
            System.out.printf("The converted temperature is: %.2f %s\n", convertedTemperature, targetScale);
        }
    }

    public static double convertTemperature(double temperature, String sourceScale, String targetScale)
   {
        switch (sourceScale)
        {
            case "celsius":
                switch (targetScale) 
               {
                    case "fahrenheit":
                        return celsiusToFahrenheit(temperature);
                    case "kelvin":
                        return celsiusToKelvin(temperature);
                    case "celsius":
                        return temperature;
                }
                break;
            case "fahrenheit":
                switch (targetScale) 
                {
                    case "celsius":
                        return fahrenheitToCelsius(temperature);
                    case "kelvin":
                        return fahrenheitToKelvin(temperature);
                    case "fahrenheit":
                        return temperature;
                }
                break;
            case "kelvin":
                switch (targetScale)
               {
                    case "celsius":
                        return kelvinToCelsius(temperature);
                    case "fahrenheit":
                        return kelvinToFahrenheit(temperature);
                    case "kelvin":
                        return temperature;
                }
                break;
        }
        return Double.NaN; 
    }
}
