package src.test.java.warehouse;

import org.junit.*;
import src.main.java.warehouse.Product;
import src.main.java.warehouse.Warehouse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class WarehouseTest {

    @Test
    public void getProductTest() {

        Warehouse warehouse = new Warehouse();
        Product Pineapple = new Product("P1","Pineapple",14.99);
        Product Orange = new Product("O1","Orange",9.49);

        warehouse.addProduct(Pineapple);    warehouse.addProduct(Pineapple);    warehouse.addProduct(Pineapple);

        assertEquals("Pineapple", Pineapple, warehouse.getProduct("P1"));
    }

    @Test
    public void getProductsByNamesTest() {

        Warehouse warehouse = new Warehouse();
        Product Pineapple = new Product("P1","Pineapple",14.99);
        Product Orange = new Product("O1","Orange",9.49);

        warehouse.addProduct(Pineapple);    warehouse.addProduct(Pineapple);    warehouse.addProduct(Pineapple);
        warehouse.addProduct(Pineapple);    warehouse.addProduct(Pineapple);    warehouse.addProduct(Pineapple);
        warehouse.addProduct(Orange);

        assertEquals("Pineapple", "WAREHOUSE: [Brand Mug(100),Pineapple(6),Orange(1)]", warehouse.getProductsByNames());

    }

    @Test
    public void addMultipleProductsTest() {

        Warehouse warehouse = new Warehouse();
        Product Apple = new Product("A1","Apple",3.99);
        Product Steel_Sword = new Product("S1","Steel Sword",9.49);

        warehouse.addProduct(Apple,59);
        warehouse.addProduct(Steel_Sword,18);

        assertEquals("Pineapple", "WAREHOUSE: [Brand Mug(100),Apple(59),Steel Sword(18)]", warehouse.getProductsByNames());
    }
}
