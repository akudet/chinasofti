package ex17;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ex18.CharacterPipe;
import ex18.OneToManyPipe;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9999);
		
		List<Socket> os = new ArrayList<Socket>();

		while (true) {
			Socket s = ss.accept();
			OneToManyPipe p = new OneToManyPipe(s, os);
			os.add(s);
			new Thread(p).start();
		}
	}
}
