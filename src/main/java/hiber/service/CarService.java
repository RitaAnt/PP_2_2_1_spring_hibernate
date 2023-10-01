package hiber.service;

import hiber.model.Car;
import hiber.model.User;



public interface CarService {
    void add(Car car);

    User carList(String model, int series);
}
