package dev.kasse.engine.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kasse.engine.entities.ShopTable;
import dev.kasse.engine.repository.query.ShopTableRepository;
import dev.kasse.engine.service.ShopTableService;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@Service
public class ShopTableServiceImpl implements ShopTableService {

  @Autowired
  ShopTableRepository shopTableRepository;

  @Override
  public void saveTable(ShopTable table) {
    shopTableRepository.save(table);
  }

  @Override
  public void deleteTable(ShopTable table) {
    shopTableRepository.delete(table);
  }

  @Override
  public void deleteTableById(String tableId) {
    shopTableRepository.delete(tableId);
  }

  @Override
  public void deleteAllTables() {
    shopTableRepository.deleteAll();
  }

  @Override
  public List<ShopTable> getAll() {
    return shopTableRepository.findAll();
  }

  @Override
  public ShopTable getById(String id) {
    return shopTableRepository.findOne(id);
  }

  @Override
  public List<ShopTable> getByTableNumber(int tableNumber) {
    return shopTableRepository.findByNumber(tableNumber); 
  }

  @Override
  public List<ShopTable> getByFloor(int floor) {
    return shopTableRepository.findByFloor(floor);
  }

  @Override
  public List<ShopTable> getByNumberAndFloor(int number, int floor) {
    return shopTableRepository.findByNumberAndFloor(number,floor); 
  }

  @Override
  public void setShopTableRepository(ShopTableRepository shopTableRepository) {
    this.shopTableRepository = shopTableRepository;
  }
 }
