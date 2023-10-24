package Week07_02;
import java.io.*;
import java.util.Scanner;

public class UserInform {
    public static void main(String[] args) throws IOException {
        int num2;
        String search;
        String num, name, tel, email;
        Scanner scan = null;
        PrintWriter in = new PrintWriter(new FileWriter("user.txt"));
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("번호: ");
            num = s.next();
            System.out.println("이름: ");
            name = s.next();
            System.out.println("전화번호: ");
            tel = s.next();
            System.out.println("이메일: ");
            email = s.next();
            System.out.println("입력이 끝났으면 1, 계속하려면 0;");
            num2 = s.nextInt();
            in.print(num + "," + name + "," + tel + "," + email + " ");
            in.flush();
            if (num2 == 1)
                break;
        }
        in.close();

        System.out.println("검색할 번호를 입력하세요: ");
        search = s.next();

        BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            for (String part : parts) {
                String[] userInfo = part.split(",");
                if (userInfo.length >= 3 && userInfo[0].equals(search)) {
                    System.out.println("이름: " + userInfo[1]);
                    System.out.println("전화번호: " + userInfo[2]);
                    System.out.println("이메일: " + userInfo[3]);
                    break;
                }
            }
        }
        reader.close();
    }
}
