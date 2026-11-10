/**
 * Represents a drink sold at the campus cafe.
 * @author John Ivan Cacho
 * @version 1.0
 */
public class Beverage extends MenuItem {

    private String size;

    
    public Beverage() {
        super();
        size = "S";
    }

    public Beverage(String name, double basePrice,
                    String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }

    @Override
    public double computePrice() {
        //Checks if the size is small,then returns the base price only.
        if (size.equals("S")) {
            return basePrice;
        } else if (size.equals("M")) {
            // Adds 15 to the base price if the size is medium
            return basePrice + 15;
        } else {
           // Adds 25 to the base price if the size is large 
            return basePrice + 25;
        }
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        // Checks if the given size is not null and is S, M, or L
        if (size != null &&
            (size.equals("S") || size.equals("M") ||
             size.equals("L"))) {
            this.size = size;
        } else {
            // Display an error message if the size is invalid
            System.out.println("Error: size must be S, M, or L.");
        }
    }
}
