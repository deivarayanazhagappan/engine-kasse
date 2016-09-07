package dev.kasse.engine.repository.query.custom;

import java.util.List;

import dev.kasse.engine.entities.User;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 * Custom interface for customer repository
 */
public interface UserRepositoryCustom {

  public List<User> containsFirstName(String firstName);

  public List<User> containsLastName(String lastName);

  public List<User> containsTelephoneNumber(String telephoneNumber);
}
