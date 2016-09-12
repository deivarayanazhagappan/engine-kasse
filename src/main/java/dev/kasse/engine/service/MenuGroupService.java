package dev.kasse.engine.service;

import java.util.List;

import dev.kasse.engine.entities.MenuGroup;
import dev.kasse.engine.repository.query.MenuGroupRepository;

public interface MenuGroupService {

  //POST service
  public void saveMenuGroup(MenuGroup group);

  public void deleteMenuGroup(MenuGroup group);

  public void deleteMenuGroupById(String groupId);

  public void deleteAllMenuGroups();
 
  // GET service
  public List<MenuGroup> getAll();

  public MenuGroup getById(String id);

  public List<MenuGroup> getByName(String name);

  public List<MenuGroup> getByCategoryId(String categoryId);

  public List<MenuGroup> getByGroupId(int groupId);

  public List<MenuGroup> getByGaenge(int gaenge);

  public void setMenuGroupRepository(MenuGroupRepository menuGroupRepository);
}
