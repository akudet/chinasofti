package ex18;

import java.io.*;
import java.util.Scanner;

public class CharacterPipe implements Runnable {
	InputStream is;
	OutputStream os;
	
	@Override
	public void run() {
		PrintWriter pr = new PrintWriter(os);
		Scanner sc = new Scanner(is);
		while (sc.hasNextLine()) {
			pr.println(sc.nextLine());
			pr.flush();
		}
	}

	public CharacterPipe(InputStream is, OutputStream os) {
		super();
		this.is = is;
		this.os = os;
	}
	
}
