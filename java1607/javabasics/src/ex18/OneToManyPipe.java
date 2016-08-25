package ex18;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.Scanner;

public class OneToManyPipe implements Runnable{
	Socket s;
	Collection<Socket> os;

	public OneToManyPipe(Socket s, Collection<Socket> os) {
		super();
		this.s = s;
		this.os = os;
	}

	@Override
	public void run() {
		try {
			Scanner sc = new Scanner(s.getInputStream());
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				for (Socket ss : os) {
					PrintWriter pr = new PrintWriter(ss.getOutputStream());
					pr.println(s.getInetAddress() + " : " + line);
					pr.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
