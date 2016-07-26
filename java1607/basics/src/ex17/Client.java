package ex17;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
//		Socket s = new Socket("172.21.12.222", 9999);
		Socket s = new Socket("127.0.0.1", 9999);
		OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
		osw.write("nihao aaaa and zaijian");
		osw.close();
	}
	
}
