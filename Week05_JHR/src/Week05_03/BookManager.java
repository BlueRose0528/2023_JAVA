package Week05_03;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int bookID;
    private String bookName;

    public Book(int bookID, String bookName) {
        this.bookID = bookID;
        this.bookName = bookName;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return "도서 ID: " + bookID + ", 도서 이름: " + bookName;
    }
}

public class BookManager {
    private ArrayList<Book> bookList;

    public BookManager() {
        bookList = new ArrayList<>();
    }

    public void addBook(int bookID, String bookName) {
        Book book = new Book(bookID, bookName);
        bookList.add(book);
    }

    public void removeBook(int bookID) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBookID() == bookID) {
                bookList.remove(i);
                return;
            }
        }
        System.out.println("해당 도서 ID를 가진 도서를 찾을 수 없습니다.");
    }

    public void showAllBooks() {
        System.out.println("도서 목록:");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void insertBook(int index, int bookID, String bookName) {
        if (index >= 0 && index <= bookList.size()) {
            Book book = new Book(bookID, bookName);
            bookList.add(index, book);
        } else {
            System.out.println("유효하지 않은 삽입 위치입니다.");
        }
    }

    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        Scanner scanner = new Scanner(System.in);

        bookManager.addBook(1, "파우스트");
        bookManager.addBook(2, "황무지");
        bookManager.addBook(3, "변신");
        bookManager.addBook(4, "픽션들");
        bookManager.addBook(5, "안나 카레니나");
        
        while (true) {
            System.out.println("\n도서 관리 프로그램");
            System.out.println("1. 도서 목록 출력");
            System.out.println("2. 도서 추가");
            System.out.println("3. 도서 삭제");
            System.out.println("4. 특정 위치에 도서 추가");
            System.out.println("5. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    bookManager.showAllBooks();
                    break;
                case 2:
                    System.out.print("도서 ID를 입력하세요: ");
                    int addID = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("도서 이름을 입력하세요: ");
                    String addName = scanner.nextLine();
                    bookManager.addBook(addID, addName);
                    break;
                case 3:
                    System.out.print("삭제할 도서의 ID를 입력하세요: ");
                    int removeID = scanner.nextInt();
                    bookManager.removeBook(removeID);
                    break;
                case 4:
                    System.out.print("삽입할 위치를 입력하세요: ");
                    int insertIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("도서 ID를 입력하세요: ");
                    int insertID = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("도서 이름을 입력하세요: ");
                    String insertName = scanner.nextLine();
                    bookManager.insertBook(insertIndex, insertID, insertName);
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }
}
