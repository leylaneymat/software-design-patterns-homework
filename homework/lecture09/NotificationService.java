public class NotificationService {
    public void sendReceipt(User user, Cart cart, String trackingId) {
        System.out.println("[NotificationService] Sending receipt to " + user.getEmail() + "...");
        System.out.println("[NotificationService] Receipt sent: " + cart.getQuantity() + " x " + cart.getItemName() +
                ", tracking: " + trackingId);
    }
}
