public class RealDocument implements Document {
    private final String documentId;
    private final String content;

    public RealDocument(String documentId) {
        this.documentId = documentId;
        System.out.println("Loading from DB... Document ID: " + documentId);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("DB load interrupted", e);
        }
        this.content = "Sensitive corporate report for " + documentId;
    }

    @Override
    public String read() {
        return content;
    }
}
