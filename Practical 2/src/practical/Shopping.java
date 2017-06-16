/**
 * Shopping: this class finds out all the things you can buy and tells you the most things you can
 * buy
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Jun 15, 2017
 */
package practical;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Shopping {

  /*
   * Does all the work in getting the max number of things
   */
  public static void main(String args[]) throws FileNotFoundException {

    Scanner sc = new Scanner(System.in);

    // get initial money
    System.out.print("Money from Mom: ");
    float totalMoney = sc.nextFloat();

    // Setup initial variables and data types
    Scanner shoppingListFile = new Scanner(new FileReader("shopData.txt"));
    int numberOfItems = shoppingListFile.nextInt();
    ShoppingItem[] shoppingList = new ShoppingItem[numberOfItems];
    LinkedList<ShoppingItem> boughtItems = new LinkedList<ShoppingItem>();
    int maxPossiblePurchases = 0;
    int totalItems = numberOfItems;

    // read in all the data from the file
    for (int i = 0; i < numberOfItems; i++) {
      String name = shoppingListFile.next();
      int quanitity = shoppingListFile.nextInt();
      float price = shoppingListFile.nextFloat();
      shoppingList[i] = new ShoppingItem(name, quanitity, price);
      // System.out.println(shoppingList[i]); All the items are being read in properly
    }

    // Reading from the file is done so it's better to close it now
    shoppingListFile.close();

    // Time to decide what is the most amount of things to buy and find most amounts of things to
    // buy
    while (totalMoney > 0 && totalItems > 0) {
      ShoppingItem cheapestItem = findCheapestItem(shoppingList);
      
      int newPossiblePurchases = (int) Math.floor(totalMoney / cheapestItem.getPrice());
      newPossiblePurchases = Math.min(newPossiblePurchases, cheapestItem.getQuantity());
      //System.out.println(newPossiblePurchases);
      if (newPossiblePurchases > 0) {
        maxPossiblePurchases += newPossiblePurchases;
        totalMoney -= newPossiblePurchases * cheapestItem.getPrice();
        cheapestItem.setQuantity(0);
        //System.out.println( cheapestItem.getName() + " " + cheapestItem.getQuantity());
        ShoppingItem boughtItem = new ShoppingItem(cheapestItem.getName(),newPossiblePurchases,cheapestItem.getPrice());
        boughtItems.add(boughtItem);
        totalItems -= 1;
        //System.out.println("total money: " + totalMoney);
      }
      else{
        //Nothing else can be bought at this point so it's just better to set it to
        //0 and break the loop
        totalMoney = 0;
      }
      
    }
    
    
    
    //Once the bought list is created you need to print out the elements
    System.out.println("Little Critter bought " + maxPossiblePurchases + " items");
    for (ShoppingItem shoppingItem : boughtItems) {
      System.out.println(shoppingItem.getQuantity() + " - " + shoppingItem.getName());
    }

  }

  public static ShoppingItem findCheapestItem(ShoppingItem[] shoppingList) {

    // initializes the two variables
    ShoppingItem cheapestItem = null;
    float cheapestPrice = 0;

    // loops through to find cheapest item with stock quantity over 1
    for (int i = 0; i < shoppingList.length; i++) {

      if (cheapestItem == null && shoppingList[i].getQuantity() > 0) {
        // Intiailzes the two cheap variables by finding the first non 0 stock quantity
        cheapestItem = shoppingList[i];
        cheapestPrice = shoppingList[i].getPrice();
      } else if (shoppingList[i].getPrice() < cheapestPrice && shoppingList[i].getQuantity() > 0) {
        // Once the variables are intializes it finds the cheapest item in the list
        cheapestItem = shoppingList[i];
        cheapestPrice = shoppingList[i].getPrice();
      }
    }
    return cheapestItem;
  }
}
