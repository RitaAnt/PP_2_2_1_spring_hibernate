package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

public interface CarDao {
    User carList(String model, int series);
    void addCar(Car car);
}
