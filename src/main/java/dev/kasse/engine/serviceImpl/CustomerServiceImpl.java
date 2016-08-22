package dev.kasse.engine.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kasse.engine.entities.Customer;
import dev.kasse.engine.repository.query.CustomerRepository;
import dev.kasse.engine.service.CustomerService;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  public List<Customer> getAll() {
    return customerRepository.findAll();
  }

  @Override
  public Customer getById(String id) {
    return customerRepository.findById(id);
  }

  @Override
  public List<Customer> getByFirstName(String firstName) {
    return customerRepository.containsFirstName(firstName);
  }

  @Override
  public List<Customer> getByLastName(String lastName) {
    return customerRepository.containsLastName(lastName);
  }

  @Override
  public List<Customer> getByStreet(String street) {
    return customerRepository.containsStreet(street);
  }

  @Override
  public List<Customer> getByZipcode(String zipcode) {
    return customerRepository.containsZipcode(zipcode);
  }

  @Override
  public List<Customer> getByTelephoneNumber(String telephoneNumber) {
    return customerRepository.containsTelephoneNumber(telephoneNumber);
  }

  @Override
  public void setCustomerRepository(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public void saveCustomer(Customer customer) {
    customerRepository.save(customer);
  }

  @Override
  public void deleteCustomer(Customer customer) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deleteCustomerById(String customerId) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deleteAllCustomer() {
    // TODO Auto-generated method stub
    
  }
}
