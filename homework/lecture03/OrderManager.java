package lecture03;

import java.util.Arrays;
import java.util.List;

public class OrderManager {

    public void processOrder(Order order) {

        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice();
        }

        if (order.getCustomerType().equals("VIP")) {
            total = total * 0.9;
        }

        System.out.println("Order total calculated: " + total);

        if (order.getPaymentType().equals("CREDIT_CARD")) {
            System.out.println("Processing credit card payment...");
            // Logic to connect to Visa API...
        } else if (order.getPaymentType().equals("PAYPAL")) {
            System.out.println("Redirecting to PayPal...");
            // Logic to connect to PayPal API...
        } else if (order.getPaymentType().equals("CASH")) {
            System.out.println("Please pay at the counter.");
        } else {
            throw new IllegalArgumentException("Unknown payment method");
        }

        try {
            System.out.println("Saving order to MySQL database...");
            // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "pass");
            // String sql = "INSERT INTO orders ...";
            // ... raw JDBC code ...
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Sending email receipt to: " + order.getCustomerEmail());
        System.out.println("Subject: Your order #" + order.getId());
        System.out.println("Body: Thank you for shopping with us! Total: " + total);
    }

    public static void main(String[] args) {
        // 1. Create dummy items
        Item mouse = new Item("Logitech Mouse", 50.0);
        Item keyboard = new Item("Mechanical Keyboard", 150.0);

        // 2. Create an Order (VIP customer paying with PayPal)
        Order order = new Order("ORD-2026-001",
                Arrays.asList(mouse, keyboard),
                "VIP",
                "PAYPAL",
                "student@ada.edu.az");

        // 3. Process it using the "Bad" class
        OrderManager manager = new OrderManager();
        manager.processOrder(order);
    }

    public static class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }

    public static class Order {
        private String id;
        private List<Item> items;
        private String customerType;  // e.g., "VIP", "REGULAR"
        private String paymentType;   // e.g., "CREDIT_CARD", "PAYPAL"
        private String customerEmail;

        public Order(String id, List<Item> items, String customerType, String paymentType, String customerEmail) {
            this.id = id;
            this.items = items;
            this.customerType = customerType;
            this.paymentType = paymentType;
            this.customerEmail = customerEmail;
        }

        public String getId() {
            return id;
        }

        public List<Item> getItems() {
            return items;
        }

        public String getCustomerType() {
            return customerType;
        }

        public String getPaymentType() {
            return paymentType;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }
    }
}
