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
      repo.save(new Item("A History of Magic", "Slytherin", "Dark Forest", "123.gmail.com", "100", "new"));

      System.out.println("found with findAll():");
      System.out.println();
      for (Item item : repo.findAll()) {
        System.out.println(item);
      }
    };
  }
}