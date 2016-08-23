package dev.kasse.engine.service;

import java.util.List;

import dev.kasse.engine.entities.Customer;
import dev.kasse.engine.repository.query.CustomerRepository;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
public interface CustomerService {

  // POST service
  public void saveCustomer(Customer customer);

  public void deleteCustomer(Customer customer);

  public void deleteCustomerById(String customerId);

  public void deleteAllCustomer();
  
  // GET service
  public List<Customer> getAll();

  public Customer getById(String id);

  public List<Customer> getByFirstName(String firstName);

  public List<Customer> getByLastName(String lastName);

  public List<Customer> getByStreet(String street);

  public List<Customer> getByZipcode(String zipcode);

  public List<Customer> getByTelephoneNumber(String telephoneNumber);

  public void setCustomerRepository(CustomerRepository customerRepository);

}
