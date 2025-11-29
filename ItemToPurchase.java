public class ItemToPurchase {
   private String itemName;
   private String itemDescription;
   private int itemPrice;
   private int itemQuantity;

   public ItemToPurchase() {
    this.itemDescription = "none";
      this.itemName = "none";
      this.itemPrice = 0;
      this.itemQuantity = 0;
   }

   public ItemToPurchase(String itemName, String itemDescription, int itemPrice, int itemQuantity) {
      this.itemName = itemName;
      this.itemDescription = itemDescription;
      this.itemPrice = itemPrice;
      this.itemQuantity = itemQuantity;
   }

   public void setName(String itemName) {
      this.itemName = itemName;
   }

   public String getName() {
      return this.itemName;
   }

   public void setPrice(int itemPrice) {
      this.itemPrice = itemPrice;
   }

   public int getPrice() {
      return this.itemPrice;
   }

   public void setQuantity(int itemQuantity) {
      this.itemQuantity = itemQuantity;
   }

   public int getQuantity() {
      return this.itemQuantity;
   }

   public void setDescription(String itemDescription) {
      this.itemDescription = itemDescription;
   }

   public String getDescription() {
      return this.itemDescription;
   }

   public void printItemCost() {   
      System.out.printf("%s %d @ $%d = $%d", this.itemName, this.itemQuantity, this.itemPrice, (this.itemQuantity * this.itemPrice));
   }

   public void printItemDescription() {   
      System.out.printf("%s: %s", this.itemName, this.itemDescription);
   }
}
