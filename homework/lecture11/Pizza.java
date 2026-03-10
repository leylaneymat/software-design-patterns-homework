public class Pizza {
    public static String addCheese(String pizza) {
        return pizza + " + cheese";
    }

    public static String addPepperoni(String pizza) {
        return pizza + " + pepperoni";
    }

    public static double getPrice() {
        return 8.0;
    }

    public static double addCheesePrice(double price) {
        return price + 2.0;
    }

    public static double addPepperoniPrice(double price) {
        return price + 3.0;
    }

    public static void main(String[] args) {
        String pizza = "pizza";
        double price = getPrice();

        pizza = addCheese(pizza);
        price = addCheesePrice(price);
        pizza = addPepperoni(pizza);
        price = addPepperoniPrice(price);

        System.out.println(pizza + ", Price: azn " + price);
    }
}
