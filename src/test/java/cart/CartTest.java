package src.test.java.cart;

import org.junit.*;
import src.main.java.cart.Cart;
import src.main.java.warehouse.Product;
import src.main.java.warehouse.Warehouse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CartTest {

    @Test
    public void addProductFromVoidTest() {

        Warehouse warehouse = new Warehouse();
        Cart cart = new Cart();

        Product Apple = new Product("A1", "Apple", 4.99);

        cart.addProduct(warehouse, Apple);

        assertEquals("CART: []", cart.getProductsByNames());
    }

    @Test
    public void addMultipleProductsFromVoidTest() {

        Warehouse warehouse = new Warehouse();
        Cart cart = new Cart();

        Product Apple = new Product("A1", "Apple", 4.99);

        cart.addProduct(warehouse, Apple, 2);

        assertEquals("CART: []", cart.getProductsByNames());
    }

    @Test
    public void addMultipleProductsFromWarehouseTest() {

        Warehouse warehouse = new Warehouse();
        Cart cart = new Cart();

        Product Apple = new Product("A1", "Apple", 4.99);

        warehouse.addProduct(Apple, 5);
        cart.addProduct(warehouse, Apple, 2);

        assertEquals("CART: [Apple(2)]", cart.getProductsByNames());
    }

    @Test
    public void removeProductFromCartTest() {

        Warehouse warehouse = new Warehouse();
        Cart cart = new Cart();

        Product Apple = new Product("A1", "Apple", 4.99);

        warehouse.addProduct(Apple, 5);
        cart.addProduct(warehouse, Apple, 2);

        assertEquals("CART: [Apple(2)]", cart.getProductsByNames());
        cart.removeProduct(warehouse, Apple);
        cart.removeProduct(warehouse, Apple);
        cart.removeProduct(warehouse, Apple);

        assertEquals("WAREHOUSE: [Brand Mug(100),Apple(5)]", warehouse.getProductsByNames());
        assertEquals("CART: []", cart.getProductsByNames());
    }

}
