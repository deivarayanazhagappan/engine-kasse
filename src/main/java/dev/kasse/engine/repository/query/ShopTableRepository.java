package dev.kasse.engine.repository.query;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.kasse.engine.entities.ShopTable;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
public interface ShopTableRepository extends MongoRepository<ShopTable, String> {

  public List<ShopTable> findAll();

  public ShopTable findByNumber(int tableNumber);
}
