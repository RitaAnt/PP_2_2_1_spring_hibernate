package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class CarDaoImp implements CarDao{
    private SessionFactory sessionFactory;

    @Autowired
    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public User carList(String model, int series) {
        User user;
        Query query = sessionFactory.getCurrentSession().createQuery("from User where car.model=:model and car.series=:series");
        query.setParameter("model",model);
        query.setParameter("series",series);
        user = (User) query.getSingleResult();
        return user;
    }
}
