package week1.designpatterns.factory;

public class DocumentFactoryDemo {
    public static void main(String[] args) {
        System.out.println("=== Exercise 2: Testing Factory Method Pattern with Document Management System ===");

        // 1. Create and manage a Word Document using WordDocumentFactory
        System.out.println("\n--- Processing Word Document ---");
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.manageDocument();

        // 2. Create and manage a PDF Document using PdfDocumentFactory
        System.out.println("--- Processing PDF Document ---");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.manageDocument();

        // 3. Create and manage an Excel Document using ExcelDocumentFactory
        System.out.println("--- Processing Excel Spreadsheet ---");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.manageDocument();
    }
}
