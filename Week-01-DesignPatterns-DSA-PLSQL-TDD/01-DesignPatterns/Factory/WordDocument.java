package week1.designpatterns.factory;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("[WORD] Opening Microsoft Word (.docx) document...");
    }

    @Override
    public void save() {
        System.out.println("[WORD] Saving Word document formatting and text.");
    }

    @Override
    public void close() {
        System.out.println("[WORD] Closing Word document editor.\n");
    }
}
