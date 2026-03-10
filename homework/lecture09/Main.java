public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart("Wireless Mouse", 2, 59.98);
        User user = new User("Aysel", "aysel@example.com", "123 Baku Street");

        CheckoutFacade checkoutFacade = new CheckoutFacade();
        checkoutFacade.placeOrder(cart, user);
    }
}
