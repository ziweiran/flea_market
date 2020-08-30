package upenn.fleamarket.demo.data;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
  public Item findByName(String name);

  public Optional<Item> findById(String id);
}