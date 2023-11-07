package Week09_01;

import java.util.Scanner;

public class CountDownApp{
    public static void main(String[] args) {
        int count = 10; // 초기 카운트 다운 값
        boolean isCounting = false; // 카운트 중인지 여부를 나타내는 플래그

        Scanner scanner = new Scanner(System.in);

        while (count >= 0) {
            System.out.println("현재 카운트: " + count);
            System.out.println("1. 카운트 시작");
            System.out.println("2. 카운트 중지");
            System.out.println("3. 종료");
            System.out.print("선택: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    if (!isCounting) {
                        isCounting = true;
                        startCountdown(count);
                    } else {
                        System.out.println("이미 카운트 중입니다.");
                    }
                    break;
                case 2:
                    if (isCounting) {
                        isCounting = false;
                        System.out.println("카운트를 중지했습니다.");
                    } else {
                        System.out.println("카운트가 이미 중지되었습니다.");
                    }
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    private static void startCountdown(int count) {
        while (count >= 0) {
            System.out.println("카운트: " + count);
            count--;

            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}