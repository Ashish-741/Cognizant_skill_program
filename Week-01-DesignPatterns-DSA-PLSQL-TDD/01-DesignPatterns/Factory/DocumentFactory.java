package week1.designpatterns.factory;

// 1. Abstract Factory Class with abstract createDocument() method
public abstract class DocumentFactory {
    public abstract Document createDocument();

    // Standard business logic method using the created document
    public void manageDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}

// 2. Concrete Word Factory
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

// 3. Concrete PDF Factory
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

// 4. Concrete Excel Factory
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
