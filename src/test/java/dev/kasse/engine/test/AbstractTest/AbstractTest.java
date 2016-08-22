package dev.kasse.engine.test.AbstractTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dev.kasse.engine.entities.Customer;
import dev.kasse.engine.entities.ShopTable;
import dev.kasse.engine.entities.Ticket;
import dev.kasse.engine.entities.TicketItem;
import dev.kasse.engine.repository.query.ShopTableRepository;
import dev.kasse.engine.state.PaymentType;
import dev.kasse.engine.state.TicketState;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
// Abstract class for all Ticket tests
public abstract class AbstractTest {

  @Autowired
  public ShopTableRepository shopTableRepository;

  protected Ticket createNewTicket(PaymentType paymentType) {
    return createNewTicket(paymentType, TicketState.CLOSED, 1, null, null);
  }

  protected Ticket createNewTicket(TicketState ticketState) {
    return createNewTicket(PaymentType.CASH, ticketState, 1, null, null);
  }

  protected Ticket createNewTicket(int tableNumber) {
    return createNewTicket(PaymentType.CASH, TicketState.OPEN, tableNumber,
        null, "Kasse");
  }

  protected Ticket createNewTicket(PaymentType paymentType,
      TicketState ticketState, int tableNumber, String userName,
      String customerName) {
    Ticket ticket = new Ticket();
    ticket.setCreateDate(new Date());
    ticket.setPaymentType(paymentType);
    ticket.setTicketState(ticketState);
    ticket.setSubTotal(15.25);
    ticket.setTotalTax(0.50);
    ticket.setTotal(15.50);

    ticket.setCustomer(createCustomer(customerName));
    ticket.setTable(createShopTable(tableNumber));
    // add 2 ticketItems
    List<TicketItem> ticketItems = createTicketItems();
    ticket.addTicketItems(ticketItems);
    return ticket;
  }

  protected List<Ticket> createTicketsForStates() {
    List<Ticket> tickets = new ArrayList<Ticket>();
    Ticket openTicket = createNewTicket(TicketState.OPEN);
    Ticket closedTicket_1 = createNewTicket(TicketState.CLOSED);
    Ticket closedTicket_2 = createNewTicket(TicketState.CLOSED);
    Ticket paidTicket = createNewTicket(TicketState.PAID);
    Ticket reopenedTicket = createNewTicket(TicketState.REOPENED);

    tickets.add(openTicket);
    tickets.add(closedTicket_1);
    tickets.add(closedTicket_2);
    tickets.add(paidTicket);
    tickets.add(reopenedTicket);

    return tickets;
  }

  protected List<Ticket> createTicketsForPaymentTypes() {
    List<Ticket> tickets = new ArrayList<Ticket>();
    Ticket cardPaymentTicket = createNewTicket(PaymentType.CARD);
    Ticket cashPaymentTicket1 = createNewTicket(PaymentType.CASH);
    Ticket cashPaymentTicket2 = createNewTicket(PaymentType.CASH);
    Ticket onlinePaymentTicket = createNewTicket(PaymentType.ONLINE);

    tickets.add(cardPaymentTicket);
    tickets.add(cashPaymentTicket1);
    tickets.add(cashPaymentTicket2);
    tickets.add(onlinePaymentTicket);

    return tickets;
  }

  protected Customer createCustomer(String firstName) {
    Customer customer = new Customer();
    customer.setFirstName(firstName);
    customer.setLastName(firstName+"LastName");
    customer.setBellName(firstName+"Bell");
    customer.setArea(firstName+"Area");
    customer.setCompanyName(firstName+"Company");
    customer.setEmail(firstName+"email");
    customer.setDoorNumber(firstName+"doorNr");
    customer.setLandmark(firstName+"Landmark");
    customer.setReferenceNumber(firstName+"ReferenceNr");
    customer.setStreet(firstName+"Street");
    customer.setTelephoneNumber(firstName+"12345");
    customer.setZipcode(firstName+"98568");
    return customer;
  }

  protected List<TicketItem> createTicketItems() {
    List<TicketItem> ticketItems = new ArrayList<TicketItem>();

    ticketItems.add(createTicketItem("Cola"));
    ticketItems.add(createTicketItem("Fanta"));
    return ticketItems;
  }

  protected TicketItem createTicketItem(String itemName) {
    TicketItem ticketItem = new TicketItem();
    ticketItem.setBeverage(true);
    ticketItem.setCategoryName("CATEGORY");
    ticketItem.setGroupName("GROUP");
    ticketItem.setItemCount(2);
    ticketItem.setItemName(itemName);
    ticketItem.setSubTotal(6.00);
    ticketItem.setTotal(6.25);
    ticketItem.setTaxRate(0.25);
    return ticketItem;
  }

  protected ShopTable createShopTable(int tableNumber) {
    ShopTable table = shopTableRepository.findByNumber(tableNumber);
    if (table == null) {
      table = new ShopTable();
      table.setFloor(1);
      table.setOccupied(false);
      table.setNumber(1);
    }
    return table;
  }
}
