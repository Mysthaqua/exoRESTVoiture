package tibo.jee.exorestvoiture.service;

import jakarta.enterprise.context.ApplicationScoped;
import tibo.jee.exorestvoiture.entity.Car;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarService {
    private final List<Car> cars = new ArrayList<>();

    public Car get(int id) {
        return cars.stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Car> getAll() {
        return cars;
    }

    public Car create(String brand, int year, String color) {
        Car car = new Car(brand, year, color);
        cars.add(car);
        return car;
    }

    public Car update(int id, String brand, int year, String color) {
        Car car = get(id);
        if (car != null) {
            car.setBrand(brand);
            car.setYear(year);
            car.setColor(color);
        }
        return car;
    }

    public Car updateBrand(int id, String brand) {
        Car car = get(id);
        if (car != null) car.setBrand(brand);
        return car;
    }

    public Car updateYear(int id, int year) {
        Car car = get(id);
        if (car != null) car.setYear(year);
        return car;
    }

    public Car updateColor(int id, String color) {
        Car car = get(id);
        if (car != null) car.setColor(color);
        return car;
    }

    public Car delete(int id) {
        Car car = get(id);
        if (car != null) cars.remove(car);
        return car;
    }
}
