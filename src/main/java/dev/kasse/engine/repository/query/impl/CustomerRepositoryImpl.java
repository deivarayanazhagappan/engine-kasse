package dev.kasse.engine.repository.query.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import dev.kasse.engine.entities.Customer;
import dev.kasse.engine.repository.query.custom.CustomerRepositoryCustom;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public List<Customer> containsFirstName(String firstName) {
    Query query = new Query();
    query.addCriteria(Criteria.where("firstName").regex(firstName, "i"));
    return mongoTemplate.find(query, Customer.class);
  }

  @Override
  public List<Customer> containsLastName(String lastName) {
    Query query = new Query();
    query.addCriteria(Criteria.where("lastName").regex(lastName, "i"));
    return mongoTemplate.find(query, Customer.class);
  }

  @Override
  public List<Customer> containsTelephoneNumber(String telephoneNumber) {
    Query query = new Query();
    query.addCriteria(Criteria.where("telephoneNumber").regex(telephoneNumber,
        "i"));
    return mongoTemplate.find(query, Customer.class);
  }

  @Override
  public List<Customer> containsStreet(String street) {
    Query query = new Query();
    query.addCriteria(Criteria.where("street").regex(street, "i"));
    return mongoTemplate.find(query, Customer.class);
  }
}
