public class DocumentProxy implements Document {
    private final String documentId;
    private final User user;
    private RealDocument realDocument;

    public DocumentProxy(String documentId, User user) {
        this.documentId = documentId;
        this.user = user;
    }

    @Override
    public String read() {
        if (!"ADMIN".equals(user.getRole())) {
            throw new RuntimeException("Access Denied");
        }

        if (realDocument == null) {
            realDocument = new RealDocument(documentId);
        }

        return realDocument.read();
    }
}
