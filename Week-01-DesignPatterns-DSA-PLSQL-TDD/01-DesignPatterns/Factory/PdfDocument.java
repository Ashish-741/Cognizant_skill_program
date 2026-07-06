package week1.designpatterns.factory;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("[PDF] Opening Adobe PDF (.pdf) document in read-only mode...");
    }

    @Override
    public void save() {
        System.out.println("[PDF] Saving PDF annotations and encryption tags.");
    }

    @Override
    public void close() {
        System.out.println("[PDF] Closing PDF viewer.\n");
    }
}
