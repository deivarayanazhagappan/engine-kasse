package dev.kasse.engine.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kasse.engine.entities.MenuGroup;
import dev.kasse.engine.repository.query.MenuGroupRepository;
import dev.kasse.engine.service.MenuGroupService;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@Service
public class MenuGroupServiceImpl implements MenuGroupService {

  @Autowired
  MenuGroupRepository menuGroupRepository;

  public List<MenuGroup> getAll() {
    return menuGroupRepository.findAll();
  }

  public MenuGroup getById(String id) {
    return menuGroupRepository.findById(id);
  }

  @Override
  public List<MenuGroup> getByName(String name) {
    return menuGroupRepository.findByName(name);
  }

  @Override
  public List<MenuGroup> getByCategoryId(String categoryId) {
    return menuGroupRepository.findByCategoryId(categoryId);
  }

  @Override
  public List<MenuGroup> getByGroupId(int groupId) {
    return menuGroupRepository.findByGroupId(groupId);
  }
  
  @Override
  public List<MenuGroup> getByGaenge(int gaenge) {
    return menuGroupRepository.findByGaenge(gaenge);
  }

  @Override
  public void setMenuGroupRepository(
      MenuGroupRepository menuGroupRepository) {
    this.menuGroupRepository = menuGroupRepository;  
  }

  @Override
  public void saveMenuGroup(MenuGroup group) {
    menuGroupRepository.save(group);
  }

  @Override
  public void deleteMenuGroup(MenuGroup group) {
    menuGroupRepository.delete(group);  
  }

  @Override
  public void deleteMenuGroupById(String groupId) {
    menuGroupRepository.delete(groupId); 
  }

  @Override
  public void deleteAllMenuGroups() {
    menuGroupRepository.deleteAll(); 
  }
}
