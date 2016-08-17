package dev.kasse.engine.service;

import java.util.List;

import dev.kasse.engine.entities.Ticket;
import dev.kasse.engine.repository.query.TicketRepository;

public interface TicketService {

  public List<Ticket> getAll();

  public Ticket getById(String id);

  public List<Ticket> getByTicketState(String ticketState);

  public List<Ticket> getByPaymentType(String paymentType);

  public List<Ticket> getByTableNumber(int tableNumber);

  public void setTicketRepository(TicketRepository ticketRepository);

}
