package src.main.java.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private List<Product> products;

    public Warehouse() {
        this.products = new ArrayList<Product>();

        Product BrandMug = new Product("THEMUG", "Brand Mug", 14.99);
        this.addProduct(BrandMug, 100);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.products.add(product);
        }
    }

    public void removeProduct(Product product) {
        try {
            if (this.products.contains(product)) {
                throw new IllegalStateException("Product is not in the warehouse");
            } else {
                this.products.remove(product);
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
        StringBuilder list = new StringBuilder("WAREHOUSE: [");

        for (Product product : this.products) {
            int count = getProductCount(product);
            String name = product.getName();

            if (list.indexOf(name) == -1) {
                list.append( name ).append("(").append(count).append("),");
            }
        }

        list.deleteCharAt(list.length()-1);
        list.append("]");

        return list.toString();
    }

}
