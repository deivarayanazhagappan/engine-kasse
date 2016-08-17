package dev.kasse.engine.test.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dev.kasse.engine.entities.Ticket;
import dev.kasse.engine.repository.query.TicketRepository;
import dev.kasse.engine.state.PaymentType;
import dev.kasse.engine.state.TicketState;
import dev.kasse.engine.test.AbstractTest.AbstractTest;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mongo-repository-context.xml")
@EnableMongoRepositories("com.kasse.engine.Repository")
public class TicketEntityTest extends AbstractTest {

  @Autowired
  private TicketRepository ticketRepository;

  @Before
  public void init() {
    ticketRepository.deleteAll();
  }

  @Test
  public void insertTicket() {
    ticketRepository.save(createNewTicket(1));
    assertEquals(1, ticketRepository.findAll().size());

    Ticket ticket = ticketRepository.findAll().get(0);
    assertEquals(PaymentType.CASH, ticket.getPaymentType());
    assertEquals(TicketState.OPEN, ticket.getTicketState());
    assertEquals(new Double(15.25), ticket.getSubTotal());
    assertEquals(new Double(0.50), ticket.getTotalTax());
    assertEquals(new Double(15.50), ticket.getTotal());

    assertNotNull(ticket.getCustomer());
    assertEquals(2, ticket.getTicketItems().size());

  }

  @Test
  public void updateTicket() {
    ticketRepository.save(createNewTicket(1));
    assertEquals(1, ticketRepository.findAll().size());

    Ticket ticket = ticketRepository.findAll().get(0);
    assertEquals(PaymentType.CASH, ticket.getPaymentType());
    assertEquals(TicketState.OPEN, ticket.getTicketState());

    // update the ticket
    ticket.setPaymentType(PaymentType.CARD);
    ticket.setTicketState(TicketState.CLOSED);

    ticketRepository.save(ticket);
    assertEquals(1, ticketRepository.findAll().size());

    ticket = ticketRepository.findAll().get(0);
    assertEquals(PaymentType.CARD, ticket.getPaymentType());
    assertEquals(TicketState.CLOSED, ticket.getTicketState());
  }

  @Test
  public void deleteTicket() {
    ticketRepository.save(createNewTicket(1));
    assertEquals(1, ticketRepository.findAll().size());

    Ticket ticket = ticketRepository.findAll().get(0);
    assertEquals(PaymentType.CASH, ticket.getPaymentType());
    assertEquals(TicketState.OPEN, ticket.getTicketState());

    ticketRepository.delete(ticket);

    assertEquals(0, ticketRepository.findAll().size());
  }
}
