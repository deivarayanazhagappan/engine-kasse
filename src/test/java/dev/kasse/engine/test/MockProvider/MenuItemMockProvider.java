package dev.kasse.engine.test.MockProvider;

import java.util.ArrayList;
import java.util.List;

import dev.kasse.engine.entities.MenuItem;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
public class MenuItemMockProvider {

  public static List<MenuItem> createMenuItems() {
    List<MenuItem> items = new ArrayList<MenuItem>();
    items.add(createMenuItem("Pizza"));
    items.add(createMenuItem("Pasta"));
    return items;
  }

  public static MenuItem createMenuItem(String name) {
    MenuItem item = new MenuItem();

    item.setBarcode("12345");
    item.setGroupId("groupId");
    item.setId("11a");
    item.setItemId(111);
    item.setName(name);
    item.setPrice(2.50);
    item.setVariablePrice(true);
    return item;
  }
}