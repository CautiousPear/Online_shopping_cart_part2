import java.util.ArrayList;

public class ShoppingCart {
    private String customerName;
    private String currentDate;
    ArrayList<ItemToPurchase> cartItems = new ArrayList<>();

    public ShoppingCart() {
        this.customerName = "none";
        this.currentDate = "January 1, 2016";
    }

    public ShoppingCart(String customerName, String currentDate) {
        this.customerName = customerName;
        this.currentDate = currentDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDate() {
        return currentDate;
    }

    public void addItem(ItemToPurchase item) {
        cartItems.add(item);
    }

    public void removeItem(String itemName) {
        boolean found = false;
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getName().equals(itemName)) {
                cartItems.remove(i);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Item not found in cart. Nothing removed.");
    }

    public void modifyItem(ItemToPurchase item) {
        boolean found = false;
        for (int i = 0; i < cartItems.size(); i++) {
            ItemToPurchase currentItem = cartItems.get(i);
            if (currentItem.getName().equals(item.getName())) {
                found = true;
                if (!item.getDescription().equals("none")) currentItem.setDescription(item.getDescription());
                if (item.getPrice() != 0) currentItem.setPrice(item.getPrice());
                if (item.getQuantity() != 0) currentItem.setQuantity(item.getQuantity());
                break;
            }
        }
        if (!found) System.out.println("Item not found in cart. Nothing modified.");
    }

    public int getNumItemsInCart() {
        int numItems = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            numItems += cartItems.get(i).getQuantity();
        }
        return numItems;
    }

    public int getCostOfCart() {
        int costItems = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            costItems += (cartItems.get(i).getPrice() * cartItems.get(i).getQuantity());
        }
        return costItems;
    }

    public void printTotal() {
        System.out.printf("%s's Shopping Cart - %s\n", this.customerName, this.currentDate);
        System.out.println("Number of Items: " + getNumItemsInCart());
        if (getNumItemsInCart() == 0) System.out.print("\nSHOPPING CART IS EMPTY");
        System.out.println();
        for (ItemToPurchase item : cartItems) {
            item.printItemCost();
            System.out.println();
        }
        System.out.println();
        System.out.println("Total: $" + getCostOfCart());
    }

    public void printDescriptions() {
        System.out.printf("%s's Shopping Cart - %s\n", this.customerName, this.currentDate);
        System.out.println();
        System.out.println("Item Descriptions");
        for (ItemToPurchase item : cartItems) {
            item.printItemDescription();
            System.out.println();
        }
    }
}
