import java.util.Objects;

public class Vehicle {

    @TextFormat(format = TextFormatEnum.FIRST_CHAR_UPPER)
    private String brand;
    private int year;
    @TextFormat(format = TextFormatEnum.UPPERCASE)
    private String plate;
    @TextFormat(format = TextFormatEnum.LOWERCASE)
    private String color;
    @NumberFormat(format = NumberFormatEnum.DOT_TWO)
    private double averageConsumption;

    public Vehicle() {

    }

    public Vehicle(String brand, int year, String plate, String color, double averageConsumption) {
        this.brand = brand;
        this.year = year;
        this.plate = plate;
        this.color = color;
        this.averageConsumption = averageConsumption;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getAverageConsumption() {
        return averageConsumption;
    }

    public void setAverageConsumption(double averageConsumption) {
        this.averageConsumption = averageConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year && Double.compare(vehicle.averageConsumption, averageConsumption) == 0 && Objects.equals(brand, vehicle.brand) && Objects.equals(plate, vehicle.plate) && Objects.equals(color, vehicle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, year, plate, color, averageConsumption);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", year=" + year +
                ", plate='" + plate + '\'' +
                ", color='" + color + '\'' +
                ", averageConsumption=" + averageConsumption +
                '}';
    }
}
