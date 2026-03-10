public class ShippingService {
    public String createShipment(User user, Cart cart) {
        System.out.println("[ShippingService] Shipping to: " + user.getAddress() + "...");
        String trackingId = "TRK-" + System.currentTimeMillis();
        System.out.println("[ShippingService] " + cart.getItemName() + " shipped. Tracking: " + trackingId);
        return trackingId;
    }
}
