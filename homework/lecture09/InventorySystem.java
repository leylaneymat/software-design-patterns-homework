public class InventorySystem {
    public boolean checkAndReserve(Cart cart) {
        System.out.println("[InventorySystem] Checking " + cart.getQuantity() + " x " + cart.getItemName() + "...");
        System.out.println("[InventorySystem] In stock. Reserved.");
        return true;
    }
}
