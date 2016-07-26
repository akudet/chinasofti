package ex17;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9999);
		
		Socket s = ss.accept();
		Scanner scan = new Scanner(s.getInputStream());
		scan.useDelimiter("");
		while (scan.hasNext()) {
			System.out.print(scan.next());
		}
		scan.close();
		
	}
}
