package dev.kasse.engine.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.kasse.engine.entities.Ticket;
import dev.kasse.engine.service.TicketService;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@RestController
@RequestMapping("/ticket")
public class TicketRestController {

  @Autowired
  public TicketService ticketService;

  @RequestMapping(path = "/all", method = { RequestMethod.GET })
  public List<Ticket> getAllTicket() {
    return ticketService.getAll();
  }

  @RequestMapping(path = "/id", method = { RequestMethod.GET })
  public Ticket getById(String id) {
    return ticketService.getById(id);
  }

  @RequestMapping(path = "/state", method = { RequestMethod.GET })
  public List<Ticket> getByState(String ticketState) {
    return ticketService.getByTicketState(ticketState);
  }

  @RequestMapping(path = "/", method = { RequestMethod.GET })
  public List<Ticket> getByPaymentType(String paymentType) {
    return ticketService.getByPaymentType(paymentType);
  }
}
