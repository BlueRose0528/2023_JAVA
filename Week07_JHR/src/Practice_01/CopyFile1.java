package Practice_01;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile1 {

	public static void main(String[] args) throws IOException {
		try(FileReader in=new FileReader("C:\\Users\\DS\\test.txt");
				FileWriter out=new FileWriter("C:\\Users\\DS\\copy.txt")){
					int c;
					while((c=in.read()) !=-1) {
						out.write(c);
					}
				}
		// TODO Auto-generated method stub

	}

}
