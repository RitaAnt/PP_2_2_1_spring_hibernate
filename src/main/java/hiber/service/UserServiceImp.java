package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user, Car car) {
      userDao.add(user);
      userDao.addCar(car);
   }

   @Transactional
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public List<Car> listCars() {
      return userDao.listCars();
   }
   @Transactional
   @Override
   public User carList(String model, int series) {
      return userDao.carList(model, series);
   }


}