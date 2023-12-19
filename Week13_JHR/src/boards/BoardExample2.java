package boards;

import java.util.Scanner;

public class BoardExample2 {
    public void list() {
        System.out.println();
        System.out.println("[게시물 목록]");
       

        mainMenu();
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("메인메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
        System.out.print("메뉴선택: ");

        Scanner scanner = new Scanner(System.in);
        String menuNo = scanner.nextLine();

        switch (menuNo) {
            case "1":
                create();
                break;
            case "2":
                read();
                break;
            case "3":
                clear();
                break;
            case "4":
                exit();
                break;
            default:
                System.out.println("잘못된 메뉴 선택입니다.");
                mainMenu(); 
                break;
        }
    }

    public void create() {
        System.out.println("*** create 메소드 실행됨");
        list();
    }

    public void read() {
        System.out.println("*** read 메소드 실행됨");
        list();
    }

    public void clear() {
        System.out.println("*** clear 메소드 실행됨");
        list();
    }

    public void exit() {
        System.out.println("*** 종료합니다. ***");
        System.exit(0);
    }

    public static void main(String[] args) {
        BoardExample2 boardExample = new BoardExample2();
        boardExample.list();
    }
}
