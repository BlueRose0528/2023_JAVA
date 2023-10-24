package Week07_01;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\DS\\input.txt");
        File file2 = new File("C:\\Users\\DS\\output.txt");

        BufferedReader in = new BufferedReader(new FileReader(file1));
        PrintWriter out = new PrintWriter(new FileWriter(file2));

        int ch;
        
        while ((ch = in.read()) != -1) {
            char character = (char) ch;
            if (Character.isLowerCase(character)) {
                character = Character.toUpperCase(character);
            }
            out.write(character);
        }

        in.close();
        out.close();
        
        System.out.println("파일 변환이 완료되었으니 확인 바랍니다.");
        }
        
 }
    