package src.main.java.warehouse;

public class Product {

    private String code;
    private String name;
    private double price;
    private double discount;
    private double discountPrice;

    public Product(String code, String name, double price) {
        setCode(code);
        setName(name);
        setPrice(price);
    }

    public Product(String code, String name, double price, double discount) {
        setCode(code);
        setName(name);
        setPrice(price);
        setDiscount(discount);
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

        public void setDiscount(double discount) {
            try {
                if (discount < 0 || discount > 100) {
                    throw new IllegalStateException("Discount must be between 0 and 100");
                } else {
                    if (discount > 1) {
                        this.discount = discount / 100;
                    } else {
                        this.discount = discount;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                this.discount = 0;
            }
        }
        public double getDiscount() {
            return discount;
        }

        public double getDiscountPrice() {return discountPrice;}

/*
    \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\
     \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\
*/

    public String toString() {
        return "[" + code + "," + name + "," + price + "," + discountPrice + "]";
    }

    public void applyDiscount() {
        this.discountPrice = this.price - (this.price * this.discount);
    }

    public void applyDiscount(double discount) {

        try {
            if (discount < 0 || discount > 100) {
                throw new IllegalStateException("Discount must be between 0 and 100");
            } else {
                if (discount > 1) {
                    this.discountPrice = this.price - (this.price * (discount / 100));
                } else {
                    this.discountPrice = (this.price * discount);
                }

                setDiscount(discount);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
