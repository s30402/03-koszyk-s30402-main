package src.test.java.cart;

import org.junit.*;
import src.main.java.cart.Cart;
import src.main.java.warehouse.Product;
import src.main.java.warehouse.Warehouse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RealityCheck {

    @Test
    public void ClientBuys2ProductsTest() {

        Warehouse warehouse = new Warehouse();
        Cart cart = new Cart();

        Product Apple = new Product("FRT-01", "Apple", 3.99);
        Product Phone = new Product("PHONE-01", "Samsung Galaxy", 2499.99);

        // Test 1 - Warehouse products added // 100x Brand Mug added by default

        warehouse.addProduct(Apple, 255);
        warehouse.addProduct(Phone, 5);

        assertEquals("WAREHOUSE: [Brand Mug(100),Apple(255),Samsung Galaxy(5)]", warehouse.getProductsByNames());

        // Test 2 - Cart apply discount if totalPrice over 300

        cart.addProduct(warehouse, Apple, 100);
        cart.addProduct(warehouse, Phone, 2);

        Apple.applyDiscount(5);
        Phone.applyDiscount(5);

        assertEquals(399.0, cart.getTotalPrice(), 0.01);

    }
}
