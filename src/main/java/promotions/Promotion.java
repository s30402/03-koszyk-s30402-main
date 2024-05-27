package src.main.java.promotions;

import src.main.java.cart.Cart;
import src.main.java.warehouse.Product;

import java.util.ArrayList;
import java.util.List;

public class Promotion {

    private Cart cart;
    private List<Product> products;

    public Promotion(Cart cart) {
        this.products = new ArrayList<Product>();

        setCart(cart);
        setProducts(cart.getProducts());
    }

    public void setCart(Cart cart) { this.cart = cart; }
    public Cart getCart() { return cart; }

    public void setProducts(List<Product> products) { this.products = products; }
    public List<Product> getProducts() { return this.products; }

    public void addProduct(Product product) {
        try {
            if (cart.getProduct(product.getCode()) == null) {
                throw new IllegalStateException("Product is not in the cart");
            } else {
                this.products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            try {
                if (cart.getProduct(product.getCode()) == null) {
                    throw new IllegalStateException("Product is not in the cart");
                } else {
                    this.products.add(product);
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void removeProduct(Product product) {
        try {
            if (this.products.contains(product)) {
                this.products.remove(product);
            } else {
                throw new IllegalStateException("Product is not in the cart");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
/*
     // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
    // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
*/

    public void applyDiscountAllProductsBy(double d) {
        for (Product product : products) {
            product.applyDiscount(d);
        }
    }

    public void applyBuyAndGetFree(int b, int g) {
        if (products.size() > b) {
            for (Product product : products) {
                if (products.indexOf(product) == g) {
                    product.applyDiscount(100);
                }
            }
        }
    }

/*
    \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\
     \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\
*/
}
