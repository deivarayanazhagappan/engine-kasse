package dev.kasse.engine.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kasse.engine.entities.Ticket;
import dev.kasse.engine.repository.query.TicketRepository;
import dev.kasse.engine.service.TicketService;
import dev.kasse.engine.state.PaymentType;
import dev.kasse.engine.state.TicketState;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@Service
public class TicketServiceImpl implements TicketService {

  @Autowired
  TicketRepository ticketRepository;

  public List<Ticket> getAll() {
    return ticketRepository.findAll();
  }

  public Ticket getById(String id) {
    return ticketRepository.findById(id);
  }

  @Override
  public List<Ticket> getByTicketState(String ticketState) {

    TicketState state;
    if (ticketState.equals(TicketState.CLOSED)) {
      state = TicketState.CLOSED;
    } else if (ticketState.equals(TicketState.OPEN)) {
      state = TicketState.OPEN;
    } else if (ticketState.equals(TicketState.PAID)) {
      state = TicketState.PAID;
    } else if (ticketState.equals(TicketState.REOPENED)) {
      state = TicketState.REOPENED;
    } else {
      return new ArrayList<Ticket>();
    }

    return ticketRepository.findByTicketState(state);
  }

  @Override
  public List<Ticket> getByPaymentType(String paymentType) {
    PaymentType type;
    if (paymentType.equals(PaymentType.CARD)) {
      type = PaymentType.CARD;
    } else if (paymentType.equals(PaymentType.CASH)) {
      type = PaymentType.CASH;
    } else if (paymentType.equals(PaymentType.ONLINE)) {
      type = PaymentType.ONLINE;
    } else {
      return new ArrayList<Ticket>();
    }

    return ticketRepository.findByPaymentType(type);
  }

  @Override
  public List<Ticket> getByTableNumber(int tableNumber) {
    return ticketRepository.findByTableNumber(tableNumber);
  }

  @Override
  public void setTicketRepository(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }
}
