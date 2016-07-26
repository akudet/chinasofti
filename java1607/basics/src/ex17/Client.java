package ex17;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("172.21.12.222", 9999);
		OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
		osw.write("nihao aaaa and zaijian", 0, 10);
		osw.close();
		InputStreamReader isr = new InputStreamReader(s.getInputStream());
		char[] cbuf = new char[1024];
		int len = isr.read(cbuf);
		System.out.println(new String(cbuf, 0, len));
	}
	
}
