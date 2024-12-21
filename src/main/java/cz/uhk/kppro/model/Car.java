package cz.uhk.kppro.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Car {
    private int id = -1;

    @NotBlank(message = "seš marnej")
    @Size(min = 7, max = 7)
    private String licencePlate;
    private String color;

    @Min(value = 2)
    @Max(value = 7)
    private int numberOfSeats;

    public Car(String color, int numberOfSeats, String licencePlate) {
        this.color = color;
        this.numberOfSeats = numberOfSeats;
        this.licencePlate = licencePlate;
    }

    public Car(){}

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
