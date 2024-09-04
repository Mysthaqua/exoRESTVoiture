package tibo.jee.exorestvoiture.entity;

import lombok.Data;

@Data
public class Car {
    private int id;
    private String brand;
    private int year;
    private String color;

    private static int idCpt = 0;

    public Car(String brand, int year, String color) {
        id = idCpt++;
        this.brand = brand;
        this.year = year;
        this.color = color;
    }
}
