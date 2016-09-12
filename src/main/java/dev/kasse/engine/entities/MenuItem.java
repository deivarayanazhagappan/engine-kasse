package dev.kasse.engine.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@Document
public class MenuItem {

  @Id
  private String id;

  private String name;
 
  private int itemId;

  private String barcode;

  private String groupId;

  private Double price;

  private boolean variablePrice;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public boolean isVariablePrice() {
    return variablePrice;
  }

  public void setVariablePrice(boolean variablePrice) {
    this.variablePrice = variablePrice;
  }
}
