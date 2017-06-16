/**
 * ShoppingItem
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Jun 15, 2017
 */

package practical;
import java.util.*;
import java.io.*;

public class ShoppingItem {
  
  //Price, name, and quantity
  private String name;
  private int quantity;
  private float price;
  
  public ShoppingItem(String name, int quantity, float price) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
        
  }
  
  
  //these are just getters and setters
  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return (this.name + " " + this.quantity + " " + this.price);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }
}
