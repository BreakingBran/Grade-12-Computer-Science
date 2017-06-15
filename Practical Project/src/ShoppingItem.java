
public class ShoppingItem {
  
  private String name;
  private int quantity;
  private double price;
  
  public ShoppingItem (String name, int quantity, double price){
    this.setName(name);
    this.setQuantity(quantity);
    this.setPrice(price);
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

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
  
  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return ("Product name " + this.name + ", quantity " + this.quantity + ", price " + this.price);
  }

}
