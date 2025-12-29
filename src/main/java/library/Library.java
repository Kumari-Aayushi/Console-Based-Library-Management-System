package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Member> members;
    private FileHandler fileHandler;

    public Library() {
        fileHandler = new FileHandler();
        books = fileHandler.loadBooks();
        members = fileHandler.loadMembers();
    }

    public void addBook(Book book) {
        books.add(book);
        fileHandler.saveBooks(books);
        System.out.println("Book added successfully.");
    }

    public void registerMember(Member member) {
        members.add(member);
        fileHandler.saveMembers(members);
        System.out.println("Member registered successfully.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        books.forEach(System.out::println);
    }

    public Book findBook(String isbn) {
        return books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    public Member findMember(String id) {
        return members.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    public void borrowBook(String isbn, String memberId) {
        Book book = findBook(isbn);
        Member member = findMember(memberId);

        if (book == null || member == null || !book.isAvailable()) {
            System.out.println("Borrowing failed.");
            return;
        }

        book.setAvailable(false);
        book.setBorrowedBy(memberId);
        book.setDueDate(LocalDate.now().plusDays(14));
        member.borrowBook(isbn);

        fileHandler.saveBooks(books);
        fileHandler.saveMembers(members);

        System.out.println("Book borrowed. Due Date: " + book.getDueDate());
    }

    public void returnBook(String isbn, String memberId) {
        Book book = findBook(isbn);
        Member member = findMember(memberId);

        if (book == null || member == null) {
            System.out.println("Return failed.");
            return;
        }

        book.setAvailable(true);
        book.setBorrowedBy(null);
        book.setDueDate(null);
        member.returnBook(isbn);

        fileHandler.saveBooks(books);
        fileHandler.saveMembers(members);

        System.out.println("Book returned successfully.");
    }

    public void showStatistics() {
        long available = books.stream().filter(Book::isAvailable).count();
        long borrowed = books.size() - available;

        System.out.println("Total Books: " + books.size());
        System.out.println("Available: " + available);
        System.out.println("Borrowed: " + borrowed);
        System.out.println("Members: " + members.size());
    }
}
