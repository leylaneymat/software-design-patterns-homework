public class CheckoutFacade {
    private final InventorySystem inventorySystem;
    private final PaymentGateway paymentGateway;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public CheckoutFacade() {
        this.inventorySystem = new InventorySystem();
        this.paymentGateway = new PaymentGateway();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    public void placeOrder(Cart cart, User user) {
        System.out.println("=== Checkout ===");

        boolean reserved = inventorySystem.checkAndReserve(cart);
        if (!reserved) {
            System.out.println("[CheckoutFacade] Failed: out of stock.");
            return;
        }

        boolean paid = paymentGateway.processPayment(user, cart.getTotalAmount());
        if (!paid) {
            System.out.println("[CheckoutFacade] Failed: payment declined.");
            return;
        }

        String trackingId = shippingService.createShipment(user, cart);
        notificationService.sendReceipt(user, cart, trackingId);

        System.out.println("[CheckoutFacade] Order placed.");
        System.out.println("=== Done ===");
    }
}
