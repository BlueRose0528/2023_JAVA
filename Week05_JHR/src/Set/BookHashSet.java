package Set;

import java.util.HashSet;
import java.util.Iterator;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + "]";
    }
}

public class BookHashSet {
    private HashSet<Book> hashSet;

    public BookHashSet() {
        hashSet = new HashSet<>();
    }

    public void addBook(Book book) {
        hashSet.add(book);
    }

    public boolean removeBook(int bookId) {
        Iterator<Book> iterator = hashSet.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            int tempId = book.getBookId();
            if (tempId == bookId) {
                iterator.remove();
                return true;
            }
        }
        System.out.println(bookId + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllBooks() {
        for (Book book : hashSet) {
            System.out.println(book);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BookHashSet bookHashSet = new BookHashSet();
        bookHashSet.addBook(new Book(1, "상실의 시대", "무라카미 하루키"));
        bookHashSet.addBook(new Book(2, "죽음", "베르나르 베르베르"));
        bookHashSet.addBook(new Book(3, "아침 그리고 저녁", "욘 포세"));
        bookHashSet.addBook(new Book(4, "틀을 깨는 사고력", "양첸룽"));
        bookHashSet.addBook(new Book(5, "확신에 찬 헛소리들과 그 이유", "필리프 슈테르처"));
        bookHashSet.addBook(new Book(6, "릭 루빈", "창조적 행위"));
        bookHashSet.addBook(new Book(7, "안드라스 쉬프", "안드라스 쉬프"));
        bookHashSet.addBook(new Book(8, "단 한 사람", "최진영"));

        bookHashSet.showAllBooks();

    }
}

