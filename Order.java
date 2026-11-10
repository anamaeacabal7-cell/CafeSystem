/**
 * Represents a customer order.
 * @author Anamae K. Acabal
 * @author John Ivan Cacho
 * @version 1.0
 */
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;
    private boolean pointsAwarded;

    
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
        this.pointsAwarded = false;
    }

    
    public boolean addItem(MenuItem item) {
       // Checks if the given item is empty (null).
        if (item == null) {
            System.out.println("Cannot add an empty item.");
            return false;
        }
        // Checks if the order already has 3 items 

        if (itemCount >= 3) {
            System.out.println("Order is full. Cannot add "
                    + item.getDescription() + ".");
            return false;
        }
        // Checks which item slot is empty, then stores the item there
        if (item1 == null) {  item1 = item;
        }
         else if (item2 == null) { item2 = item;
        }
         else if (item3 == null) { item3 = item;
        }

        itemCount++;
        return true;
    }

    public double computeSubtotal() {
        double subtotal = 0;
      // Adds the price of the first item if it exists 
        if (item1 != null) {
            subtotal += item1.computePrice();
        }
       // Adds the price of the second itemif it exists 
        if (item2 != null) {
            subtotal += item2.computePrice();
        }
        // Adds the price of the third item if it exists 
        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    
    public double computeTotal() {
        double subtotal = computeSubtotal();
       // Checks if the customer is a student, then applies a 10% discount 
        if (customer.isStudent()) {
            return subtotal - (subtotal * 0.10);
        }

        return subtotal;
    }

    
    public double computeTotal(double voucher) {
        double total = computeTotal() - voucher;
      // Checks if the voucher made the total negative, then returns 0
        if (total < 0) {
            return 0;
        }

        return total;
    }

    public void printReceipt() {
        double subtotal = computeSubtotal();
        double discount = customer.isStudent()
                ? subtotal * 0.10 : 0;
        double total = computeTotal();

        System.out.println("\nOrder #" + orderId + " - "
                + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));

        printItem(item1);
        printItem(item2);
        printItem(item3);

        System.out.printf("Subtotal: %.2f%n", subtotal);
      // Checks if the customer is a student, then prints the discount 
        if (customer.isStudent()) {
            System.out.printf(
                    "Student discount (10%%): -%.2f%n", discount);
        }

        System.out.printf("TOTAL: %.2f%n", total);
      // Checks if points were not yet given, then adds points once only 
        if (!pointsAwarded) {
            customer.addPoints(total);
            pointsAwarded = true;
        }

        System.out.println("Loyalty points: "
                + customer.getLoyaltyPoints());
    }

    
    private void printItem(MenuItem item) {
        // Checks if the item exists before printing it
        if (item != null) {
            System.out.printf("  %-42s %.2f%n",
                    item.getDescription(), item.computePrice());
        }
    }

    
    public void printReceipt(double voucher) {
        double subtotal = computeSubtotal();
        double discount = customer.isStudent()
                ? subtotal * 0.10 : 0;
        double total = computeTotal(voucher);

        System.out.println("\nOrder #" + orderId + " - "
                + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));

        printItem(item1);
        printItem(item2);
        printItem(item3);

        System.out.printf("Subtotal: %.2f%n", subtotal);

        if (customer.isStudent()) {
            System.out.printf(
                    "Student discount (10%%): -%.2f%n", discount);
        }

        System.out.printf("Voucher: -%.2f%n", voucher);
        System.out.printf("TOTAL: %.2f%n", total);

        if (!pointsAwarded) {
            customer.addPoints(total);
            pointsAwarded = true;
        }

        System.out.println("Loyalty points: "
                + customer.getLoyaltyPoints());
    }

    public Customer getCustomer() { return customer;
    }

    public String getOrderId() { return orderId;
    }
    
    public int getItemCount() { return itemCount;
    }
}
