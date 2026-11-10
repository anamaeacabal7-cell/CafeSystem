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
        if (size.equals("S")) {
            return basePrice;
        } else if (size.equals("M")) {
            return basePrice + 15;
        } else {
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
        if (size != null &&
            (size.equals("S") || size.equals("M") ||
             size.equals("L"))) {
            this.size = size;
        } else {
            System.out.println("Error: size must be S, M, or L.");
        }
    }
}
