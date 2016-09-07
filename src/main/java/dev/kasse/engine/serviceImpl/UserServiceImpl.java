package dev.kasse.engine.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kasse.engine.entities.User;
import dev.kasse.engine.repository.query.UserRepository;
import dev.kasse.engine.service.UserService;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  public List<User> getAll() {
    return userRepository.findAll();
  }

  @Override
  public User getById(String id) {
    return userRepository.findById(id);
  }

  @Override
  public List<User> getByFirstName(String firstName) {
    return userRepository.containsFirstName(firstName);
  }

  @Override
  public List<User> getByLastName(String lastName) {
    return userRepository.containsLastName(lastName);
  }

  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }

  @Override
  public void deleteUser(User user) {
    userRepository.delete(user);
  }

  @Override
  public void deleteUserById(String userId) {
    userRepository.delete(userId); 
  }

  @Override
  public void deleteAllUsers() {
    userRepository.deleteAll();
  }

  @Override
  public List<User> getByTelephoneNumber(String telephoneNumber) {
    return userRepository.containsTelephoneNumber(telephoneNumber);
  }

  @Override
  public List<User> getByAvailability(boolean isAvailable) {
    return userRepository.findByAvailableForDelivery(isAvailable);
  }

  @Override
  public List<User> getByDriver(boolean isDriver) {
    return userRepository.findByIsDriver(isDriver);
  }

  @Override
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
 }
