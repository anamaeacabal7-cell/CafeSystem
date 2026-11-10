/**
 * Main class of Campus Cafe Ordering System.
 * @author Anamae K. Acabal
 * @version 1.0
 */
public class CafeApp {

    
    public static void main(String[] args) {

        
        Customer Sittie= new Customer("Sittie Adio", true);
        Customer Maretes = new Customer("Maretes Cabba");

        
        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setItemCode("B-02");
        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80);
        hotChocolate.setSize("M");

        
        Beverage icedLatte = new Beverage( 
        "Iced Latte", 120, "B-01", "S");

        
        Pastry defaultPastry = new Pastry();
        defaultPastry.setName("Cookie");
        defaultPastry.setItemCode("P-02");
        defaultPastry.setBasePrice(35);

        
        Pastry ensaymada = new Pastry(
        "Ensaymada", 45, "P-01", true);

        
        Meal defaultMeal = new Meal();
        defaultMeal.setName("Chiken Adobo");
        defaultMeal.setItemCode("M-01");
        defaultMeal.setBasePrice(110);
        defaultMeal.setUpsized(true);
        defaultMeal.setExtraSides(1);

        
        Meal beefTapa = new Meal(
        "Beef Tapa", 130, "M-02", false, 0);

        
        Order order1 = new Order("1001", Sittie);

        order1.addItem(icedLatte);
        order1.addItem(ensaymada);
        order1.addItem(defaultMeal);

        order1.addItem(defaultPastry);

        
        order1.printReceipt();

        
        Order order2 = new Order("1002", Maretes);

        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);
        order2.printReceipt(20);
    }
}
