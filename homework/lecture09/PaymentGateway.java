public class PaymentGateway {
    public boolean processPayment(User user, double amount) {
        System.out.println("[PaymentGateway] Charging $" + String.format("%.2f", amount) + " for " + user.getName() + "...");
        System.out.println("[PaymentGateway] Payment approved.");
        return true;
    }
}
