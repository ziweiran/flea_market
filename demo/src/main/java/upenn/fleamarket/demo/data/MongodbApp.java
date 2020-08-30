package upenn.fleamarket.demo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// @EnableMongoRepositories(basePackageClasses = ItemRepository.class)
@Configuration
public class MongodbApp {

  @Bean
  public CommandLineRunner initDatabase(ItemRepository repo) {
    return args -> {
      // Item i = new Item("Winter Beanie", "Durmstrang Institute", "Library of
      // Durmstrang Institute", "123@gmail.com",
      // "2", "like new");
      // i.setDescription("A beanie keeps you warm in northern lands. Moving to south,
      // selling at 2 galleons. ");
      // i.setImage("assets/images/product_02.jpg");
      // repo.save(i);
      // i = new Item("Gift from Hogsmeade Village", "Ravenclaw", "Library",
      // "123@gmail.com", "0", "new");
      // i.setDescription("A gift from my ex. Bought from Hogsmeade during Chirstmas.
      // It will make your room snow.");
      // i.setImage("assets/images/product_06.jpg");
      // repo.save(i);
      // System.out.println("found with findAll():");
      // System.out.println();
      // for (Item item : repo.findAll()) {
      // System.out.println(item);
      // }
    };
  }
}