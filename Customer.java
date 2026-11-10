/**
 * Represents a cafe customer.
 * @author Anamae K. Acabal
 * @author John Ivan Cacho
 * @version 1.0
 */
public class Customer {

    private String name;
    private boolean student;
    private int loyaltyPoints;

    public Customer() {
        this("Guest", false);
    }

    
    public Customer(String name) {
        this(name, false);
    }

    public Customer(String name, boolean student) {
        this.name = "Guest";
        this.student = student;
        this.loyaltyPoints = 0;
        setName(name);
    }

    public void addPoints(int points) {
        // Checks if the points to add are positive
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    public void addPoints(double amountSpent) {
        // Checks if the amount spent is positive
        if (amountSpent > 0) {
            // Adds 1 point for every 50 spent
            loyaltyPoints += (int) (amountSpent / 50.0);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Checks if the given name is not null and not blank
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            // Displays an error message if the name is empty
            System.out.println("Error: customer name cannot be empty.");
        }
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        // Checks if the given loyalty points are zero or positive
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            // Displays an error message if the points are negative
            System.out.println("Error: loyalty points cannot be negative.");
        }
    }
}
