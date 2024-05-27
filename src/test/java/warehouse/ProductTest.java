package src.test.java.warehouse;

import org.junit.*;
import src.main.java.warehouse.Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ProductTest {

    @Test
    public void productTest() {
        Product product = new Product("x01", "Product X", 14.99);

        assertEquals("[x01,Product X,14.99,0.0]", product.toString());
    }

    @Test
    public void setCodeTest() {
        Product product = new Product("x01", "Product X", 14.99);
        product.setCode("x02");

        assertEquals("x02", product.getCode());
    }

    @Test
    public void setNameTest() {
        Product product = new Product("x01", "Product X", 14.99);
        product.setName("Product Y");

        assertEquals("Product Y", product.getName());
    }

    @Test
    public void setPriceTest() {
        Product product = new Product("x01", "Product X", 14.99);
        product.setPrice(15.99);

        assertEquals(15.99, product.getPrice(), 0.001);
    }

    @Test
    public void setDiscountTest() {
        Product product = new Product("x01", "Product X", 14.99);
        product.setDiscount(20.0);

        assertEquals(0.20, product.getDiscountPrice(), 0.001);
    }

    @Test
    public void setDiscountOverloadTest() {
        Product product = new Product("x01", "Product X", 14.99);
        product.setDiscount(-5);

        assertEquals(0.0, product.getDiscountPrice(), 0.001);
    }

    @Test
    public void applyDiscountTest() {
        Product product = new Product("x01", "Product X", 14.99, 50);
        product.applyDiscount(0.15);

        assertEquals(0.35, product.getDiscountPrice(), 0.001);
    }
}
