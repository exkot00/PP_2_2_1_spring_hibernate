package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru",
//              new Car("Model1", 1 )));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru",
//              new Car("Model2", 2)));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru",
//              new Car("Model3", 3)));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru",
//              new Car("Model4", 4)));
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");

      Car car1 =  new Car("Model1", 1 );
      Car car2 =  new Car("Model2", 2 );
      Car car3 =  new Car("Model3", 3 );
      Car car4 =  new Car("Model4", 4 );

      userService.add(user1.setCar(car1).setUserId(user1));
      userService.add(user2.setCar(car2).setUserId(user2));
      userService.add(user3.setCar(car3).setUserId(user3));
      userService.add(user4.setCar(car4).setUserId(user4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar());
         System.out.println();
      }

      System.out.println( "✔" + userService.getUserByCar("model3", 3) );

      context.close();
   }
}
