package week1.designpatterns.factory;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("[EXCEL] Opening Spreadsheet (.xlsx) worksheet grid...");
    }

    @Override
    public void save() {
        System.out.println("[EXCEL] Recalculating formulas and saving workbook.");
    }

    @Override
    public void close() {
        System.out.println("[EXCEL] Closing Spreadsheet workbook.\n");
    }
}
