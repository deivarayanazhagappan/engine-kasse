package dev.kasse.engine.test.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dev.kasse.engine.entities.ShopTable;
import dev.kasse.engine.entities.Ticket;
import dev.kasse.engine.repository.query.ShopTableRepository;
import dev.kasse.engine.repository.query.TicketRepository;
import dev.kasse.engine.state.PaymentType;
import dev.kasse.engine.state.TicketState;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mongo-repository-context.xml")
@EnableMongoRepositories("com.kasse.engine.Repository")
public class ShopTableEntityTest {

  @Autowired
  private TicketRepository ticketRepository;

  @Autowired
  private ShopTableRepository shopTableRepository;

  @Before
  public void init() {
    shopTableRepository.deleteAll();
    ticketRepository.deleteAll();
  }

  @Test
  public void insertShopTable() {
    shopTableRepository.save(createNewTableIfNotExist(1));

    List<ShopTable> shopTables = shopTableRepository.findAll();
    assertEquals(1, shopTables.size());

    ShopTable table = shopTables.get(0);
    assertEquals(1, table.getFloor());
    assertEquals(1, table.getNumber());
    assertEquals(true, table.isOccupied());
  }

  @Test
  public void updateShopTable() {
    shopTableRepository.save(createNewTableIfNotExist(1));

    List<ShopTable> shopTables = shopTableRepository.findAll();
    assertEquals(1, shopTables.size());

    ShopTable table = shopTables.get(0);
    assertEquals(true, table.isOccupied());

    // update the table
    table.setOccupied(false);
    shopTableRepository.save(table);

    table = shopTableRepository.findAll().get(0);
    assertEquals(false, table.isOccupied());

  }

  @Test
  public void deleteShopTable() {
    shopTableRepository.save(createNewTableIfNotExist(1));

    List<ShopTable> shopTables = shopTableRepository.findAll();
    assertEquals(1, shopTables.size());

    ShopTable table = shopTables.get(0);
    assertEquals(true, table.isOccupied());

    // delete the table
    shopTableRepository.delete(table);

    assertEquals(0, shopTableRepository.findAll().size());

  }

  // test cascade
  @Test
  public void cascadeInsertShopTable() {
    ticketRepository.save(createNewTicket());
    List<Ticket> tickets = ticketRepository.findAll();
    assertEquals(1, tickets.size());

    Ticket ticket = tickets.get(0);
    ShopTable table = ticket.getTable();
    assertNotNull(table);
    String tableId = table.getId();

    List<ShopTable> shopTables = shopTableRepository.findAll();
    assertEquals(1, shopTables.size());
    ShopTable tableInRepository = shopTables.get(0);
    assertNotNull(tableInRepository);
    assertEquals(tableId, tableInRepository.getId());
  }

  @Test
  public void cascadeUpdateShopTable() {
    ticketRepository.save(createNewTicket());
    assertEquals(1, ticketRepository.findAll().size());

    Ticket ticket = ticketRepository.findAll().get(0);
    ShopTable table = ticket.getTable();
    assertNotNull(table);
    assertEquals(true, table.isOccupied());

    // update table
    table.setOccupied(false);

    // save ticket
    ticketRepository.save(ticket);

    ticket = ticketRepository.findAll().get(0);
    table = ticket.getTable();
    assertNotNull(table);
    assertEquals(false, table.isOccupied());

  }

  @Test
  public void shouldNotCascadeDeleteShopTable() {
    ticketRepository.save(createNewTicket());
    assertEquals(1, ticketRepository.findAll().size());

    Ticket ticket = ticketRepository.findAll().get(0);
    ShopTable table = ticket.getTable();
    assertNotNull(table);
    assertEquals(true, table.isOccupied());

    // delete ticket
    ticketRepository.delete(ticket);

    assertEquals(0, ticketRepository.findAll().size());

    // Shop table still exist as it is independent of ticket
    assertEquals(1, shopTableRepository.findAll().size());
  }

  @Test
  public void linkExistingShopTableToTicket() {
    shopTableRepository.save(createNewTableIfNotExist(1));

    assertEquals(1, shopTableRepository.findAll().size());

    ticketRepository.save(createNewTicket());
    assertEquals(1, ticketRepository.findAll().size());

    // there should not be a new insertion
    assertEquals(1, shopTableRepository.findAll().size());
  }

  protected Ticket createNewTicket() {
    Ticket ticket = new Ticket();
    ticket.setCreateDate(new Date());
    ticket.setPaymentType(PaymentType.CASH);
    ticket.setTicketState(TicketState.OPEN);
    ticket.setSubTotal(15.25);
    ticket.setTotalTax(0.50);
    ticket.setTotal(15.50);
    ticket.setTable(createNewTableIfNotExist(1));
    return ticket;
  }

  protected ShopTable createNewTableIfNotExist(int tableNumber) {

    ShopTable shopTable = shopTableRepository.findByNumber(tableNumber);
    if (shopTable == null) {
      shopTable = new ShopTable();
      shopTable.setNumber(tableNumber);
      shopTable.setOccupied(true);
      shopTable.setFloor(1);
      return shopTable;
    }
    return shopTable;
  }
}
