package dev.kasse.engine.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kasse.engine.entities.MenuItem;
import dev.kasse.engine.repository.query.MenuItemRepository;
import dev.kasse.engine.service.MenuItemService;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@Service
public class MenuItemServiceImpl implements MenuItemService {

  @Autowired
  MenuItemRepository menuItemRepository;

  public List<MenuItem> getAll() {
    return menuItemRepository.findAll();
  }

  public MenuItem getById(String id) {
    return menuItemRepository.findById(id);
  }

  @Override
  public List<MenuItem> getByName(String name) {
    return menuItemRepository.findByName(name);
  }

  @Override
  public List<MenuItem> getByItemId(String itemId) {
    return menuItemRepository.findByItemId(itemId);
  }

  @Override
  public List<MenuItem> getByGroupId(String groupId) {
    return menuItemRepository.findByGroupId(groupId);
  }
  
  @Override
  public void setMenuItemRepository(
      MenuItemRepository menuItemRepository) {
    this.menuItemRepository = menuItemRepository;  
  }

  @Override
  public void saveMenuItem(MenuItem item) {
    menuItemRepository.save(item);
  }

  @Override
  public void deleteMenuItem(MenuItem item) {
    menuItemRepository.delete(item);  
  }

  @Override
  public void deleteMenuItemById(String itemId) {
    menuItemRepository.delete(itemId); 
  }

  @Override
  public void deleteAllMenuItems() {
    menuItemRepository.deleteAll(); 
  }
}
