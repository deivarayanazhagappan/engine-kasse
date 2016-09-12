package dev.kasse.engine.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kasse.engine.entities.MenuCategory;
import dev.kasse.engine.repository.query.MenuCategoryRepository;
import dev.kasse.engine.service.MenuCategoryService;
import dev.kasse.engine.state.TicketType;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@Service
public class MenuCategoryServiceImpl implements MenuCategoryService {

  @Autowired
  MenuCategoryRepository menuCategoryRepository;

  public List<MenuCategory> getAll() {
    return menuCategoryRepository.findAll();
  }

  public MenuCategory getById(String id) {
    return menuCategoryRepository.findById(id);
  }

  @Override
  public List<MenuCategory> getByName(String name) {
    return menuCategoryRepository.findByName(name);
  }

  @Override
  public List<MenuCategory> getByCategoryId(int categoryId) {
    return menuCategoryRepository.findByCategoryId(categoryId);
  }

  @Override
  public List<MenuCategory> getByType(TicketType type) {
    return menuCategoryRepository.findByType(type);
  }

  @Override
  public List<MenuCategory> getByVisibility(boolean visible) {
    return menuCategoryRepository.findByVisible(visible);
  }

  @Override
  public void setMenuCategoryRepository(
      MenuCategoryRepository menuCategoryRepository) {
    this.menuCategoryRepository = menuCategoryRepository;  
  }

  @Override
  public void saveMenuCategory(MenuCategory category) {
    menuCategoryRepository.save(category);
  }

  @Override
  public void deleteMenuCategory(MenuCategory category) {
    menuCategoryRepository.delete(category);
  }

  @Override
  public void deleteMenuCategoryById(String categoryId) {
    menuCategoryRepository.delete(categoryId);
  }

  @Override
  public void deleteAllMenuCategories() {
    menuCategoryRepository.deleteAll();  
  }
 }
