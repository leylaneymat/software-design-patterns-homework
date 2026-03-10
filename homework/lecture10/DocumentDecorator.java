public abstract class DocumentDecorator implements Document {
    protected final Document wrappedDocument;

    protected DocumentDecorator(Document wrappedDocument) {
        this.wrappedDocument = wrappedDocument;
    }
}
