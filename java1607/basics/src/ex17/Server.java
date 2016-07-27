package ex17;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

import ex18.CharacterPipe;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9999);
		
		Socket s = ss.accept();
		new Thread(new CharacterPipe(s.getInputStream(), System.out)).start();
		new Thread(new CharacterPipe(System.in, s.getOutputStream())).start();
	}
}
