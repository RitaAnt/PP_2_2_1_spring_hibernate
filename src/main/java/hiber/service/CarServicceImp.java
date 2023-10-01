package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServicceImp implements CarService{
    private CarDao carDao;

    @Autowired
    public CarServicceImp(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public void add(Car car) {
        carDao.addCar(car);
    }
    @Transactional(readOnly = true)
    @Override
    public User carList(String model, int series){
        return carDao.carList(model, series);
    }
}
