/**
 * Shopping
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: May 1, 2017
 */

import java.util.*;
import java.io.*;

public class Shopping2 {

  public static void main(String args[]) throws FileNotFoundException {

    // gets input from user
    Scanner sc = new Scanner(System.in);
    // gets input from file
    Scanner fileScanner = new Scanner(new FileReader("shopData.txt"));

    // Initial variables
    int numItemsBought = 0;
    List<ShoppingItem> listOfItemsBought = new ArrayList<ShoppingItem>();

    // gets number of items in shopping mall
    int numShoppingItems = fileScanner.nextInt();

    // Makes array of all items that can be purchased
    ShoppingItem shoppingList[] = new ShoppingItem[numShoppingItems];

    System.out.print("Money from Mom: ");
    double totalMoneyLeft = sc.nextDouble();
    double cheapestPrice = -1;

    for (int i = 0; i < numShoppingItems; i++) {
      String name = fileScanner.next();
      int quantity = fileScanner.nextInt();
      double price = fileScanner.nextDouble();

      if (cheapestPrice == -1 || cheapestPrice > price) {
        cheapestPrice = price;
      }

      shoppingList[i] = new ShoppingItem(name, quantity, price);
      // System.out.println(shoppingList[i]);
    }

    boolean outOfMoney = false;

    double consecutiveCheapestPrice = cheapestPrice;
    // when it comes time to set a new cheapest price, we need to make sure it's hugher than this
    double consecutiveCheapestPriceTracking = consecutiveCheapestPrice;

    // checks to see if you are out of money or if the market is out of products
    while (totalMoneyLeft > cheapestPrice || listOfItemsBought.size() == numShoppingItems) {
      // find cheapest item in the list
      int indexOfCheapestItem = -1;

      for (int i = 0; i < numShoppingItems; i++) {
        if (shoppingList[i].getPrice() == consecutiveCheapestPrice
            && shoppingList[i].getQuantity() > 0) {
          indexOfCheapestItem = i;
        }
      }

      // Once cheapest item found, see how many items of it you can buy

      // tries to floor the double
      int numOfItemsBuyable = (int) (totalMoneyLeft / shoppingList[indexOfCheapestItem].getPrice());

      // Makes sure that it's floored
      if (numOfItemsBuyable * shoppingList[indexOfCheapestItem].getPrice() > totalMoneyLeft) {
        numOfItemsBuyable -= 1;
      }

      // makes sure you don't buy more than what exists
      if (numOfItemsBuyable > shoppingList[indexOfCheapestItem].getQuantity()) {
        numOfItemsBuyable = shoppingList[indexOfCheapestItem].getQuantity();
      }
      
      if (numOfItemsBuyable <= 0){
        break;
      }

      // usually sets quantity to 0, but if you don't have enough money, decrements quantity by
      // amount of products bought
      shoppingList[indexOfCheapestItem].setQuantity(shoppingList[indexOfCheapestItem].getQuantity()
          - numOfItemsBuyable);
      numItemsBought += numOfItemsBuyable;

      // reduces amount of money left
      totalMoneyLeft -= (numOfItemsBuyable * shoppingList[indexOfCheapestItem].getPrice());
      ShoppingItem boughtItems =
          new ShoppingItem(shoppingList[indexOfCheapestItem].getName(), numOfItemsBuyable,
              shoppingList[indexOfCheapestItem].getPrice());
      listOfItemsBought.add(boughtItems);

      consecutiveCheapestPrice = -1;
      
      // sets new cheapest price
      for (int i = 0; i < numShoppingItems; i++) {
        
        if (consecutiveCheapestPrice == -1){
          consecutiveCheapestPrice = shoppingList[i].getPrice() +1;
        }
      
        if (shoppingList[i].getPrice() > consecutiveCheapestPriceTracking
            && shoppingList[i].getPrice() < consecutiveCheapestPrice) {
          {
            consecutiveCheapestPrice = shoppingList[i].getPrice();
          }
        }
      }
      
        consecutiveCheapestPriceTracking = consecutiveCheapestPrice;
      
    }

    System.out.println("Little Critter bought " + numItemsBought + " items.");

    for (int i = 0; i < listOfItemsBought.size(); i++) {
      System.out.println(listOfItemsBought.get(i).getQuantity() + " - "
          + listOfItemsBought.get(i).getName());
    }
  }
}
