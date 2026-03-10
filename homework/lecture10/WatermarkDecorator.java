public class WatermarkDecorator extends DocumentDecorator {
    public WatermarkDecorator(Document wrappedDocument) {
        super(wrappedDocument);
    }

    @Override
    public String read() {
        return wrappedDocument.read() + "\nCONFIDENTIAL";
    }
}
