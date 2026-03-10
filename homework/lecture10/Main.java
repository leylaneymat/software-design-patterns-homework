public class Main {
    public static void main(String[] args) {
        User admin = new User("alice", "ADMIN");
        Document securedDocument = new DocumentProxy("DOC-42", admin);

        Document decoratedDocument = new EncryptionDecorator(
            new WatermarkDecorator(securedDocument)
        );

        System.out.println("--- ADMIN VIEW ---");
        System.out.println(decoratedDocument.read());

        User guest = new User("bob", "GUEST");
        Document deniedDocument = new DocumentProxy("DOC-43", guest);

        System.out.println("\n--- GUEST VIEW ---");
        try {
            System.out.println(deniedDocument.read());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
