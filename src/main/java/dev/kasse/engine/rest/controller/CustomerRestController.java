package dev.kasse.engine.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.kasse.engine.entities.Customer;
import dev.kasse.engine.service.CustomerService;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerRestController {

  @Autowired
  public CustomerService customerService;

  @RequestMapping(method = { RequestMethod.POST })
  public void saveCustomer(@RequestParam(required=true) Customer customer) {
    customerService.saveCustomer(customer);
  }

  @RequestMapping(method = { RequestMethod.DELETE })
  public void deleteCustomer(@RequestParam(required=true) Customer customer) {
    customerService.deleteCustomer(customer);
  }

  @RequestMapping(method = { RequestMethod.DELETE })
  public void deleteCustomer(@RequestParam(required=true) String customerId) {
    customerService.deleteCustomerById(customerId);
  }

  @RequestMapping(path = "/all", method = { RequestMethod.DELETE })
  public void deleteAllCustomers() {
    customerService.deleteAllCustomers();
  }

  @RequestMapping(path = "/all", method = { RequestMethod.GET })
  public List<Customer> getAllCustomer() {
    return customerService.getAll();
  }

  @RequestMapping(path = "/id", method = { RequestMethod.GET })
  public Customer getById(@RequestParam(required=true) String id) {
    return customerService.getById(id);
  }

  @RequestMapping(path = "/firstName", method = { RequestMethod.GET })
  public List<Customer> getFirstName(@RequestParam(required=true) String firstName) {
    return customerService.getByFirstName(firstName);
  }

  @RequestMapping(path = "/lastName", method = { RequestMethod.GET })
  public List<Customer> getByLastName(@RequestParam(required=true) String lastName) {
    return customerService.getByLastName(lastName);
  }

  @RequestMapping(path = "/street", method = { RequestMethod.GET })
  public List<Customer> getByStreet(@RequestParam(required=true) String street) {
    return customerService.getByStreet(street);
  }

  @RequestMapping(path = "/zipcode", method = { RequestMethod.GET })
  public List<Customer> getByZipcode(@RequestParam(required=true) String zipcode) {
    return customerService.getByZipcode(zipcode);
  }

  @RequestMapping(path = "/telephoneNumber", method = { RequestMethod.GET })
  public List<Customer> getByTelephoneNumber(@RequestParam(required=true) String telephoneNumber) {
    return customerService.getByTelephoneNumber(telephoneNumber);
  }
}
