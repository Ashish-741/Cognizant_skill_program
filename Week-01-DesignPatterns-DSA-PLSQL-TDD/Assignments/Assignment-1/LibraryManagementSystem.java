package assignments.assignment1;

import java.util.ArrayList;
import java.util.List;

// Assignment 1: Object-Oriented Programming (Encapsulation, Inheritance, Exception Handling)
class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { isIssued = issued; }

    @Override
    public String toString() {
        return "[" + isbn + "] " + title + " by " + author + " | Status: " + (isIssued ? "Issued" : "Available");
    }
}

class Member {
    private String memberId;
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
}

public class LibraryManagementSystem {
    private List<Book> bookCatalog = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        bookCatalog.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public void issueBook(String isbn, String memberId) throws Exception {
        Book targetBook = bookCatalog.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow(() -> new Exception("Book with ISBN " + isbn + " not found in catalog"));

        if (targetBook.isIssued()) {
            throw new IllegalStateException("Book is already issued to another member");
        }

        Member targetMember = members.stream()
                .filter(m -> m.getMemberId().equals(memberId))
                .findFirst()
                .orElseThrow(() -> new Exception("Member ID " + memberId + " not registered"));

        targetBook.setIssued(true);
        targetMember.getBorrowedBooks().add(targetBook);
        System.out.println("Success: Issued '" + targetBook.getTitle() + "' to " + targetMember.getName());
    }

    public static void main(String[] args) {
        System.out.println("--- Assignment 1: Library Management System ---");
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBook(new Book("ISBN-101", "Clean Code", "Robert C. Martin"));
        library.addBook(new Book("ISBN-102", "Effective Java", "Joshua Bloch"));

        library.registerMember(new Member("MEM-01", "Ashish Kumar"));

        try {
            library.issueBook("ISBN-101", "MEM-01");
            // Attempt to issue already issued book to test exception handling
            library.issueBook("ISBN-101", "MEM-01");
        } catch (Exception e) {
            System.out.println("Exception handled: " + e.getMessage());
        }
    }
}
