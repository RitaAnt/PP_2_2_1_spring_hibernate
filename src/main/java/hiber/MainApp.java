package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException{

   AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

   UserService userService = context.getBean(UserService.class);

      userService.add(new User("Kolya", "Tregulov", "user1@mail.ru"),new Car("KIA",01));
      userService.add(new User("Anton", "Alishev", "user2@mail.ru"),new Car("KIA",02));
      userService.add(new User("Liza", "Tregulova", "user3@mail.ru"),new Car("KIA",03));
      userService.add(new User("Sasha", "Alisheva", "user4@mail.ru"),new Car("KIA",04));

   List<User> users = userService.listUsers();
      for (User user : users) {
      System.out.println("Id = "+user.getId());
      System.out.println("First Name = "+user.getFirstName());
      System.out.println("Last Name = "+user.getLastName());
      System.out.println("Email = "+user.getEmail());
      System.out.println();
   }

   List <Car> cars = userService.listCars();
      for (Car car : cars) {
      System.out.println("Id = " + car.getId());
      System.out.println("First Name = " + car.getModel());
      System.out.println("Last Name = " + car.getSeries());
      System.out.println();
   }
      System.out.println();
      System.out.println(userService.carList("KIA", 03));
      context.close();
   }
}
