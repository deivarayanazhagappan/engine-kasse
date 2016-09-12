package dev.kasse.engine.service;

import java.util.List;

import dev.kasse.engine.entities.MenuCategory;
import dev.kasse.engine.repository.query.MenuCategoryRepository;
import dev.kasse.engine.state.TicketType;

public interface MenuCategoryService {

  //POST service
  public void saveMenuCategory(MenuCategory category);

  public void deleteMenuCategory(MenuCategory category);

  public void deleteMenuCategoryById(String categoryId);

  public void deleteAllMenuCategories();
 
  public List<MenuCategory> getAll();

  public MenuCategory getById(String id);

  public List<MenuCategory> getByName(String name);

  public List<MenuCategory> getByCategoryId(int categoryId);

  public List<MenuCategory> getByType(TicketType type);

  public List<MenuCategory> getByVisibility(boolean visible);

  public void setMenuCategoryRepository(MenuCategoryRepository menuCategoryRepository);

}
