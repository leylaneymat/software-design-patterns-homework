public class EncryptionDecorator extends DocumentDecorator {
    public EncryptionDecorator(Document wrappedDocument) {
        super(wrappedDocument);
    }

    @Override
    public String read() {
        return new StringBuilder(wrappedDocument.read()).reverse().toString();
    }
}
