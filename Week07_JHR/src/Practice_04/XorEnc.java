package Practice_04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XorEnc {
    static byte[] key = {10, 20, 30, 40};

    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream("C:\\Users\\DS\\convert.txt");
        FileOutputStream os = new FileOutputStream("C:\\Users\\DS\\convertout.txt");

        byte[] data = new byte[1024];
        int read = is.read(data);
        int index = 0;
        while (read != -1) {
            for (int k = 0; k < read; k++) {
                data[k] ^= key[index % key.length];
                index++;
            }
            os.write(data, 0, read);
            read = is.read(data);
        }
        os.flush();
        os.close();
        is.close();
    }
}
