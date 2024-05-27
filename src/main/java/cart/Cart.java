package src.main.java.cart;

import src.main.java.warehouse.Product;
import src.main.java.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products;
    private double totalPrice;

    public Cart() {
        this.products = new ArrayList<Product>();
    }

    public void addProduct(Warehouse warehouse, Product product) {

        try {
            if (warehouse.getProduct(product.getCode()) == null) {
                throw new IllegalStateException("Product is not in warehouse");
            } else {
                this.products.add(product);
                warehouse.removeProduct(product);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addProduct(Warehouse warehouse, Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            try {
                if (warehouse.getProduct(product.getCode()) == null) {
                    throw new IllegalStateException("Product is not in warehouse");
                } else {
                    this.products.add(product);
                    warehouse.removeProduct(product);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void removeProduct(Warehouse warehouse, Product product) {
        try {
            if (this.products.contains(product)) {
                throw new IllegalStateException("Product is not in cart");
            } else {
                this.products.remove(product);
                warehouse.addProduct(product);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Product getProduct(String productCode) {
        for (Product product : products) {
            if (product.getCode().equals(productCode)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public int getProductCount(Product product) {
        int count = 0;
        for (Product each : products) {
            if (each.equals(product)) {
                count++;
            }
        }

        return count;
    }

    public String getProductsByNames() {
        StringBuilder list = new StringBuilder("CART: [");
        int base = 7;

        for (Product product : this.products) {
            int count = getProductCount(product);
            String name = product.getName();

            if (list.indexOf(name) == -1) {
                list.append( name ).append("(").append(count).append("),");
            }
        }

        if (list.length() > base) {
            list.deleteCharAt(list.length()-1);
        }
        list.append("]");

        return list.toString();
    }

    public double getTotalPrice() {
        for (Product product : this.products) {

            if (product.getDiscountPrice() != 0) {
                totalPrice += product.getDiscountPrice();
            } else {
                totalPrice += product.getPrice();
            }
        }

        return totalPrice;
    }
}
