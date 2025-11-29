import java.util.Scanner;

public class ShoppingCartManager {
    
    
    public static void printMenu() {
        System.out.println("MENU");
        System.out.println("a - Add item to cart");
        System.out.println("d - Remove item from cart");
        System.out.println("c - Change item quantity");
        System.out.println("i - Output items' descriptions");
        System.out.println("o - Output shopping cart");
        System.out.println("q - Quit");
    }

    public static boolean executeMenu(char inputChar, ShoppingCart myCart, Scanner scnr) {
        switch (inputChar) {
            case 'a': 
                ItemToPurchase wantedItem = new ItemToPurchase();
                System.out.println("ADD ITEM TO CART");
                System.out.println("Enter the item name:");
                scnr.nextLine();
                wantedItem.setName(scnr.nextLine());
                System.out.println("Enter the item description:");
                wantedItem.setDescription(scnr.nextLine());
                System.out.println("Enter the item price:");
                wantedItem.setPrice(scnr.nextInt());
                System.out.println("Enter the item quantity:");
                wantedItem.setQuantity(scnr.nextInt());
                myCart.addItem(wantedItem);
                return true;

            case 'd': 
                System.out.println("REMOVE ITEM FROM CART");
                System.out.println("Enter name of item to remove:");
                scnr.nextLine();
                myCart.removeItem(scnr.nextLine());
                return true;

            case 'c':
                ItemToPurchase modifiedItem = new ItemToPurchase();
                System.out.println("CHANGE ITEM QUANTITY");
                System.out.println("Enter the item name:");
                scnr.nextLine();
                modifiedItem.setName(scnr.nextLine());
                System.out.println("Enter the new quantity:");
                modifiedItem.setQuantity(scnr.nextInt());
                myCart.modifyItem(modifiedItem);
                return true;

            case 'i': 
                System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                myCart.printDescriptions();
                return true;

            case 'o':
                System.out.println("OUTPUT SHOPPING CART");
                myCart.printTotal();
                return true;

            case 'q':
                //Does nothing special
                return false;

            default: 
                return false;

        }
    }

    public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String name, date;
      char menuInput = ' ';
      boolean found = true;

      System.out.println("Enter customer's name:");
      name = scnr.nextLine();
      System.out.println("Enter today's date:");
      date = scnr.nextLine();
      System.out.println();

      ShoppingCart myCart = new ShoppingCart(name, date);

      System.out.println("Customer name: " + myCart.getCustomerName());
      System.out.println("Today's date: " + myCart.getDate());
      System.out.println();
      printMenu();
      System.out.println();

      while(menuInput != 'q') {
        System.out.println("Choose an option:");
        menuInput = scnr.next().charAt(0);
        boolean printAgain = executeMenu(menuInput, myCart, scnr);
        if (printAgain) {
            System.out.println();
            printMenu();
            System.out.println();
        }
      }
    }
}
