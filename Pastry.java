/**
 * Represents a baked item.
 * @author Anamae K. Acabal
 * @author John Ivan Cacho
 * @version 1.0
 */
public class Pastry extends MenuItem {

    private boolean warmed;

    
    public Pastry() {
        super();
        warmed = false;
    }

    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    @Override
    public double computePrice() {
        // Checks if the pastry is warmed, then adds 10 to the base price 
        if (warmed) {
            return basePrice + 10;
        }
        
        return basePrice;
    }

    
    @Override
    public String getDescription() {
        // Checks if the pastry is warmed, then adds "(Warmed)" to the description 
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }
        return super.getDescription();
    }

    public boolean isWarmed() {
        return warmed;
    }

    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}
