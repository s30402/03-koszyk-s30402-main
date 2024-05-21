package src.main.java.warehouse;

public class Product {

    private String code;
    private String name;
    private double price;
    private double discountPrice;

    public Product(String code, String name, double price, double discountPrice) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
    }

/*
     // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
    // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
*/

        public void setCode(String code) {this.code = code;}
        public String getCode() {return code;}

        public void setName(String name) {this.name = name;}
        public String getName() {return name;}

        public void setPrice(double price) {this.price = price;}
        public double getPrice() {return price;}

        public void setDiscountPrice(double discountPrice) {this.discountPrice = discountPrice;}
        public double getDiscountPrice() {return discountPrice;}

/*
    \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\
     \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\
*/



}
